package com.price.spring;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import com.price.spring.controllers.ProductController;
import com.price.spring.repositories.dao.Product;
import com.price.spring.services.ProductService;

@RunWith(SpringRunner.class)
@SpringBootTest
public class ApplicationTests {
	
	ProductController productocontroller;
	
	@Autowired
	private ProductService servicio;

	@Test
	public void product35455brand1startdate14T10() throws Exception {
	productocontroller= new ProductController(servicio);
	List<Product> productofinal=productocontroller.busquedaproductos(1, 35455, "2020-06-14T10:00:00.000");
	assertThat(productofinal).isNotNull();
	assertThat(productofinal).isNotEmpty();
	Product producto= productofinal.get(0);
	assertNotNull(producto);
	assertEquals(35455, producto.getProductId());
	assertEquals(1, producto.getBranId());
	
	
	}
	

	@Test
	public void product35455brand1startdate14T16() {
	productocontroller= new ProductController(servicio);
	List<Product> productofinal=productocontroller.busquedaproductos(1, 35455, "2020-06-14T16:00:00.000"); 	
	assertThat(productofinal).isNotNull();
	assertThat(productofinal).isNotEmpty();
	Product producto= productofinal.get(0);
	assertNotNull(producto);
	assertEquals(35455, producto.getProductId());
	assertEquals(1, producto.getBranId());
	
	
	}
	
		
	
	@Test
	public void product35455brand1startdate14T21() {
	productocontroller= new ProductController(servicio);
	List<Product> productofinal=productocontroller.busquedaproductos(1, 35455, "2020-06-14T21:00:00.000"); 	
	assertThat(productofinal).isNotNull();
	assertThat(productofinal).isNotEmpty();
	Product producto= productofinal.get(0);
	assertNotNull(producto);
	assertEquals(35455, producto.getProductId());
	assertEquals(1, producto.getBranId());
	
	
	}
	
	
	
	
	
	@Test
	public void product35455brand1startdate15T10() {
	productocontroller= new ProductController(servicio);
	List<Product> productofinal=productocontroller.busquedaproductos(1, 35455, "2020-06-15T10:00:00.000"); 	
	assertThat(productofinal).isNotNull();
	assertThat(productofinal).isNotEmpty();
	Product producto= productofinal.get(0);
	assertNotNull(producto);
	assertEquals(35455, producto.getProductId());
	assertEquals(1, producto.getBranId());
	
	
	}
	
	
	
	
	
	@Test
	public void product35455brand1startdate16T21() {
	productocontroller= new ProductController(servicio);
	List<Product> productofinal=productocontroller.busquedaproductos(1, 35455, "2020-06-16T21:00:00.000"); 	
	assertThat(productofinal).isNotNull();
	assertThat(productofinal).isNotEmpty();
	Product producto= productofinal.get(0);
	assertNotNull(producto);
	assertEquals(35455, producto.getProductId());
	assertEquals(1, producto.getBranId());
	
	
	}

}
