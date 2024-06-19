package com.sunbeam.tester;

import static com.sunbeam.utils.HibernateUtils.getFactory;

import java.util.Scanner;

import org.hibernate.SessionFactory;

import com.sunbeam.dao.CategoryDao;
import com.sunbeam.dao.CategoryDaoImpl;
import com.sunbeam.entities.Category;

public class GetOrLoadCategoryDetails {

	public static void main(String[] args) {
		try (SessionFactory sf = getFactory(); 
				Scanner sc = new Scanner(System.in)) {
			// create category dao instance
			CategoryDao dao = new CategoryDaoImpl();

			System.out.println("Enter category name to search");
			Category category = dao.getCategoryDetails(sc.next());
			System.out.println(category);

		} catch (Exception e) {
			e.printStackTrace();
		}

	}

}
