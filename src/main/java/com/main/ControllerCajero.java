package com.main;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.view.RedirectView;


@RestController
@CrossOrigin(origins = "http://localhost:4200")
@RequestMapping("/cajeros")
public class ControllerCajero {
	
	@Autowired
	private ICajero repo;
	
	@GetMapping
	public List<CajeroModelo> listar(){
		
		return repo.getAll();
	}
	
	@GetMapping (value = "enableUsers")
	public List<CajeroModelo> getUsersAble(){
		
		return repo.getUsersEnabled();
	}
	
	@GetMapping (value = "/{id}")
	public Optional<CajeroModelo> getOne(@PathVariable("id") Integer id){
		
		return repo.findById(id);
	}
	@PostMapping
	public RedirectView insertar(@RequestBody CajeroModelo caj){
		repo.save(caj);
		return new RedirectView("/cajeros");
	}
	@DeleteMapping (value = "/{id}")
	@CrossOrigin(origins = "http://localhost:4200")
	public String eliminar(@PathVariable("id") Integer id){
		repo.deleteById(id);
		return "Cajero eliminado";
	}
	@PutMapping
	public void editar(@RequestBody CajeroModelo cajero) {
		repo.save(cajero);
	}
	@GetMapping  (value = "enable/{id}")
	public void enable(@PathVariable("id") Integer id) {
		repo.habilitar(id);
	}
	
	@GetMapping  (value = "disable/{id}")
	public void disable(@PathVariable("id") Integer id) {
		repo.deshabilitar(id);
	}
	
}
