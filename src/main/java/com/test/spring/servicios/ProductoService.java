package com.test.spring.servicios;



import java.time.LocalDateTime;
import java.util.List;

import com.test.spring.repositorios.dao.Producto;

public interface ProductoService  {
		
	
	
	public Producto add(Producto e) ;
	
	public List<Producto> findAll() ;

	public void borrar(long id) ;
	
	public Producto editar(Producto p);	
	public Producto findById(long id);
	public List<Producto>  findByProductId(long ProductId);
	public List<Producto> findByBranId(long brandId);
	public List<Producto> findByStartDate(LocalDateTime StartDate);

	
	

}
