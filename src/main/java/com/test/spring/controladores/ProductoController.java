package com.test.spring.controladores;

import java.time.LocalDateTime;
import java.util.List;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServlet;


import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.test.spring.repositorios.dao.Producto;
import com.test.spring.servicios.ProductoService;



@RestController
public class ProductoController extends HttpServlet {
	
	@Autowired
	private ProductoService servicio;
	

	
	@Autowired
	ServletContext context;
	

	@GetMapping({"/", "producto/list"})
	public List<Producto>  listado(Model model) {
		List<Producto> producto= servicio.findAll();
		model.addAttribute("listaProducto", servicio.findAll());
		return producto;
	}
	
	

	@SuppressWarnings("unused")
	@RequestMapping("/product/brand/{brandId}/producto/{ProductId}/startdate/{startDate}")
	public List<Producto>  busquedaproductos(@PathVariable long brandId,@PathVariable long ProductId,@PathVariable String startDate , Model model) {
		LocalDateTime startDate1= LocalDateTime.parse(startDate);
		List<Producto> producto = servicio.findByBranId(brandId);
		for(int i=0; i<producto.size();i++) {
			if(producto.get(i) != null) {
				List<Producto> producto2= servicio.findByProductId(ProductId);
				for(int x=0; x<producto2.size();x++) {
					List<Producto> producto3= servicio.findByStartDate(startDate1);
					model.addAttribute("datosproducto", producto3);
					return producto3;
				}
				
			}
		}
		
		return producto;
	}
	



	
	}

