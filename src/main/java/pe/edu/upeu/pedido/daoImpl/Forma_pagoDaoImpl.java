package pe.edu.upeu.pedido.daoImpl;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;


import org.springframework.stereotype.Component;

import pe.edu.upeu.pedido.dao.Forma_pagoDao;
import pe.edu.upeu.pedido.entity.Forma_pago;
import pe.edu.upeu.pedido.repository.Forma_pagoRepository;




@Component
public class Forma_pagoDaoImpl  implements Forma_pagoDao{
    @Autowired
    private Forma_pagoRepository forma_pagoRepository;
	@Override
	public Forma_pago create(Forma_pago f) {
		// TODO Auto-generated method stub
		return forma_pagoRepository.save(f);
	}

	@Override
	public Forma_pago update(Forma_pago f) {
		// TODO Auto-generated method stub
		return forma_pagoRepository.save(f);
	}

	@Override
	public void delete(Long id) {
		// TODO Auto-generated method stub
		forma_pagoRepository.deleteById(id);
	}

	@Override
	public Forma_pago read(Long id) {
		// TODO Auto-generated method stub
		return forma_pagoRepository.findById(id).get();
	}

	@Override
	public List<Forma_pago> readAll() {
		// TODO Auto-generated method stub
		return forma_pagoRepository.findAll();
	}

}
