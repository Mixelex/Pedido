package pe.edu.upeu.pedido.dao;

import java.util.List;

import pe.edu.upeu.pedido.entity.Almacen;

public interface AlmacenDao {
    Almacen create(Almacen a);
    Almacen update(Almacen a);
    void delete(Long id);
    Almacen read(Long id);
    List<Almacen> readAll();
    
}