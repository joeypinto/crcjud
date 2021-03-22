package com.br.sfb.crcjud.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.br.sfb.crcjud.entities.Grupo;
@Repository
public interface GrupoRepository extends JpaRepository<Grupo, String> {
	
}
