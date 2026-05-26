package com.itp.amazon.controller;

import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.itp.amazon.dto.ProductDTO;
import com.itp.amazon.service.ProductService;

@RestController
@RequestMapping("/product")
public class ProductController {
	
	@Autowired
	ProductService productService;
	
	private static final Logger logger=Logger.getLogger(ProductController.class);
	
	@PostMapping("/addProducts")
	public ResponseEntity<List<ProductDTO>> addMultipleProducts(@RequestBody List<ProductDTO> productDTOs)
	{
		logger.info("Request received in controller to add product " + productDTOs.size());
		return new ResponseEntity<List<ProductDTO>>(productService.addProducts(productDTOs), HttpStatus.CREATED);
	}

}
