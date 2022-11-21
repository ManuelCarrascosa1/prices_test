package com.kairos.spring.controladores;

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

import com.kairos.spring.repositorios.dao.Producto;
import com.kairos.spring.servicios.ProductoService;



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
	
	
	
	/*@RequestMapping("/product/id/{id}/producto/{ProductId}")
	public Producto busquedaparametros(@PathVariable long id,@PathVariable long ProductId, Model model) {
		Producto producto = servicio.findById(id);
		if (producto != null) {
			Producto producto2= servicio.findByProductId(ProductId);
			if(producto2 != null) {
				model.addAttribute("datosproducto", producto2);
				return producto2;
			}
			
		} 
		return producto;
	}*/
	
	
	
	@GetMapping("/product/busqueda/{id}")
	public String editarProductoForm(@PathVariable long id, Model model) {
		Producto producto = servicio.findById(id);
		if (producto != null) {
			model.addAttribute("listaProducto", producto);
			return "list";
		} else
			return "error";
	}
	
	
	
	@RequestMapping("/product/brand/{brandId}/producto/{ProductId}")
	public List<Producto>  busquedaparametros2(@PathVariable long brandId,@PathVariable long ProductId, Model model) {
		List<Producto> producto = servicio.findByBranId(brandId);
		for(int i=0; i<producto.size();i++) {
			if(producto.get(i) != null) {
				List<Producto> producto2= servicio.findByProductId(ProductId);
				model.addAttribute("datosproducto", producto2);
				return producto2;
			}
		}
		
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

