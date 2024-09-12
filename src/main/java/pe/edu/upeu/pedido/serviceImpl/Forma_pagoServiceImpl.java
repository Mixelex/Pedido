package pe.edu.upeu.pedido.serviceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import pe.edu.upeu.pedido.dao.Forma_pagoDao;
import pe.edu.upeu.pedido.entity.Forma_pago;
import pe.edu.upeu.pedido.service.Forma_pagoService;





@Service
public class Forma_pagoServiceImpl implements Forma_pagoService{
    @Autowired
    private Forma_pagoDao forma_pagoDao;
	@Override
	public Forma_pago create(Forma_pago f) {
		// TODO Auto-generated method stub
		return forma_pagoDao.create(f);
	}

	@Override
	public Forma_pago update(Forma_pago f) {
		// TODO Auto-generated method stub
		return forma_pagoDao.update(f);
	}

	@Override
	public void delete(Long id) {
		forma_pagoDao.delete(id);
		
	}

	@Override
	public Forma_pago read(Long id) {
		// TODO Auto-generated method stub
		return forma_pagoDao.read(id);
	}

	@Override
	public List<Forma_pago> readAll() {
		// TODO Auto-generated method stub
		return forma_pagoDao.readAll();
	}

}