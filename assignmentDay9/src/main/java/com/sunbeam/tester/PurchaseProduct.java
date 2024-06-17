package com.sunbeam.tester;

import com.sunbeam.dao.ProductDao;
import com.sunbeam.dao.ProductDaoImpl;
import org.hibernate.SessionFactory;
import static com.sunbeam.utils.HibernateUtils.getFactory;

import java.util.Scanner;

public class PurchaseProduct {

    public static void main(String[] args) {
        try (SessionFactory sf = getFactory();
             Scanner sc = new Scanner(System.in)) {
            ProductDao dao = new ProductDaoImpl();
            System.out.println("Enter product ID and quantity to purchase");
            Long productId = sc.nextLong();
            int quantity = sc.nextInt();
            String result = dao.purchaseProduct(productId, quantity);
            System.out.println(result);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
