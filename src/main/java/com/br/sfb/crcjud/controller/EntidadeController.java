package com.br.sfb.crcjud.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.br.sfb.crcjud.entities.Entidade;
import com.br.sfb.crcjud.entities.Perfil;
import com.br.sfb.crcjud.services.CidadeService;
import com.br.sfb.crcjud.services.EntidadeService;
import com.br.sfb.crcjud.services.UfService;

@Controller
@RequestMapping("entidade")
public class EntidadeController {

@Autowired
private UfService ufService;
@Autowired
private EntidadeService entidadeService;
@Autowired
private CidadeService cidadeService;	
@GetMapping
public String entidadeIndex(Model model) {
	model.addAttribute("entidade",new Entidade());
	model.addAttribute("ufs",ufService.findAll());
	//model.addAttribute("cidade",cidadeService.findAll());
return "entidade/entidade";	
}
@PostMapping
public ModelAndView entidadeSave(@ModelAttribute("entidade") Entidade entidade,RedirectAttributes attributes) {
	//perfil.getPermissoes().forEach(action -> System.out.println(action.getNome()));
	//System.out.println(perfil.getId());
	attributes.addFlashAttribute("mensagem", "Perfil salvo com sucesso!");
	entidadeService.save(entidade);
    return new ModelAndView("redirect:/entidade/list");
}	
@GetMapping("/list")
public String PerfilList(Pageable pageable,Model model) {	
	model.addAttribute("pageable", entidadeService.findAllPageable(pageable));
	return "entidade/entidade-list";
}
@GetMapping("/{id}")
public ModelAndView UsuariosUpdate(@PathVariable("id") long id,Model model) {
	System.out.println(id);
	ModelAndView mv = new ModelAndView("entidade/entidade");
	//model.addAttribute("perfil",perfilService.findById(id));
	//model.addAttribute("permissoes",permissaoService.findAll());
	return mv;	
}
@PostMapping("/serch")
public String UsuariosAllsss(@RequestParam String nome,Model model,Pageable pageable) {	
	model.addAttribute("pageable", entidadeService.findNamePageable(nome,pageable));
	return "entidade/entidade-list";
}	
}
