package pe.edu.upeu.pedido.dao;

import java.util.List;

import pe.edu.upeu.pedido.entity.Forma_pago;

public interface Forma_pagoDao {
    Forma_pago create(Forma_pago f);
    Forma_pago update(Forma_pago f);
    void delete(Long id);
    Forma_pago read(Long id);
    List<Forma_pago> readAll();
    
}