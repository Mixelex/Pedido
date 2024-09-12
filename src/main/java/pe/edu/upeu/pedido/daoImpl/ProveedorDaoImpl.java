package pe.edu.upeu.pedido.daoImpl;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;


import org.springframework.stereotype.Component;

import pe.edu.upeu.pedido.dao.ProveedorDao;
import pe.edu.upeu.pedido.entity.Proveedor;
import pe.edu.upeu.pedido.repository.ProveedorRepository;




@Component
public class ProveedorDaoImpl  implements ProveedorDao{
    @Autowired
    private ProveedorRepository proveedorRepository;
	@Override
	public Proveedor create(Proveedor p) {
		// TODO Auto-generated method stub
		return proveedorRepository.save(p);
	}

	@Override
	public Proveedor update(Proveedor p) {
		// TODO Auto-generated method stub
		return proveedorRepository.save(p);
	}

	@Override
	public void delete(Long id) {
		// TODO Auto-generated method stub
		proveedorRepository.deleteById(id);
	}

	@Override
	public Proveedor read(Long id) {
		// TODO Auto-generated method stub
		return proveedorRepository.findById(id).get();
	}

	@Override
	public List<Proveedor> readAll() {
		// TODO Auto-generated method stub
		return proveedorRepository.findAll();
	}

}