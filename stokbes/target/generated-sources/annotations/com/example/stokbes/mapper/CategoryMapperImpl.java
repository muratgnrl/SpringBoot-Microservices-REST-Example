package com.example.stokbes.mapper;

import com.example.stokbes.dto.CategoryDto;
import com.example.stokbes.entity.Category;
import com.example.stokbes.entity.Product;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2023-08-20T18:23:36+0300",
    comments = "version: 1.4.1.Final, compiler: javac, environment: Java 17.0.5 (Amazon.com Inc.)"
)
@Component
public class CategoryMapperImpl implements CategoryMapper {

    @Override
    public CategoryDto toResource(Category e) {
        if ( e == null ) {
            return null;
        }

        CategoryDto categoryDto = new CategoryDto();

        categoryDto.categoryId = e.getCategoryId();
        categoryDto.categoryName = e.getCategoryName();
        categoryDto.categoryDescription = e.getCategoryDescription();
        List<Product> list = e.getProductslist();
        if ( list != null ) {
            categoryDto.productslist = new ArrayList<Product>( list );
        }

        return categoryDto;
    }

    @Override
    public Category toEntity(CategoryDto r) {
        if ( r == null ) {
            return null;
        }

        Category category = new Category();

        category.setCategoryId( r.categoryId );
        category.setCategoryName( r.categoryName );
        category.setCategoryDescription( r.categoryDescription );
        List<Product> list = r.productslist;
        if ( list != null ) {
            category.setProductslist( new ArrayList<Product>( list ) );
        }

        return category;
    }

    @Override
    public List<CategoryDto> toResource(List<Category> eList) {
        if ( eList == null ) {
            return null;
        }

        List<CategoryDto> list = new ArrayList<CategoryDto>( eList.size() );
        for ( Category category : eList ) {
            list.add( toResource( category ) );
        }

        return list;
    }

    @Override
    public List<Category> toEntity(List<CategoryDto> rList) {
        if ( rList == null ) {
            return null;
        }

        List<Category> list = new ArrayList<Category>( rList.size() );
        for ( CategoryDto categoryDto : rList ) {
            list.add( toEntity( categoryDto ) );
        }

        return list;
    }
}
