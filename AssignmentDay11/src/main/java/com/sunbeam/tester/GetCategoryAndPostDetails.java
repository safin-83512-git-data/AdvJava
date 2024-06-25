package com.sunbeam.tester;

import static com.sunbeam.utils.HibernateUtils.getFactory;

import java.util.Scanner;

import org.hibernate.SessionFactory;

import com.sunbeam.dao.CategoryDao;
import com.sunbeam.dao.CategoryDaoImpl;
import com.sunbeam.entities.Category;

public class GetCategoryAndPostDetails {

	public static void main(String[] args) {
		try (SessionFactory sf = getFactory(); Scanner sc = new Scanner(System.in)) {
			// create category dao instance
			CategoryDao dao = new CategoryDaoImpl();			
			System.out.println("Enter category name to search");			
			Category category=dao.getCategoryAndPostDetails(sc.next());
			System.out.println(category);
			System.out.println("All posts - ");
			category.getPosts().
			forEach(System.out::println);
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

}
