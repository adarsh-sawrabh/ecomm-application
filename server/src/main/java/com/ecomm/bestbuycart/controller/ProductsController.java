package com.ecomm.bestbuycart.controller;

import javax.validation.Valid;

import org.modelmapper.ModelMapper;
import org.modelmapper.convention.MatchingStrategies;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ecomm.bestbuycart.dao.ProductDao;
import com.ecomm.bestbuycart.dtos.ProductsDto;
import com.ecomm.bestbuycart.model.ProductAddModel;
import com.ecomm.bestbuycart.service.ProductService;

@RestController
@RequestMapping(path="/product")
public class ProductsController {

	@Autowired
	private Environment env;
	
	@Autowired
	private ProductService productService;
	
	@GetMapping(path="/status")
	public String status() {
		return "BestBuyCart-application is Up on : " + env.getProperty("local.server.port");
	}
	
	@GetMapping(path="/product-list")
	public ResponseEntity<ProductsDto> getBookList() {
		return ResponseEntity.status(HttpStatus.OK).body(productService.getProductList());
	}
	
	@PostMapping(path="/add_product")
	public ResponseEntity<String> addBook(@Valid@RequestBody ProductAddModel  productDetails){
		try {
			ModelMapper modelMapper = new ModelMapper();
			modelMapper.getConfiguration().setMatchingStrategy(MatchingStrategies.STRICT);
			ProductDao productDao = modelMapper.map(productDetails, ProductDao.class);
			String res = productService.addProduct(productDao);
			return ResponseEntity.status( HttpStatus.CREATED).body(res +" added successfully");
		}catch (Exception e) {
			e.printStackTrace();
			return ResponseEntity.status( HttpStatus.INTERNAL_SERVER_ERROR).body("Exception occured while  adding  product");
		}
	}
}
