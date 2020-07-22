package com.ecomm.bestbuycart.dtos;

import java.io.Serializable;
import java.util.List;

import com.ecomm.bestbuycart.entity.Product;

public class ProductsDto implements Serializable{

	private static final long serialVersionUID = -9058774830891034187L;
	
	private List<Product> productList;
	
	public List<Product> getProductList() {
		return productList;
	}
	public void setProductList(List<Product> productList) {
		this.productList = productList;
	}
}
