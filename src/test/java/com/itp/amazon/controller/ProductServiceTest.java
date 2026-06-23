package com.itp.amazon.controller;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.modelmapper.ModelMapper;

import com.itp.amazon.dto.ProductDTO;
import com.itp.amazon.entity.Product;
import com.itp.amazon.repository.ProductRepository;
import com.itp.amazon.service.ProductService;

@ExtendWith(MockitoExtension.class)
class ProductServiceTest {

    @Mock
    private ProductRepository productRepository;

    @Mock
    private ModelMapper modelMapper;

    @InjectMocks
    private ProductService productService;
    
    
    @Test
    void testSaveProductUsingDTO() {
    	
        ProductDTO inputDto = new ProductDTO();
        inputDto.setTitle("Laptop");
        inputDto.setPrice(50000.0);

        Product product = new Product();
        product.setTitle("Laptop");
        product.setPrice(50000.0);

        Product savedProduct = new Product();
        savedProduct.setId(1);
        savedProduct.setTitle("Laptop");
        savedProduct.setPrice(50000.0);

        ProductDTO outputDto = new ProductDTO();
        outputDto.setTitle("Laptop");
        outputDto.setPrice(50000.0);

        when(modelMapper.map(inputDto, Product.class))
                .thenReturn(product);

        when(productRepository.save(product))
                .thenReturn(savedProduct);

        when(modelMapper.map(savedProduct, ProductDTO.class))
                .thenReturn(outputDto);

        ProductDTO result = productService.saveProductUsingDTO(inputDto);


        assertEquals("Laptop", result.getTitle());
        assertEquals(50000.0, result.getPrice());
        verify(productRepository).save(product);
    }
}
