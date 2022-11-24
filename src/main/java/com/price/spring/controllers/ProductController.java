package com.price.spring.controllers;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServlet;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.price.spring.repositories.dao.Product;
import com.price.spring.services.ProductService;



@SuppressWarnings("serial")
@RestController
public class ProductController extends HttpServlet {
	
	@Autowired
	private ProductService servicio;
	

	
	@Autowired
	ServletContext context;
	
	public ProductController(ProductService servicio) {
		this.servicio=servicio;
		
	}
	

	@GetMapping({"/", "producto/list"})
	public List<Product>  listado(Model model) {
		List<Product> producto= servicio.findAll();
		model.addAttribute("listaProducto", servicio.findAll());
		return producto;
	}
	
	

	@SuppressWarnings({ "unused"})
	@RequestMapping("/product/brand/{brandId}/producto/{ProductId}/applicationDate/{applicationDate}")
	public List<Product>  busquedaproductos(@PathVariable long brandId,@PathVariable long ProductId,@PathVariable String applicationDate) {
		LocalDateTime applicationDate1= LocalDateTime.parse(applicationDate);
		List<Product> producto = servicio.findByBranId(brandId);
		List<Product>vacio = null;
		List<Product> producto3 = new ArrayList<Product>();
		for(int i=0; i<producto.size();i++) {
			if(producto.get(i) != null) {
				List<Product> producto2= servicio.findByProductId(ProductId);
				
				for(int x=0; x<producto2.size();x++) {
					LocalDateTime fecha1=producto2.get(x).getStartDate();
					LocalDateTime fecha2=producto2.get(x).getEndDate();
					
					if(fecha1.isBefore(applicationDate1) && fecha2.isAfter(applicationDate1)) {
						
						producto3.add(producto2.get(x));
						
					}
					
				}
				
			}
			List<Product> producto4 = new ArrayList<Product>();
			if(producto3.size()!=1) {
				for(int h=0; h<producto3.size();h++) {
					int priority= producto3.get(h).getPriority();
					if(priority==1) {
						producto4.add(producto3.get(h));
						
					}
				}
				return producto4;
			}else {
				return producto3;
			}
			
				
			}
	
		
		return vacio;
	}
	



	
	}

