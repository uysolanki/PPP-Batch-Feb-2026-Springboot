package com.itp.amazon.controller;

import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.web.servlet.MockMvc;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.itp.amazon.dto.ProductDTO;
import com.itp.amazon.service.ProductService;

@TestPropertySource(properties = {"info.project.instructor.name=Test Instructor"})
@WebMvcTest(ProductController.class)
@AutoConfigureMockMvc(addFilters = false)
public class ProductControllerTest {
	
		@Autowired
	    private MockMvc mockMvc;

	    @MockBean
	    private ProductService productService;

	    @Autowired
	    private ObjectMapper objectMapper;
	    
	    
	    @Test
	    void testSaveProductUsingDTO() throws Exception {

	        ProductDTO dto = new ProductDTO();

	        dto.setTitle("Laptop");
	        dto.setPrice(50000.0);

	        when(productService.saveProductUsingDTO(Mockito.any(ProductDTO.class)))
	                .thenReturn(dto);

	        mockMvc.perform(post("/product/saveProductUsingDTO")
	                .contentType(MediaType.APPLICATION_JSON)
	                .content(objectMapper.writeValueAsString(dto)))
	        		.andExpect(status().isCreated())
	        		.andExpect(jsonPath("$.title").value("Laptop"))
	        		.andExpect(jsonPath("$.price").value(50000.0));
	    }    

}
