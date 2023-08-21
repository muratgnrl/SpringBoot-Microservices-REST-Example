package com.example.stokbes.service;

import com.example.stokbes.dto.ProductDto;
import com.example.stokbes.entity.Category;
import com.example.stokbes.entity.Product;
import com.example.stokbes.mapper.ProductMapper;
import com.example.stokbes.repository.ProductRepository;
import com.example.stokbes.response.ProductResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ProductService {

    public final ProductMapper productMapper;
    public final ProductRepository productRepository;
    public final CategoryService categoryService;

    public ProductResponse addProduct(ProductDto productDto) {
        Product product = productMapper.toEntity(productDto);
        Category category = categoryService.findCategory(productDto.categoryId);
        product.setCategory(category);
        product = productRepository.save(product);
        return generateProductResult(productMapper.toResource(product));
    }

    private ProductResponse generateProductResult(ProductDto toResource) {

        ProductResponse productResponse = new ProductResponse();
        productResponse.productDto = toResource;
        return productResponse;
    }

    public ProductDto findProductByDto(int productId) {

        Product product = findProduct(productId);
        return productMapper.toResource(product);
    }

    private Product findProduct(int productId) {
        Product product = productRepository.findProductByProductId(productId);
        return product;
    }

   public List<ProductDto> GetAllProduct() {
        return productMapper.toResource(GetProductList());

    }

    private List<Product> GetProductList() {
        return productRepository.findAll();
    }
}