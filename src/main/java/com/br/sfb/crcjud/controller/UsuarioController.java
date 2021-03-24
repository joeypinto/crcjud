package com.br.sfb.crcjud.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.br.sfb.crcjud.entities.Grupo;
import com.br.sfb.crcjud.entities.Permissao;
import com.br.sfb.crcjud.entities.Usuario;
import com.br.sfb.crcjud.services.GrupoService;
import com.br.sfb.crcjud.services.PermissaoService;
import com.br.sfb.crcjud.services.UsuarioService;

@Controller
@RequestMapping("/usuario")
public class UsuarioController {
@Autowired
private UsuarioService usuarioService;
@Autowired
private PermissaoService permissaoService;
@Autowired
private GrupoService grupoService;

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

@GetMapping("/g")
public ModelAndView UsuariosAlls(Model model) {
	ModelAndView mv = new ModelAndView("grupo");
//	//("book", book);
	//mv.addObject("permissao",permissaoService.findAll());
//	
//	//mv.addObject("grupo",grupoService.findAll());
	Grupo grupo = new Grupo();
	Permissao permissoes = new Permissao();
	model.addAttribute("grupo",grupo);
	model.addAttribute("permissao",permissaoService.findAll());
	return mv;	
}
@PostMapping("/grupo")
public String UsuariosAlls(@ModelAttribute("grupo") Grupo grupo) {
grupo.getPermissoes().forEach(action -> System.out.println(action.getNome()));
	//Grupo grupo = new Grupo();
	//grupo.setNome(nome);
	//grupo.setPermissoes(permissao);
    grupoService.save(grupo);
	return "grupo";	
}
}
