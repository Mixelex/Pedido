package pe.edu.upeu.pedido.dao;

import java.util.List;

import pe.edu.upeu.pedido.entity.Tipo_orden;

public interface Tipo_ordenDao {
    Tipo_orden create(Tipo_orden t);
    Tipo_orden update(Tipo_orden t);
    void delete(Long id);
    Tipo_orden read(Long id);
    List<Tipo_orden> readAll();
    
}