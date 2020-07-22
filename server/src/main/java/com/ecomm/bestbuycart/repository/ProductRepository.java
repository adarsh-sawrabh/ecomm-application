package com.ecomm.bestbuycart.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ecomm.bestbuycart.entity.Product;

public interface ProductRepository extends JpaRepository<Product, Long>{

	public List<Product> findAll();
	
}
