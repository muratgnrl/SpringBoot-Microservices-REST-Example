package com.example.stokbes.control;

import com.example.stokbes.dto.ProductDto;
import com.example.stokbes.response.Meta;
import com.example.stokbes.response.ProductListResponse;
import com.example.stokbes.response.ProductResponse;
import com.example.stokbes.service.ProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RestController
@RequestMapping("/product")
@RequiredArgsConstructor
public class ProductControl {

    public final ProductService productService;

    @PostMapping("/addProduct")
    public ProductResponse addProduct(@RequestBody ProductDto productDto){
        return productService.addProduct(productDto);
    }

    @GetMapping("/find/{productId}")
    public ProductResponse findProduct(@PathVariable (value = "productId") int productId){

        Meta meta=new Meta();
        ProductResponse productResponse=new ProductResponse();

        ProductDto productDto=productService.findProductByDto(productId);
        if (productResponse !=null){
            meta.errorCode=2070;
            meta.errorDescription="aranan product bulundu";

        }else {
            meta.errorCode=4044;
            meta.errorDescription="aranan product bulunamadı";

        }
        productResponse.productDto=productDto;
        return productResponse;
    }
    @GetMapping("/getAll/Product")
    public ProductListResponse ProductGetAll(){

        Meta meta = new Meta();
        ProductResponse productResponse = new ProductResponse();
        ProductListResponse productListResponse = new ProductListResponse();

        List<ProductDto> productDtoList = productService.GetAllProduct();

        if (productDtoList != null) {
            meta.errorCode = 2019;
            meta.errorDescription = "Tüm ürünler bulundu";
        } else {
            meta.errorCode = 4409;
            meta.errorDescription = "Tüm ürünler bulunamadı";
        }

        productResponse.meta = meta;
        productListResponse.productDtolist = productDtoList;
        productListResponse.meta = meta;

        return productListResponse;
    }


}
