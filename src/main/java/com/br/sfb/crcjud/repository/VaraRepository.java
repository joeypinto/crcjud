package com.br.sfb.crcjud.repository;

import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import com.br.sfb.crcjud.entities.Vara;

@Repository
public interface VaraRepository extends PagingAndSortingRepository<Vara, Long>{

}
