package com.example.stokbes.mapper;


import com.example.stokbes.dto.CategoryDto;
import com.example.stokbes.entity.Category;
import org.springframework.stereotype.Component;
import org.mapstruct.Mapper;

@Component
@Mapper(componentModel = "spring")
public interface CategoryMapper extends IEntityMapper<CategoryDto, Category>{
}
