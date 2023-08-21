package com.example.stokbes.dto;

import com.example.stokbes.entity.Category;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

import java.io.Serializable;

public class ProductDto implements Serializable {

    public int productId;
    public String productName;
    public String productDescription;
    public int categoryId;
}
