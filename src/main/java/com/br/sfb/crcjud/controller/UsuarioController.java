package com.br.sfb.crcjud.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.br.sfb.crcjud.entities.Perfil;
import com.br.sfb.crcjud.entities.Permissao;
import com.br.sfb.crcjud.entities.Usuario;
import com.br.sfb.crcjud.services.PerfilService;
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
private PerfilService grupoService;

@GetMapping()
public ModelAndView PerfilIndex(Model model) {
	ModelAndView mv = new ModelAndView("usuario/usuario");		
	return mv;	
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
	Perfil grupo = new Perfil();
	Permissao permissoes = new Permissao();
	//model.addAttribute("grupo",grupo);
	model.addAttribute("grupo",grupoService.findById(3l));
	model.addAttribute("permissao",permissaoService.findAll());
	return mv;	
}
@GetMapping("/g2")
public ModelAndView UsuariosAllss(Model model) {
	ModelAndView mv = new ModelAndView("grupo-list");
	return mv;	
}
@PostMapping("/grupo")
public ModelAndView UsuariosAlls(@ModelAttribute("grupo") Perfil grupo,RedirectAttributes attributes) {
grupo.getPermissoes().forEach(action -> System.out.println(action.getNome()));
	//Grupo grupo = new Grupo();
	//grupo.setNome(nome);
	//grupo.setPermissoes(permissao);
	attributes.addFlashAttribute("mensagem", "Em breve você receberá um e-mail para redefinir sua senha.");
    grupoService.save(grupo);
    return new ModelAndView("redirect:/usuario/g4");
}
@GetMapping("/g3")
@ResponseBody
public Iterable<Perfil> UsuariosAllsss(Pageable pageable) {	
	return grupoService.findAllPageable(pageable);	
}
@PostMapping("grupo/serch")
public String UsuariosAllsss(@RequestParam String nome,Model model,Pageable pageable) {	
	model.addAttribute("pageable", grupoService.findNamePageable(nome,pageable));
	return "grupo-list";
}
@GetMapping("/g4")
public String UsuariosAllsss(Pageable pageable,Model model) {	

	model.addAttribute("pageable", grupoService.findAllPageable(pageable));
	return "grupo-list";

}

}
