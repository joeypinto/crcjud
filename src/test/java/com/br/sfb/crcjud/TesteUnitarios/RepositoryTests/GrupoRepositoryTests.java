package com.br.sfb.crcjud.TesteUnitarios.RepositoryTests;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.br.sfb.crcjud.entities.Perfil;
import com.br.sfb.crcjud.repository.PerfilPageRepository;

//@RunWith(SpringRunner.class)

@SpringBootTest
public class GrupoRepositoryTests {
	
 @Autowired
 private PerfilPageRepository grupoRepository;
 
 @Test
 public void insertGrupo() {
     Perfil user = new Perfil();
     user.setNome("Juizes");
  
     grupoRepository.save(user);
     Integer countUser = grupoRepository.findAll().size();
     assertEquals(1, countUser);
 }
}
