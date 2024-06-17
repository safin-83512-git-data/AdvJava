package com.sunbeam.dao;

import com.sunbeam.entities.Product;
import com.sunbeam.entities.Category;

import java.util.List;

public interface ProductDao {
    String addProduct(Product product);
    Product getProductById(Long productId);
    List<Product> getProductsByCategoryAndPriceRange(Category category, double minPrice, double maxPrice);
    String applyDiscountToCategory(Category category, double discount);
    String purchaseProduct(Long productId, int quantity);
    String deleteProductByName(String productName);
}
