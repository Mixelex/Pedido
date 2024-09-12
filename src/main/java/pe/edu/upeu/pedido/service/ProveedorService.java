package pe.edu.upeu.pedido.service;

import java.util.List;

import pe.edu.upeu.pedido.entity.Proveedor;

public interface ProveedorService {
    Proveedor create(Proveedor p);
    Proveedor update(Proveedor p);
    void delete(Long id);
    Proveedor read(Long id);
    List<Proveedor> readAll();
    
}
