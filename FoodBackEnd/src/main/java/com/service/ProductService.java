package com.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dto.product.ProductDto;
import com.entity.Category;
import com.entity.Product;
import com.repo.ProductRepository;

@Service
public class ProductService {
	
	
	  @Autowired
	    private ProductRepository productRepository;
	  
	  
	  
	  public List<ProductDto> listProducts() {
	        List<Product> products = productRepository.findAll();
	        List<ProductDto> productDtos = new ArrayList<>();
	        for(Product product : products) {
	            productDtos.add(new ProductDto(product));
	        }
	        return productDtos;
	    }

	 public static Product getProductFromDto(ProductDto productDto, Category category) {
		    Product product= new Product(0, null, category, null, null, null, 0, false);
	        product.setCategory(category);
	        product.setDescription(productDto.getDescription());
	        product.setImageUrl(productDto.getImageUrl());
	        product.setUnitPrice(productDto.getUnitPrice());
	        product.setName(productDto.getName());
	        product.setQuantity(productDto.getQuantity());
	        product.setActive(productDto.isActive());
	        
	        
	        return product;
	 }


	    public void addProduct(ProductDto productDto, Category category) {
	        Product product = getProductFromDto(productDto, category);
	        productRepository.save(product);
	    }

	    public void updateProduct(Integer productID, ProductDto productDto, Category category) {
	        Product product = getProductFromDto(productDto, category);
	        product.setId(productID);
	        productRepository.save(product);
	    }
	       
	    }
	      
	
