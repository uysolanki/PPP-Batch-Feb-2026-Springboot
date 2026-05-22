package com.itp.amazon.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.itp.amazon.entity.Product;

@Repository
public interface ProductRepository extends JpaRepository<Product, Integer>{

}
