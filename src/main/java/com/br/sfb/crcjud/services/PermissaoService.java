package com.br.sfb.crcjud.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.br.sfb.crcjud.entities.Permissao;
import com.br.sfb.crcjud.repository.PermissaoRepository;

@Service
public class PermissaoService implements IGenericService<Permissao>{
@Autowired
private PermissaoRepository permissaoRepository;

	@Override
	public List<Permissao> findAll() {
		// TODO Auto-generated method stub
		return permissaoRepository.findAll();
	}

	@Override
	public Permissao save(Permissao entity) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Permissao findById(long id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void delete(Permissao entity) {
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
