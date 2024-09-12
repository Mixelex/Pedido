package pe.edu.upeu.pedido.daoImpl;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;


import org.springframework.stereotype.Component;

import pe.edu.upeu.pedido.dao.AlmacenDao;
import pe.edu.upeu.pedido.entity.Almacen;
import pe.edu.upeu.pedido.repository.AlmacenRepository;




@Component
public class AlmacenDaoImpl  implements AlmacenDao{
    @Autowired
    private AlmacenRepository almacenRepository;
	@Override
	public Almacen create(Almacen a) {
		// TODO Auto-generated method stub
		return almacenRepository.save(a);
	}

	@Override
	public Almacen update(Almacen a) {
		// TODO Auto-generated method stub
		return almacenRepository.save(a);
	}

	@Override
	public void delete(Long id) {
		// TODO Auto-generated method stub
		almacenRepository.deleteById(id);
	}

	@Override
	public Almacen read(Long id) {
		// TODO Auto-generated method stub
		return almacenRepository.findById(id).get();
	}

	@Override
	public List<Almacen> readAll() {
		// TODO Auto-generated method stub
		return almacenRepository.findAll();
	}

}