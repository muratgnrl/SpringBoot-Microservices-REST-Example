package com.example.stokbes.service;

import com.example.stokbes.dto.CategoryDto;
import com.example.stokbes.entity.Category;
import com.example.stokbes.mapper.CategoryMapper;
import com.example.stokbes.repository.CategoryRepository;
import com.example.stokbes.response.CategoryResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class CategoryService {

    public final CategoryMapper categoryMapper;
    public final CategoryRepository categoryRepository;
    public CategoryResponse addCategory(CategoryDto categoryDto) {
        Category category=categoryMapper.toEntity(categoryDto);
        category=categoryRepository.save(category);
        return generateCategoryResult(categoryMapper.toResource(category));
    }

    private CategoryResponse generateCategoryResult(CategoryDto ToResource) {

        CategoryResponse categoryResponse=new CategoryResponse();
        categoryResponse.categoryDto=ToResource;
        return categoryResponse;
    }

    public CategoryDto findCategoryByDto(int categoryId) {
        Category category=findCategory(categoryId);
        return categoryMapper.toResource(category);
    }

    public Category findCategory(int categoryId)  {
        Category category=categoryRepository.findCategoryByCategoryId(categoryId);
        return category;
    }

    public List<CategoryDto> GetAllCategory()
    {
        return categoryMapper.toResource(getCategoryList());

    }

    private List<Category> getCategoryList() {

        return categoryRepository.findAll();
    }
}
