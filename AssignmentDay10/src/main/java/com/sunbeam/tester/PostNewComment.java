package com.sunbeam.tester;

import static com.sunbeam.utils.HibernateUtils.getFactory;

import java.util.Scanner;

import org.hibernate.SessionFactory;

import com.sunbeam.dao.CommentDao;
import com.sunbeam.dao.CommentDaoImpl;
import com.sunbeam.entities.Comment;

public class PostNewComment {

	public static void main(String[] args) {
		try (SessionFactory sf = getFactory(); Scanner sc = new Scanner(System.in)) {
			// create comment dao instance
			CommentDao dao=new CommentDaoImpl();
			System.out.println("Enter comment text , rating , "
					+ "commenter id n blog post id");
			System.out.println(dao.postNewComment(
					new Comment(sc.next(),sc.nextInt()), sc.nextLong(), sc.nextLong()));
			
		} // JVM : sc.close() , sf.close() -> DBCP will be cleaned up !
		catch (Exception e) {
			e.printStackTrace();
		}

	}

}
