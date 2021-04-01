package com.br.sfb.crcjud.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import com.br.sfb.crcjud.entities.Perfil;
import com.br.sfb.crcjud.repository.PerfilPageRepository;

@Service
public class PerfilService{

@Autowired
private PerfilPageRepository perfilPageRepository;

	public Iterable<Perfil> findAllPageable(Pageable pageable) {		
		return perfilPageRepository.findAll(pageable);
	}
	public Iterable<Perfil> findNamePageable(String nome,Pageable pageable) {		
		return perfilPageRepository.findByNome(nome, pageable);
	}

	public Perfil save(Perfil grupo) {
		perfilPageRepository.save(grupo);
		return null;
	}	
	public Perfil findById(long id) {		
		return perfilPageRepository.findById(id).get();
	}
	public List<Perfil> findAll() {		
		return perfilPageRepository.findAll();
	}

}
