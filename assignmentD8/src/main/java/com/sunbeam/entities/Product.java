package com.sunbeam.entities;

import javax.persistence.*;

@Entity
@Table(name = "products")
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    @Enumerated(EnumType.STRING)
    @Column(length = 20)
    private Category category;
    
    @Column(name = "product_name", unique = true, length = 100)
    private String productName;
    
    private double price;
    
    @Column(name = "available_quantity")
    private int availableQuantity;

    // Default constructor
    public Product() {}

    // Parameterized constructor
    public Product(Category category, String productName, double price, int availableQuantity) {
        this.category = category;
        this.productName = productName;
        this.price = price;
        this.availableQuantity = availableQuantity;
    }

    // Getters and setters
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public int getAvailableQuantity() {
        return availableQuantity;
    }

    public void setAvailableQuantity(int availableQuantity) {
        this.availableQuantity = availableQuantity;
    }

    @Override
    public String toString() {
        return "Product [id=" + id + ", category=" + category + ", productName=" + productName + ", price=" + price
                + ", availableQuantity=" + availableQuantity + "]";
    }
}
