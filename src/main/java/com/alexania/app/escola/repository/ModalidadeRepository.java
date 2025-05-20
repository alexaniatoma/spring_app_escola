package com.alexania.app.escola.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;

import com.alexania.app.escola.model.Modalidade;

public interface ModalidadeRepository extends JpaRepository<Modalidade, Long>{
	public List <Modalidade>findByDescricaoContainingIgnoreCase(@Param("descricao")String descricao);

}
