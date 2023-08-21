package com.example.stokbes.mapper;

import com.example.stokbes.dto.ProductDto;
import com.example.stokbes.entity.Product;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2023-08-20T18:23:37+0300",
    comments = "version: 1.4.1.Final, compiler: javac, environment: Java 17.0.5 (Amazon.com Inc.)"
)
@Component
public class ProductMapperImpl implements ProductMapper {

    @Override
    public ProductDto toResource(Product e) {
        if ( e == null ) {
            return null;
        }

        ProductDto productDto = new ProductDto();

        productDto.productId = e.getProductId();
        productDto.productName = e.getProductName();
        productDto.productDescription = e.getProductDescription();

        return productDto;
    }

    @Override
    public Product toEntity(ProductDto r) {
        if ( r == null ) {
            return null;
        }

        Product product = new Product();

        product.setProductId( r.productId );
        product.setProductName( r.productName );
        product.setProductDescription( r.productDescription );

        return product;
    }

    @Override
    public List<ProductDto> toResource(List<Product> eList) {
        if ( eList == null ) {
            return null;
        }

        List<ProductDto> list = new ArrayList<ProductDto>( eList.size() );
        for ( Product product : eList ) {
            list.add( toResource( product ) );
        }

        return list;
    }

    @Override
    public List<Product> toEntity(List<ProductDto> rList) {
        if ( rList == null ) {
            return null;
        }

        List<Product> list = new ArrayList<Product>( rList.size() );
        for ( ProductDto productDto : rList ) {
            list.add( toEntity( productDto ) );
        }

        return list;
    }
}
