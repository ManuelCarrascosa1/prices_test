package com.price.spring.services.impl;


import java.time.LocalDateTime;
import java.util.Arrays;
import java.util.List;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.price.spring.repositories.ProductRepository;
import com.price.spring.repositories.dao.Product;
import com.price.spring.services.ProductService;


@Service
public class ProductServiceImpl implements ProductService {
		
	@Autowired
	private ProductRepository repositorio;
	
	
	
	public Product add(Product e) {
		repositorio.save(e);
		return e;
	}
	
	public List<Product> findAll() {
		List<Product> list = (List<Product>) repositorio.findAll();
		if (list.isEmpty()) {
			repositorio.saveAll(
					Arrays.asList(
							new Product(1,1, LocalDateTime.parse("2020-06-14T00:00:00.000"),LocalDateTime.parse("2020-12-31T23:59:59.000"),1,35455,0,35.5,"EUR",LocalDateTime.parse("2020-03-26T14:49:07.000"),"user1"),
							new Product(2,1, LocalDateTime.parse("2020-06-14T15:00:00.000"),LocalDateTime.parse("2020-06-14T18:30:00.000"),2,35455,1,25.45,"EUR",LocalDateTime.parse("2020-05-26T15:38:22.000"),"user1"),
							new Product(3,1, LocalDateTime.parse("2020-06-15T00:00:00.000"),LocalDateTime.parse("2020-06-15T11:00:00.000"),3,35455,1,30.5,"EUR",LocalDateTime.parse("2020-05-26T15:39:22.000"),"user1"),
							new Product(4,1, LocalDateTime.parse("2020-06-15T16:00:00.000"),LocalDateTime.parse("2020-12-31T23:59:59.000"),1,35455,1,38.95,"EUR",LocalDateTime.parse("2020-06-02T10:14:00.000"),"user1")	
							)
					);
		}
			
		
		
		return (List<Product>) repositorio.findAll();
	}
	@PostConstruct
	public void init() {
		repositorio.saveAll(
				Arrays.asList(
						new Product(1,1, LocalDateTime.parse("2020-06-14T00:00:00.000"),LocalDateTime.parse("2020-12-31T23:59:59.000"),1,35455,0,35.5,"EUR",LocalDateTime.parse("2020-03-26T14:49:07.000"),"user1"),
						new Product(2,1, LocalDateTime.parse("2020-06-14T15:00:00.000"),LocalDateTime.parse("2020-06-14T18:30:00.000"),2,35455,1,25.45,"EUR",LocalDateTime.parse("2020-05-26T15:38:22.000"),"user1"),
						new Product(3,1, LocalDateTime.parse("2020-06-15T00:00:00.000"),LocalDateTime.parse("2020-06-15T11:00:00.000"),3,35455,1,30.5,"EUR",LocalDateTime.parse("2020-05-26T15:39:22.000"),"user1"),
						new Product(4,1, LocalDateTime.parse("2020-06-15T16:00:00.000"),LocalDateTime.parse("2020-12-31T23:59:59.000"),1,35455,1,38.95,"EUR",LocalDateTime.parse("2020-06-02T10:14:00.000"),"user1")	
						)
				);
		
	}
	

	public void borrar(long id) {
		repositorio.deleteById(id);
		
	}
	public Product editar(Product p) {
		return repositorio.save(p);
	}
	
	public Product findById(long id) {
		return repositorio.findById(id).orElse(null);
	}

	@Override
	public List<Product>  findByProductId(long ProductId) {
		return repositorio.findByProductId(ProductId);
	}

	@Override
	public List<Product> findByBranId(long brandId) {
		return repositorio.findByBranId(brandId);
	}

	@Override
	public List<Product> findByStartDate(LocalDateTime StartDate) {
		return repositorio.findByStartDate(StartDate);
	}
	
	

	


	


}
