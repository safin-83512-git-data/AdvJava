package com.sunbeam.tester;

import static com.sunbeam.utils.HibernateUtils.getFactory;

import java.util.Scanner;

import org.hibernate.SessionFactory;

import com.sunbeam.dao.UserDao;
import com.sunbeam.dao.UserDaoImpl;

public class SignInUser {

	public static void main(String[] args) {
		try (SessionFactory sf = getFactory(); 
				Scanner sc = new Scanner(System.in)) {
			// create user dao instance
			UserDao dao = new UserDaoImpl();
			System.out.println("Enter email n password");
			System.out.println(dao.signIn(sc.next(), sc.next()));					
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

}
