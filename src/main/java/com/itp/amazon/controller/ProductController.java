package com.itp.amazon.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.itp.amazon.dto.ProductDTO;
import com.itp.amazon.service.ProductService;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import jakarta.validation.Valid;

@RestController
@RequestMapping("/product")
public class ProductController {
	
	@Autowired
	ProductService productService;
	
	@Value("${info.project.instructor.name}")
	public String instructorName;
	//private static final Logger logger=Logger.getLogger(ProductController.class);
	
	//private static final Logger logger =LoggerFactory.getLogger(ProductController.class);
	@GetMapping("/greet")
	public String greet()
	{
		return instructorName;
	}
	
	@Operation(summary = "Saves Multiple Product", description = "Accepts a List<ProductDTO> and saves them to the database. Returns the saved products ")
	@PostMapping("/addProducts")
	public ResponseEntity<List<ProductDTO>> addMultipleProducts(@RequestBody List<ProductDTO> productDTOs)
	{
		//logger.info("Request received in controller to add product " + productDTOs.size());
		return new ResponseEntity<List<ProductDTO>>(productService.addProducts(productDTOs), HttpStatus.CREATED);
	}
	
	@Operation(summary = "Saves Single Product", description = "Accepts a single ProductDTO and saves it to the database. Returns the saved productDTO.")
	@ApiResponse(responseCode = "200", description = "Product was successfully deleted from the system.") 
	@ApiResponse(responseCode = "404", description = "Resource Clean Fail: The provided Product ID does not exist in the database.")
	@PostMapping("/addProduct")
	public ResponseEntity<ProductDTO> addProduct(@Valid @RequestBody ProductDTO productDTO)
	{
		//logger.info("Request received in controller to add product " + productDTO.getTitle());
		ProductDTO prodDTO=productService.addProduct(productDTO);
		return new ResponseEntity<ProductDTO>(prodDTO, HttpStatus.CREATED);
	}
	
	@PostMapping("/saveProductUsingDTO")
	public ResponseEntity<ProductDTO> saveProductUsingDTO(@RequestBody ProductDTO productDTO)
	{
		return new ResponseEntity<ProductDTO>(productService.saveProductUsingDTO(productDTO),HttpStatus.CREATED);
	}

}
