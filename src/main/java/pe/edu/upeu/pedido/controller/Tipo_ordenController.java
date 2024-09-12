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
import pe.edu.upeu.pedido.entity.Tipo_orden;
import pe.edu.upeu.pedido.service.Tipo_ordenService;


@RestController
@RequestMapping("/api/tipo_orden")
public class Tipo_ordenController{
	
  
	@Autowired
	private Tipo_ordenService tipo_ordenService;
	@GetMapping
	public ResponseEntity<List<Tipo_orden>> readAll(){
		try {
			List<Tipo_orden> tipo_orden = tipo_ordenService.readAll();
			if(tipo_orden.isEmpty()) {
				return new ResponseEntity<>(HttpStatus.NO_CONTENT);
			}
			return new ResponseEntity<>(tipo_orden, HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	@PostMapping
	public ResponseEntity<Tipo_orden> crear(@Valid @RequestBody Tipo_orden tip){
		try {
			Tipo_orden t = tipo_ordenService.create(tip);
			return new ResponseEntity<>(t, HttpStatus.CREATED);
		} catch (Exception e) {
			return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	@GetMapping("/{id}")
	public ResponseEntity<Tipo_orden> getTipo_ordenId(@PathVariable("id") Long id){
		try {
			Tipo_orden t = tipo_ordenService.read(id);
			return new ResponseEntity<>(t, HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	@DeleteMapping("/{id}")
	public ResponseEntity<Tipo_orden> delTipo_orden(@PathVariable("id") Long id){
		try {
			tipo_ordenService.delete(id);
			return new ResponseEntity<>(HttpStatus.NO_CONTENT);
		} catch (Exception e) {
			return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	@PutMapping("/{id}")
	public ResponseEntity<?> updateTipo_orden(@PathVariable("id") Long id, @Valid @RequestBody Tipo_orden tip){

		Tipo_orden t = tipo_ordenService.read(id);
			if (t.getId()>0) {
				return new ResponseEntity<>(tipo_ordenService.update(tip), HttpStatus.OK);

			} else {
				return new ResponseEntity<>(HttpStatus.NO_CONTENT);
			}
		
	}
}