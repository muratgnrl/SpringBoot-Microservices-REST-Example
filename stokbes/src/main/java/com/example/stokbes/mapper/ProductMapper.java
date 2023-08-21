package com.example.stokbes.mapper;

import com.example.stokbes.dto.ProductDto;
import com.example.stokbes.entity.Product;
import org.mapstruct.Mapper;
import org.springframework.stereotype.Component;


@Component
@Mapper(componentModel = "spring")
public interface ProductMapper extends IEntityMapper<ProductDto, Product>{
}
