package com.sunbeam.dao;

import com.sunbeam.entities.Product;

public interface ProductDao {
    String addProduct(Product product);
    Product getProductById(Long productId);
}
