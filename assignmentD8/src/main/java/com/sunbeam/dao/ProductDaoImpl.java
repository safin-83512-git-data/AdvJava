package com.sunbeam.dao;

import com.sunbeam.entities.Product;
import org.hibernate.*;
import static com.sunbeam.utils.HibernateUtils.getFactory;

import java.io.Serializable;

public class ProductDaoImpl implements ProductDao {

    @Override
    public String addProduct(Product product) {
        String message = "Product registration failed!!!!";
        Session session = getFactory().getCurrentSession();
        Transaction tx = session.beginTransaction();
        try {
            Serializable productId = session.save(product);
            tx.commit();
            message = "Product registered successfully, with ID " + productId;
        } catch (RuntimeException e) {
            if (tx != null)
                tx.rollback();
            throw e;
        }
        return message;
    }

    @Override
    public Product getProductById(Long productId) {
        Product product = null;
        Session session = getFactory().getCurrentSession();
        Transaction tx = session.beginTransaction();
        try {
            product = session.get(Product.class, productId);
            tx.commit();
        } catch (RuntimeException e) {
            if (tx != null)
                tx.rollback();
            throw e;
        }
        return product;
    }
}
