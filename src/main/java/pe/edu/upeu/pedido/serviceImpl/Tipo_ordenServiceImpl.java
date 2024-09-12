package pe.edu.upeu.pedido.serviceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import pe.edu.upeu.pedido.dao.Tipo_ordenDao;
import pe.edu.upeu.pedido.entity.Tipo_orden;
import pe.edu.upeu.pedido.service.Tipo_ordenService;





@Service
public class Tipo_ordenServiceImpl implements Tipo_ordenService{
    @Autowired
    private Tipo_ordenDao tipo_ordenDao;
	@Override
	public Tipo_orden create(Tipo_orden t) {
		// TODO Auto-generated method stub
		return tipo_ordenDao.create(t);
	}

	@Override
	public Tipo_orden update(Tipo_orden t) {
		// TODO Auto-generated method stub
		return tipo_ordenDao.update(t);
	}

	@Override
	public void delete(Long id) {
		tipo_ordenDao.delete(id);
		
	}

	@Override
	public Tipo_orden read(Long id) {
		// TODO Auto-generated method stub
		return tipo_ordenDao.read(id);
	}

	@Override
	public List<Tipo_orden> readAll() {
		// TODO Auto-generated method stub
		return tipo_ordenDao.readAll();
	}

}