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
import pe.edu.upeu.pedido.entity.Almacen;
import pe.edu.upeu.pedido.service.AlmacenService;


@RestController
@RequestMapping("/api/almacenes")
public class AlmacenController{
	
  
	@Autowired
	private AlmacenService almacenService;
	@GetMapping
	public ResponseEntity<List<Almacen>> readAll(){
		try {
			List<Almacen> almacenes = almacenService.readAll();
			if(almacenes.isEmpty()) {
				return new ResponseEntity<>(HttpStatus.NO_CONTENT);
			}
			return new ResponseEntity<>(almacenes, HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	@PostMapping
	public ResponseEntity<Almacen> crear(@Valid @RequestBody Almacen alm){
		try {
			Almacen a = almacenService.create(alm);
			return new ResponseEntity<>(a, HttpStatus.CREATED);
		} catch (Exception e) {
			return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	@GetMapping("/{id}")
	public ResponseEntity<Almacen> getAlmacenId(@PathVariable("id") Long id){
		try {
			Almacen a = almacenService.read(id);
			return new ResponseEntity<>(a, HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	@DeleteMapping("/{id}")
	public ResponseEntity<Almacen> delAlmacen(@PathVariable("id") Long id){
		try {
			almacenService.delete(id);
			return new ResponseEntity<>(HttpStatus.NO_CONTENT);
		} catch (Exception e) {
			return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	@PutMapping("/{id}")
	public ResponseEntity<?> updateAlmacen(@PathVariable("id") Long id, @Valid @RequestBody Almacen alm){

		Almacen a = almacenService.read(id);
			if (a.getId()>0) {
				return new ResponseEntity<>(almacenService.update(alm), HttpStatus.OK);

			} else {
				return new ResponseEntity<>(HttpStatus.NO_CONTENT);
			}
		
	}
}
