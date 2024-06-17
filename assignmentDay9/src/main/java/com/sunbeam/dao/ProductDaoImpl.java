package com.sunbeam.dao;

import com.sunbeam.entities.Product;
import com.sunbeam.entities.Category;
import org.hibernate.*;
import static com.sunbeam.utils.HibernateUtils.getFactory;

import java.io.Serializable;
import java.util.List;

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

    @Override
    public List<Product> getProductsByCategoryAndPriceRange(Category category, double minPrice, double maxPrice) {
        List<Product> products = null;
        Session session = getFactory().getCurrentSession();
        Transaction tx = session.beginTransaction();
        try {
            Query<Product> query = session.createQuery("FROM Product WHERE category = :category AND price BETWEEN :minPrice AND :maxPrice", Product.class);
            query.setParameter("category", category);
            query.setParameter("minPrice", minPrice);
            query.setParameter("maxPrice", maxPrice);
            products = query.getResultList();
            tx.commit();
        } catch (RuntimeException e) {
            if (tx != null)
                tx.rollback();
            throw e;
        }
        return products;
    }

    @Override
    public String applyDiscountToCategory(Category category, double discount) {
        String message = "Discount application failed!!!!";
        Session session = getFactory().getCurrentSession();
        Transaction tx = session.beginTransaction();
        try {
            Query query = session.createQuery("UPDATE Product SET price = price - (price * :discount / 100) WHERE category = :category");
            query.setParameter("discount", discount);
            query.setParameter("category", category);
            int updatedProducts = query.executeUpdate();
            tx.commit();
            message = "Discount applied successfully to " + updatedProducts + " products.";
        } catch (RuntimeException e) {
            if (tx != null)
                tx.rollback();
            throw e;
        }
        return message;
    }

    @Override
    public String purchaseProduct(Long productId, int quantity) {
        String message = "Product purchase failed!!!!";
        Session session = getFactory().getCurrentSession();
        Transaction tx = session.beginTransaction();
        try {
            Product product = session.get(Product.class, productId);
            if (product != null && product.getAvailableQuantity() >= quantity) {
                product.setAvailableQuantity(product.getAvailableQuantity() - quantity);
                tx.commit();
                message = "Product purchased successfully.";
            } else {
                message = "Insufficient product quantity.";
                tx.rollback();
            }
        } catch (RuntimeException e) {
            if (tx != null)
                tx.rollback();
            throw e;
        }
        return message;
    }

    @Override
    public String deleteProductByName(String productName) {
        String message = "Product deletion failed!!!!";
        Session session = getFactory().getCurrentSession();
        Transaction tx = session.beginTransaction();
        try {
            Query<Product> query = session.createQuery("FROM Product WHERE productName = :productName", Product.class);
            query.setParameter("productName", productName);
            Product product = query.uniqueResult();
            if (product != null) {
                session.delete(product);
                tx.commit();
                message = "Product deleted successfully.";
            } else {
                message = "Product not found.";
                tx.rollback();
            }
        } catch (RuntimeException e) {
            if (tx != null)
                tx.rollback();
            throw e;
        }
        return message;
    }
}
