package pe.edu.upeu.pedido.service;

import java.util.List;

import pe.edu.upeu.pedido.entity.Orden;

public interface OrdenService {
    Orden create(Orden o);
    Orden update(Orden o);
    void delete(Long id);
    Orden read(Long id);
    List<Orden> readAll();
    
}