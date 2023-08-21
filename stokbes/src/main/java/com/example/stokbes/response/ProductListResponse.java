package com.example.stokbes.response;

import com.example.stokbes.dto.ProductDto;

import java.io.Serializable;
import java.util.List;

public class ProductListResponse extends BaseResponse implements Serializable {

    public List<ProductDto> productDtolist;
}
