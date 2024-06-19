package com.sunbeam.tester;

import static com.sunbeam.utils.HibernateUtils.getFactory;

import java.util.Scanner;

import org.hibernate.SessionFactory;

import com.sunbeam.dao.UserDao;
import com.sunbeam.dao.UserDaoImpl;

public class GetAllUsers {

	public static void main(String[] args) {
		try (SessionFactory sf = getFactory()) {
			// create dao instance
			UserDao dao = new UserDaoImpl();
			dao.getAllUsers() //List<User>
			.forEach(System.out::println);//u -> System.out.println(u)
		} // JVM : sc.close() , sf.close() -> DBCP will be cleaned up !
		catch (Exception e) {
			e.printStackTrace();
		}

	}

}
