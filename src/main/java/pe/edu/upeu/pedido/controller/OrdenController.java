package pe.edu.upeu.pedido.controller;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import jakarta.validation.Valid;
import pe.edu.upeu.pedido.entity.Orden;
import pe.edu.upeu.pedido.service.OrdenService;


@RestController
@RequestMapping("/api/ordenes")
public class OrdenController{
	
  
	@Autowired
	private OrdenService ordenService;
	@GetMapping
	public ResponseEntity<List<Orden>> readAll(){
		try {
			List<Orden> ordenes = ordenService.readAll();
			if(ordenes.isEmpty()) {
				return new ResponseEntity<>(HttpStatus.NO_CONTENT);
			}
			return new ResponseEntity<>(ordenes, HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	@PostMapping
	public ResponseEntity<Orden> crear(@Valid @RequestBody Orden ord){
		try {
			Orden o = ordenService.create(ord);
			return new ResponseEntity<>(o, HttpStatus.CREATED);
		} catch (Exception e) {
			return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	@GetMapping("/{id}")
	public ResponseEntity<Orden> getOrdenId(@PathVariable("id") Long id){
		try {
			Orden o = ordenService.read(id);
			return new ResponseEntity<>(o, HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	@DeleteMapping("/{id}")
	public ResponseEntity<Orden> delOrden(@PathVariable("id") Long id){
		try {
			ordenService.delete(id);
			return new ResponseEntity<>(HttpStatus.NO_CONTENT);
		} catch (Exception e) {
			return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	@PutMapping("/{id}")
	public ResponseEntity<?> updateOrden(@PathVariable("id") Long id, @Valid @RequestBody Orden ord){

		Orden o = ordenService.read(id);
			if (o.getId()>0) {
				return new ResponseEntity<>(ordenService.update(ord), HttpStatus.OK);

			} else {
				return new ResponseEntity<>(HttpStatus.NO_CONTENT);
			}
		
	}
}