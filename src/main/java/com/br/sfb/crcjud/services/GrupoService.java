package com.br.sfb.crcjud.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.br.sfb.crcjud.entities.Grupo;
import com.br.sfb.crcjud.repository.GrupoRepository;

@Service
public class GrupoService implements IGenericService<Grupo> {
@Autowired
private GrupoRepository grupoRepository;
	@Override
	public List<Grupo> findAll() {
		
		return grupoRepository.findAll();
	}

	@Override
	public Grupo save(Grupo grupo) {
		grupoRepository.save(grupo);
		return null;
	}

	@Override
	public Grupo findById(long id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void delete(Grupo entity) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void deleteById(long id) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public long count() {
		// TODO Auto-generated method stub
		return 0;
	}

}
