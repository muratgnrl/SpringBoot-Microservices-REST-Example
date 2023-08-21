package com.example.stokbes.entity;

import jakarta.persistence.*;

import java.util.List;

@Entity
public class Category {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)

    private int categoryId;
    private String categoryName;
    private String categoryDescription;
    @OneToMany(mappedBy = "category")
    private List<Product>productslist;




    public int getCategoryId() {
        return categoryId;
    }

    public void setCategoryId(int categoryId) {
        this.categoryId = categoryId;
    }

    public String getCategoryName() {
        return categoryName;
    }

    public void setCategoryName(String categoryName) {
        this.categoryName = categoryName;
    }

    public String getCategoryDescription() {
        return categoryDescription;
    }

    public void setCategoryDescription(String categoryDescription) {
        this.categoryDescription = categoryDescription;
    }

    public List<Product> getProductslist() {
        return productslist;
    }

    public void setProductslist(List<Product> productslist) {
        this.productslist = productslist;
    }

    public Category(int categoryId, String categoryName, String categoryDescription, List<Product> productslist) {
        this.categoryId = categoryId;
        this.categoryName = categoryName;
        this.categoryDescription = categoryDescription;
        this.productslist = productslist;
    }

    public Category() {
    }
}
