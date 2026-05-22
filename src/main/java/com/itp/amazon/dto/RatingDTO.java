package com.itp.amazon.dto;

import java.time.LocalDateTime;

import com.itp.amazon.entity.Product;
import com.itp.amazon.entity.Rating;

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
public class RatingDTO {
	public double rate;
    public int count;
}
