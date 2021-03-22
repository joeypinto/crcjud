package com.br.sfb.crcjud.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.br.sfb.crcjud.entities.Usuario;
import com.br.sfb.crcjud.services.UsuarioService;

@RestController
@RequestMapping("/usuario")
public class UsuarioController {
@Autowired
private UsuarioService usuarioService;


@GetMapping
public List<Usuario> UsuariosAll() {
	return usuarioService.findAll();
	
}


@PostMapping
public Usuario UsuarioSave(@RequestBody Usuario usuario) {
	BCryptPasswordEncoder encore = new BCryptPasswordEncoder();
	usuario.setSenha(encore.encode(usuario.getSenha()));
	return usuarioService.save(usuario);
	
}
	
}
