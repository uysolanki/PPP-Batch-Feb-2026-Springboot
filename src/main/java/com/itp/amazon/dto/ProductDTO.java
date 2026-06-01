package com.itp.amazon.dto;

import com.itp.amazon.util.ProductCategory;

import io.swagger.v3.oas.annotations.media.Schema;
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
	@Schema(description = "The unique commercial title of the product", example = "Mens Cotton Jacket")
	public String title;

	@DecimalMin(value = "1.0", message = "Product Price must be greater than or equal to 40")
	@DecimalMax(value = "1000.0", message = "Product Price must be less than or equal to 100")
	@Schema(description = "Retail price per item in Ruppes", example = "100")
	public double price;

	@NotBlank
	@Size(min = 5, max = 1000, message = "Product Description must be between 5 and 1000 characters")
	@Schema(description = "Product classification description", example = "great outerwear jackets for Mens, suitable for many occasions, deep adjustable hood with royalcord, side pockets.")
	public String description;

	//@NotBlank works on string
	@NotNull(message = "Category is required")
	@Schema(description = "Product category", example = "men's clothing")
	public ProductCategory category;
	
	@Schema(description = "Product image", example = "https://fakestoreapi.com/img/71li-ujtlUL._AC_UX679_.jpg")
	public String image;
	
	@Schema(description = "Product count and rating", example = "count 100 rating 4.1")
	public RatingDTO rating;
}
