package com.sunbeam.tester;

import com.sunbeam.dao.ProductDao;
import com.sunbeam.dao.ProductDaoImpl;
import com.sunbeam.entities.Category;
import org.hibernate.SessionFactory;
import static com.sunbeam.utils.HibernateUtils.getFactory;

import java.util.Scanner;

public class ApplyDiscountToCategory {

    public static void main(String[] args) {
        try (SessionFactory sf = getFactory();
             Scanner sc = new Scanner(System.in)) {
            ProductDao dao = new ProductDaoImpl();
            System.out.println("Enter category (BAKERY, SHOES, CLOTHES, STATIONARY) and discount percentage");
            Category category = Category.valueOf(sc.next().toUpperCase());
            double discount = sc.nextDouble();
            String result = dao.applyDiscountToCategory(category, discount);
            System.out.println(result);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
