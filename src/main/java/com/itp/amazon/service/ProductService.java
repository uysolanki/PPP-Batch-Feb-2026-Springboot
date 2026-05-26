package com.itp.amazon.service;

import java.util.List;

import org.apache.log4j.Logger;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.itp.amazon.controller.ProductController;
import com.itp.amazon.dto.ProductDTO;
import com.itp.amazon.entity.Product;
import com.itp.amazon.repository.ProductRepository;

@Service
public class ProductService {
	
	@Autowired
	ModelMapper modelMapper;
	
	@Autowired
	ProductRepository productRepository;
	
	private static final Logger logger=Logger.getLogger(ProductService.class);

	public List<ProductDTO> addProducts(List<ProductDTO> productDTOs) {
		
		logger.info("Request received in service to add product " + productDTOs.size());
		List<Product> products=productDTOs.stream()
		.map(dto->modelMapper.map(dto, Product.class))
		.toList();
		
		List<Product> productsSavedToDB =productRepository.saveAll(products);
		
		List<ProductDTO> convertedproductToDTOs=productsSavedToDB.stream()
				.map(prod->modelMapper.map(prod, ProductDTO.class))
				.toList();
		
		return convertedproductToDTOs;
		
	}

}
