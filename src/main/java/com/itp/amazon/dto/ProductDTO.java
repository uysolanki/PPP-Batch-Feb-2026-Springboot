package com.itp.amazon.dto;

import com.itp.amazon.util.ProductCategory;

import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.validation.constraints.DecimalMax;
import jakarta.validation.constraints.DecimalMin;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@AllArgsConstructor
@NoArgsConstructor
@ToString
@Setter
@Getter
@Builder
public class ProductDTO {

	@NotBlank
	@Size(min = 5, max = 100, message = "Product Title must be between 5 and 100 characters")
	public String title;

	@DecimalMin(value = "1.0", message = "Product Price must be greater than or equal to 40")
	@DecimalMax(value = "1000.0", message = "Product Price must be less than or equal to 100")
	public double price;

	@NotBlank
	@Size(min = 5, max = 1000, message = "Product Description must be between 5 and 1000 characters")
	public String description;

	//@NotBlank works on string
	@NotNull(message = "Category is required")
	public ProductCategory category;
	
	public String image;
	public RatingDTO rating;
}
