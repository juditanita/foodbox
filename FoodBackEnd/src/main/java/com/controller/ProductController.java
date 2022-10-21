package com.controller;

import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;


import org.springframework.web.bind.annotation.RestController;

import com.config.ApplicationConfig;
import com.dto.product.ProductDto;
import com.entity.Category;

import com.service.CategoryService;
import com.service.ProductService;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/product")

public class ProductController {

    @Autowired
    ProductService productService;
    
    @Autowired
    CategoryService categoryService;

	


    @PostMapping("/add")
    public ResponseEntity<ApplicationConfig> addProduct(@RequestBody ProductDto productDto) {
        Optional<Category> optionalCategory = categoryService.readCategory(productDto.getCategoryID());
        if (!optionalCategory.isPresent()) {
            return new ResponseEntity<ApplicationConfig>(new ApplicationConfig(false, "category is invalid"), HttpStatus.CONFLICT);
        }
        Category category = optionalCategory.get();
        productService.addProduct(productDto, category);
        return new ResponseEntity<>(new ApplicationConfig(true, "Product has been added"), HttpStatus.CREATED);
    }
    @GetMapping("/")
    public ResponseEntity<List<ProductDto>> getProducts() {
        List<ProductDto> productDtos = productService.listProducts();
        return new ResponseEntity<>(productDtos, HttpStatus.OK);
    }
 // update a product
    @PostMapping("/update/{productID}")
    public ResponseEntity<ApplicationConfig> updateProduct(@PathVariable("productID") Integer productID,
                                                     @RequestBody @Valid ProductDto productDto) {
        Optional<Category> optionalCategory = categoryService.readCategory(productDto.getCategoryID());
        if (!optionalCategory.isPresent()) {
            return new ResponseEntity<ApplicationConfig>(new ApplicationConfig(false, "category is invalid"), HttpStatus.CONFLICT);
        }
        Category category = optionalCategory.get();
        productService.updateProduct(productID, productDto, category);
        return new ResponseEntity<>(new ApplicationConfig(true, "Product has been updated"), HttpStatus.OK);
    } 
}
