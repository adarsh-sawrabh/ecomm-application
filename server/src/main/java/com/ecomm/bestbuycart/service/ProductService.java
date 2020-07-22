package com.ecomm.bestbuycart.service;

import com.ecomm.bestbuycart.dao.ProductDao;
import com.ecomm.bestbuycart.dtos.ProductsDto;

public interface ProductService {

	public ProductsDto getProductList();
	public String addProduct(ProductDao productDetails);
	
}
