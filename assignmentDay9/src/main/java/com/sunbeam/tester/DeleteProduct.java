package com.sunbeam.tester;

import com.sunbeam.dao.ProductDao;
import com.sunbeam.dao.ProductDaoImpl;
import org.hibernate.SessionFactory;
import static com.sunbeam.utils.HibernateUtils.getFactory;

import java.util.Scanner;

public class DeleteProduct {

    public static void main(String[] args) {
        try (SessionFactory sf = getFactory();
             Scanner sc = new Scanner(System.in)) {
            ProductDao dao = new ProductDaoImpl();
            System.out.println("Enter product name to delete");
            String productName = sc.next();
            String result = dao.deleteProductByName(productName);
            System.out.println(result);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
