package pe.edu.upeu.pedido.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import pe.edu.upeu.pedido.entity.Almacen;

@Repository
public interface AlmacenRepository extends JpaRepository<Almacen, Long>{

}
