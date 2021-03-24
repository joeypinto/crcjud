package com.br.sfb.crcjud.converter;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

import com.br.sfb.crcjud.entities.Permissao;
import com.br.sfb.crcjud.repository.PermissaoRepository;
@Component
public class PermissaoConverter implements Converter<String, Permissao>{

	@Autowired
	PermissaoRepository permissaoRepository;
	@Override
	public Permissao convert(String id) {
		return permissaoRepository.findByCodigo(Long.parseLong(id));
	}

}
