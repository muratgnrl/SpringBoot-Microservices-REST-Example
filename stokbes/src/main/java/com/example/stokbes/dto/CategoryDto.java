package com.example.stokbes.dto;

import com.example.stokbes.entity.Product;
import jakarta.persistence.OneToMany;


import java.io.Serializable;
import java.util.List;

public class CategoryDto implements Serializable {

    public int categoryId;
    public String categoryName;
    public String categoryDescription;
    public List<Product> productslist;

}
