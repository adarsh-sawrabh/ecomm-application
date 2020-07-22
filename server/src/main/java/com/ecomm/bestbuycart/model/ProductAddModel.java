package com.ecomm.bestbuycart.model;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

public class ProductAddModel {

	@NotNull(message="Product Name cannot be null")
	@Size(min=5, message="Product Name must more than 4 characters")
	private String productName;
	
	@NotNull(message="Product price cannot be null")
	private String price;
	
	@NotNull(message="Product image cannot be null")
	private String imgId;

	public String getProductName() {
		return productName;
	}

	public void setProductName(String productName) {
		this.productName = productName;
	}

	public String getPrice() {
		return price;
	}

	public void setPrice(String price) {
		this.price = price;
	}

	public String getImgId() {
		return imgId;
	}

	public void setImgId(String imgId) {
		this.imgId = imgId;
	}
	
}
