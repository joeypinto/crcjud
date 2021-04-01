package com.br.sfb.crcjud.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.br.sfb.crcjud.services.EntidadeService;
import com.br.sfb.crcjud.services.UfService;

@Controller
@RequestMapping("/vara")
public class VaraController {

	@Autowired
	private UfService ufService;
	@Autowired
	private EntidadeService entidadeService;

	@GetMapping
	public String VaraIndex(Model model) {
		model.addAttribute("ufs",ufService.findAll());
		model.addAttribute("entidades",entidadeService.findAll());
		return "vara/vara";

	}

}
