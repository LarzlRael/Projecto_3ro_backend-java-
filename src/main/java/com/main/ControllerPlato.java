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
@RequestMapping("/platos")
public class ControllerPlato {

	@Autowired
	private Iplato repo;
	
	@GetMapping
	public List<Plato_Comida> listar(){
		
		return repo.findAll();
	}
	@PostMapping
	public RedirectView insertar(@RequestBody Plato_Comida pl){
		repo.save(pl);
		return new RedirectView("/platos");
	}
	
	@DeleteMapping (value = "/{id}")
	public String eliminar(@PathVariable("id") Integer id){
		repo.deleteById(id);
		return "Plato  eliminado";
	}
	@PutMapping
	public void editar(@RequestBody Plato_Comida pc) {
		repo.save(pc);
	}
	
	@GetMapping (value = "/{id}")
	public Optional<Plato_Comida> getOne(@PathVariable("id") Integer id){
		return repo.findById(id);
	}
	
}
