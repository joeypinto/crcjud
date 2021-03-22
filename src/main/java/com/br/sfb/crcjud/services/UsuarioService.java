package com.br.sfb.crcjud.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.br.sfb.crcjud.entities.Usuario;
import com.br.sfb.crcjud.repository.UsuarioRepository;

@Service
public class UsuarioService implements IGenericService<Usuario> {
	@Autowired
	private UsuarioRepository usuarioRepository;
	
	@Override
	public List<Usuario> findAll() {		
		return usuarioRepository.findAll();
	}
	@Override
	public Usuario save(Usuario usuario) {		
		return usuarioRepository.save(usuario);
	}
	@Override
	public Usuario findById(long id) {
		// TODO Auto-generated method stub
		return null;
	}
	@Override
	public void delete(Usuario entity) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void deleteById(long id) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public long count() {
		return 0;
	}
	
}
