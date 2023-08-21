package com.example.stokbes.response;

import com.example.stokbes.dto.CategoryDto;

import java.io.Serializable;
import java.util.List;

public class CategoryListResponse extends BaseResponse implements Serializable {

    public List<CategoryDto> categoryDtoList;
}
