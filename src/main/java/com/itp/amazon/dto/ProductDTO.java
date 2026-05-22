package com.itp.amazon.dto;

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

	 	public String title;
	    public double price;
	    public String description;
	    public String category;
	    public String image;
	    public RatingDTO rating;
}
