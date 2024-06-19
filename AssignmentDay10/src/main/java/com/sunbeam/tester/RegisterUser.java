package com.sunbeam.tester;

import org.hibernate.SessionFactory;

import com.sunbeam.dao.UserDao;
import com.sunbeam.dao.UserDaoImpl;
import com.sunbeam.entities.Role;
import com.sunbeam.entities.User;

import static com.sunbeam.utils.HibernateUtils.getFactory;

import java.time.LocalDate;
import java.util.Scanner;

public class RegisterUser {

	public static void main(String[] args) {
		try (SessionFactory sf = getFactory(); Scanner sc = new Scanner(System.in)) {
			// create dao instance
			UserDao dao = new UserDaoImpl();
			System.out.println("Enter User details -firstName, String lastName, \r\n"
					+ "			String email, String password, LocalDate dob, double regAmount,\r\n"
					+ "			Role role");
			User newUser = new User(sc.next(), sc.next(), sc.next(), sc.next(), LocalDate.parse(sc.next()),
					sc.nextDouble(), Role.valueOf(sc.next().toUpperCase()));// transient - exists only in heap , not yet
																			// part of l1 cache , not in DB
				System.out.println(dao.signUp(newUser));
		} // JVM : sc.close() , sf.close() -> DBCP will be cleaned up !
		catch (Exception e) {
			e.printStackTrace();
		}

	}

}
