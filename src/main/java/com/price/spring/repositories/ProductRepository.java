package com.price.spring.repositories;



import java.time.LocalDateTime;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.price.spring.repositories.dao.Product;



@Repository
public interface ProductRepository extends JpaRepository<Product, Long> {
	

	public List<Product> findByBranId(long brandId);
	public List<Product>  findByProductId(long ProductId);
	public List<Product> findByStartDate(LocalDateTime StartDate);
	
	
	
}
