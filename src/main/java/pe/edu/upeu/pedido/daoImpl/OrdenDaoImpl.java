package pe.edu.upeu.pedido.daoImpl;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;


import org.springframework.stereotype.Component;

import pe.edu.upeu.pedido.dao.OrdenDao;
import pe.edu.upeu.pedido.entity.Orden;
import pe.edu.upeu.pedido.repository.OrdenRepository;




@Component
public class OrdenDaoImpl  implements OrdenDao{
    @Autowired
    private OrdenRepository ordenRepository;
	@Override
	public Orden create(Orden o) {
		// TODO Auto-generated method stub
		return ordenRepository.save(o);
	}

	@Override
	public Orden update(Orden o) {
		// TODO Auto-generated method stub
		return ordenRepository.save(o);
	}

	@Override
	public void delete(Long id) {
		// TODO Auto-generated method stub
		ordenRepository.deleteById(id);
	}

	@Override
	public Orden read(Long id) {
		// TODO Auto-generated method stub
		return ordenRepository.findById(id).get();
	}

	@Override
	public List<Orden> readAll() {
		// TODO Auto-generated method stub
		return ordenRepository.findAll();
	}

}
