package com.example.stokbes.control;

import com.example.stokbes.dto.CategoryDto;
import com.example.stokbes.response.CategoryListResponse;
import com.example.stokbes.response.CategoryResponse;
import com.example.stokbes.response.Meta;
import com.example.stokbes.service.CategoryService;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RestController
@RequestMapping("/category")
@RequiredArgsConstructor
public class CategoryControl {

    public final CategoryService categoryService;

    @PostMapping("/addCategory")
    public CategoryResponse addCategory(@RequestBody CategoryDto categoryDto){

        return categoryService.addCategory(categoryDto);
    }

    @GetMapping("/find/{categoryId}")
    CategoryResponse findCategory(@PathVariable (value = "categoryId") int categoryId){

        Meta meta=new Meta();
        CategoryResponse categoryResponse=new CategoryResponse();
        CategoryDto categoryDto=categoryService.findCategoryByDto(categoryId);
        meta.errorCode=2008;
        meta.errorDescription="Aratılan kategory bulundu = "+" "+ categoryId;
        categoryResponse.categoryDto=categoryDto;
        categoryResponse.meta=meta;
    return categoryResponse;
    }


    @GetMapping("/getAllCategory/Category")
    CategoryListResponse CategoryGetAll(){

        Meta meta = new Meta();
        CategoryResponse categoryResponse = new CategoryResponse();
        CategoryListResponse categoryListResponse = new CategoryListResponse();

        List<CategoryDto> categoryDtoList=categoryService.GetAllCategory();

        if (categoryDtoList !=null) {
            meta.errorCode = 2003;
            meta.errorDescription = "Tüm categoryler bulundu";



        }else {
            meta.errorCode = 4019;
            meta.errorDescription = "Tüm categoryler bulunamadı ";

        }
        categoryListResponse.categoryDtoList=categoryDtoList;
        categoryResponse.meta = meta;
        categoryListResponse.meta=meta;
        return categoryListResponse;
    }
}
