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
import pe.edu.upeu.pedido.entity.Proveedor;
import pe.edu.upeu.pedido.service.ProveedorService;


@RestController
@RequestMapping("/api/proveedores")
public class ProveedorController{
	
  
	@Autowired
	private ProveedorService proveedorService;
	@GetMapping
	public ResponseEntity<List<Proveedor>> readAll(){
		try {
			List<Proveedor> proveedores = proveedorService.readAll();
			if(proveedores.isEmpty()) {
				return new ResponseEntity<>(HttpStatus.NO_CONTENT);
			}
			return new ResponseEntity<>(proveedores, HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	@PostMapping
	public ResponseEntity<Proveedor> crear(@Valid @RequestBody Proveedor pro){
		try {
			Proveedor p = proveedorService.create(pro);
			return new ResponseEntity<>(p, HttpStatus.CREATED);
		} catch (Exception e) {
			return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	@GetMapping("/{id}")
	public ResponseEntity<Proveedor> getProveedorId(@PathVariable("id") Long id){
		try {
			Proveedor p = proveedorService.read(id);
			return new ResponseEntity<>(p, HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	@DeleteMapping("/{id}")
	public ResponseEntity<Proveedor> delProveedor(@PathVariable("id") Long id){
		try {
			proveedorService.delete(id);
			return new ResponseEntity<>(HttpStatus.NO_CONTENT);
		} catch (Exception e) {
			return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	@PutMapping("/{id}")
	public ResponseEntity<?> updateProveedor(@PathVariable("id") Long id, @Valid @RequestBody Proveedor pro){

		Proveedor p = proveedorService.read(id);
			if (p.getId()>0) {
				return new ResponseEntity<>(proveedorService.update(pro), HttpStatus.OK);

			} else {
				return new ResponseEntity<>(HttpStatus.NO_CONTENT);
			}
		
	}
}