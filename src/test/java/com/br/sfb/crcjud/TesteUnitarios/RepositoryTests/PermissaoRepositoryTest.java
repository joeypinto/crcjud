package com.br.sfb.crcjud.TesteUnitarios.RepositoryTests;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.br.sfb.crcjud.entities.Permissao;
import com.br.sfb.crcjud.repository.PermissaoRepository;
import com.br.sfb.crcjud.services.PermissaoService;

@SpringBootTest
public class PermissaoRepositoryTest {
	 @Autowired
	 private PermissaoRepository grupoRepository;
	 
	 @Test
	 public void insertGrupo() {
	    Permissao user = new Permissao();
	     user.setNome("Juizes");	  
	     grupoRepository.save(user);
	     Integer countUser = grupoRepository.findAll().size();
	     assertEquals(1, countUser);
	 }
}
