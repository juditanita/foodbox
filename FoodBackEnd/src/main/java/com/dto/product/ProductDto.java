package com.dto.product;

import java.math.BigDecimal;

import javax.validation.constraints.NotNull;


import com.entity.Product;

public class ProductDto {


private Integer id;
private @NotNull String name;
private @NotNull String description;
private @NotNull String imageUrl;
private @NotNull BigDecimal unitPrice;
private @NotNull Integer quantity;
private @NotNull boolean active;
private @NotNull Integer categoryID;



public ProductDto(Integer id, @NotNull String name, @NotNull String description, @NotNull String imageUrl,
		@NotNull BigDecimal unitPrice, @NotNull Integer quantity, @NotNull boolean active,
		@NotNull Integer categoryID) {
	super();
	this.id = id;
	this.name = name;
	this.description = description;
	this.imageUrl = imageUrl;
	this.unitPrice = unitPrice;
	this.quantity = quantity;
	this.active = active;
	this.categoryID = categoryID;
}

public ProductDto(@NotNull String name,@NotNull  String description, @NotNull String imageUrl,@NotNull  BigDecimal unitPrice, @NotNull int quantity,@NotNull  boolean active, @NotNull Integer categoryID) {
    super();
    this.name = name;
    this.description = description;
    this.imageUrl = imageUrl;
    this.unitPrice = unitPrice;
    this.quantity = quantity;
    this.active=active;
    
    this.categoryID= categoryID;
}

public ProductDto(Product product) {
    this.setId(product.getId());
    this.setName(product.getName());
    this.setDescription(product.getDescription());
    this.setImageUrl(product.getImageUrl());
    
    this.setUnitPrice(product.getUnitPrice());
    this.setQuantity(product.getQuantity());
    this.setActive(product.isActive());
    this.setCategoryID(product.getCategory().getId());
    
}

public ProductDto() {
}
/**
 * @return the id
 */
public Integer getId() {
	return id;
}

/**
 * @param id the id to set
 */
public void setId(Integer id) {
	this.id = id;
}

/**
 * @return the name
 */
public String getName() {
	return name;
}

/**
 * @param name the name to set
 */
public void setName(String name) {
	this.name = name;
}

/**
 * @return the description
 */
public String getDescription() {
	return description;
}

/**
 * @param description the description to set
 */
public void setDescription(String description) {
	this.description = description;
}

/**
 * @return the imageUrl
 */
public String getImageUrl() {
	return imageUrl;
}

/**
 * @param imageUrl the imageUrl to set
 */
public void setImageUrl(String imageUrl) {
	this.imageUrl = imageUrl;
}

/**
 * @return the unitPrice
 */
public BigDecimal getUnitPrice() {
	return unitPrice;
}

/**
 * @param unitPrice the unitPrice to set
 */
public void setUnitPrice(BigDecimal unitPrice) {
	this.unitPrice = unitPrice;
}

/**
 * @return the quantity
 */
public Integer getQuantity() {
	return quantity;
}

/**
 * @param quantity the quantity to set
 */
public void setQuantity(Integer quantity) {
	this.quantity = quantity;
}

/**
 * @return the active
 */
public boolean isActive() {
	return active;
}

/**
 * @param active the active to set
 */
public void setActive(boolean active) {
	this.active = active;
}

/**
 * @return the id
 */
public Integer getCategoryID() {
	return categoryID;
}

/**
 * @param id the id to set
 */
public void setCategoryID(Integer categoryID) {
	this.categoryID = categoryID;
}


}
