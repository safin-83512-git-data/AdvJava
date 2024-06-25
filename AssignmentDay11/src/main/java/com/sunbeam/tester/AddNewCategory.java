package com.sunbeam.tester;

import static com.sunbeam.utils.HibernateUtils.getFactory;

import java.util.Scanner;

import org.hibernate.SessionFactory;

import com.sunbeam.dao.CategoryDao;
import com.sunbeam.dao.CategoryDaoImpl;
import com.sunbeam.dao.UserDao;
import com.sunbeam.dao.UserDaoImpl;
import com.sunbeam.entities.Category;

public class AddNewCategory {

	public static void main(String[] args) {
		try (SessionFactory sf = getFactory();
				Scanner sc=new Scanner(System.in)) {
			// createcategory dao instance
			CategoryDao dao=new CategoryDaoImpl();
			System.out.println("Enter category name n desc");
			//While testing - DO NOT add white spaces in the i/ps 
			Category category=new Category(sc.next(),sc.next());
			System.out.println(dao.addNewCategory(category));
		} // JVM : sc.close() , sf.close() -> DBCP will ebe cleaned up !
		catch (Exception e) {
			e.printStackTrace();
		}

	}

}
