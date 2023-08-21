package com.example.stokbes.repository;

import com.example.stokbes.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductRepository extends JpaRepository<Product,Integer> {
    Product findProductByProductId(int productId);
}
