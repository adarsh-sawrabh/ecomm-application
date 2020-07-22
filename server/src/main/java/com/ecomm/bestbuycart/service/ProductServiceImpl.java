package com.ecomm.bestbuycart.service;

import java.util.List;
import java.util.UUID;

import org.modelmapper.ModelMapper;
import org.modelmapper.convention.MatchingStrategies;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ecomm.bestbuycart.dao.ProductDao;
import com.ecomm.bestbuycart.dtos.ProductsDto;
import com.ecomm.bestbuycart.entity.Product;
import com.ecomm.bestbuycart.repository.ProductRepository;

@Service
public class ProductServiceImpl implements ProductService{

	private ProductRepository repository;
	
	@Autowired
	public ProductServiceImpl(ProductRepository repository) {
		this.repository = repository;
	}
	
	@Override
	public ProductsDto getProductList() {

		List<Product> productList = repository.findAll();
		ProductsDto productsDto = new ProductsDto();
		productsDto.setProductList(productList);
		return productsDto;
	}

	@Override
	public String addProduct(ProductDao productDetails) {
		productDetails.setProductId(UUID.randomUUID().toString());
		ModelMapper modelMapper = new ModelMapper();
		modelMapper.getConfiguration().setMatchingStrategy(MatchingStrategies.STRICT);
		Product product = modelMapper.map(productDetails, Product.class);
		repository.saveAndFlush(product);
		return productDetails.getProductName();
	}

}
