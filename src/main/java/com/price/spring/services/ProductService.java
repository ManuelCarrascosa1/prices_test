package com.price.spring.services;
import java.time.LocalDateTime;
import java.util.List;


import com.price.spring.repositories.dao.Product;

public interface ProductService  {
		
	
	
	public Product add(Product e) ;
	
	public List<Product> findAll() ;

	public void borrar(long id) ;
	
	public Product editar(Product p);	
	public Product findById(long id);
	public List<Product>  findByProductId(long ProductId);
	public List<Product> findByBranId(long brandId);
	public List<Product> findByStartDate(LocalDateTime StartDate);

	
	

}
