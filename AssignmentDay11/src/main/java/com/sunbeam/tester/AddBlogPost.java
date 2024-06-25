package com.sunbeam.tester;

import static com.sunbeam.utils.HibernateUtils.getFactory;

import java.util.Scanner;

import org.hibernate.SessionFactory;

import com.sunbeam.dao.BlogPostDao;
import com.sunbeam.dao.BlogPostDaoImpl;
import com.sunbeam.entities.BlogPost;

public class AddBlogPost {

	public static void main(String[] args) {
		try (SessionFactory sf = getFactory(); 
				Scanner sc = new Scanner(System.in)) {
			// create blog post dao instance
			BlogPostDao dao = new BlogPostDaoImpl();
			System.out.println("Enter blog post - title , desc , contents n category id n blogger id");
			BlogPost newPost = new BlogPost(sc.next(), sc.next(), sc.next());
			System.out.println(dao.createNewPost(newPost, sc.nextLong(), sc.nextLong()));
		} // JVM : sc.close() , sf.close() -> DBCP will be cleaned up !
		catch (Exception e) {
			e.printStackTrace();
		}

	}

}
