package com.sunbeam.tester;

import com.sunbeam.dao.ProductDao;
import com.sunbeam.dao.ProductDaoImpl;
import com.sunbeam.entities.Category;
import com.sunbeam.entities.Product;
import org.hibernate.SessionFactory;
import static com.sunbeam.utils.HibernateUtils.getFactory;

import java.util.List;
import java.util.Scanner;

public class GetProductsByCategoryAndPriceRange {

    public static void main(String[] args) {
        try (SessionFactory sf = getFactory();
             Scanner sc = new Scanner(System.in)) {
            ProductDao dao = new ProductDaoImpl();
            System.out.println("Enter category (BAKERY, SHOES, CLOTHES, STATIONARY), minimum price, and maximum price");
            Category category = Category.valueOf(sc.next().toUpperCase());
            double minPrice = sc.nextDouble();
            double maxPrice = sc.nextDouble();
            List<Product> products = dao.getProductsByCategoryAndPriceRange(category, minPrice, maxPrice);
            products.forEach(System.out::println);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
