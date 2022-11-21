package com.kairos.spring.servicios.impl;


import java.time.LocalDateTime;
import java.util.Arrays;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.kairos.spring.repositorios.ProductoRepository;
import com.kairos.spring.repositorios.dao.Producto;
import com.kairos.spring.servicios.ProductoService;

@Service
public class ProductoServiceImpl implements ProductoService {
		
	@Autowired
	private ProductoRepository repositorio;
	
	
	
	public Producto add(Producto e) {
		repositorio.save(e);
		return e;
	}
	
	public List<Producto> findAll() {
		List<Producto> list = (List<Producto>) repositorio.findAll();
		if (list.isEmpty()) {
			repositorio.saveAll(
					Arrays.asList(
							new Producto(1,1, LocalDateTime.parse("2020-06-14T00:00:00.000"),LocalDateTime.parse("2020-12-31T23:59:59.000"),1,35455,0,35.5,"EUR",LocalDateTime.parse("2020-03-26T14:49:07.000"),"user1"),
							new Producto(2,1, LocalDateTime.parse("2020-06-14T15:00:00.000"),LocalDateTime.parse("2020-06-14T18:30:00.000"),2,35455,1,25.45,"EUR",LocalDateTime.parse("2020-05-26T15:38:22.000"),"user1"),
							new Producto(3,1, LocalDateTime.parse("2020-06-15T00:00:00.000"),LocalDateTime.parse("2020-06-15T11:00:00.000"),3,35455,1,30.5,"EUR",LocalDateTime.parse("2020-05-26T15:39:22.000"),"user1"),
							new Producto(4,1, LocalDateTime.parse("2020-06-15T16:00:00.000"),LocalDateTime.parse("2020-12-31T23:59:59.000"),1,35455,1,38.95,"EUR",LocalDateTime.parse("2020-06-02T10:14:00.000"),"user1")	
							)
					);
		}
			
		
		
		return (List<Producto>) repositorio.findAll();
	}

	public void borrar(long id) {
		repositorio.deleteById(id);
		
	}
	public Producto editar(Producto p) {
		return repositorio.save(p);
	}
	
	public Producto findById(long id) {
		return repositorio.findById(id).orElse(null);
	}

	@Override
	public List<Producto>  findByProductId(long ProductId) {
		return repositorio.findByProductId(ProductId);
	}

	@Override
	public List<Producto> findByBranId(long brandId) {
		return repositorio.findByBranId(brandId);
	}

	@Override
	public List<Producto> findByStartDate(LocalDateTime StartDate) {
		return repositorio.findByStartDate(StartDate);
	}
	
	

	


	


}
