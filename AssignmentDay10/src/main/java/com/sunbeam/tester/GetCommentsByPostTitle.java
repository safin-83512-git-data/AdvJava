package com.sunbeam.tester;

import static com.sunbeam.utils.HibernateUtils.getFactory;

import java.util.Scanner;

import org.hibernate.SessionFactory;

import com.sunbeam.dao.CommentDao;
import com.sunbeam.dao.CommentDaoImpl;

public class GetCommentsByPostTitle {

	public static void main(String[] args) {
		try (SessionFactory sf = getFactory(); 
				Scanner sc = new Scanner(System.in)) {
			// create comment dao instance
			CommentDao dao = new CommentDaoImpl();
			// for testing - do not add any white space
			System.out.println("Enter post title , to list it's comments ");
			System.out.println("All comments for the given post title");
			dao.getCommentsByPost(sc.next())
			.forEach(System.out::println);
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

}
