package com.sunbeam.tester;

import static com.sunbeam.utils.HibernateUtils.getFactory;

import java.util.Scanner;

import org.hibernate.SessionFactory;

import com.sunbeam.dao.BlogPostDao;
import com.sunbeam.dao.BlogPostDaoImpl;

public class RemoveBlogFromCategory {

	public static void main(String[] args) {
		try (SessionFactory sf = getFactory();
				Scanner sc=new Scanner(System.in)) {
			BlogPostDao dao=new BlogPostDaoImpl();
			System.out.println("Enter category id n blog id , to remove a post from given category");			
			System.out.println(dao.removeBlog(sc.nextLong(),sc.nextLong()));
			
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

}
