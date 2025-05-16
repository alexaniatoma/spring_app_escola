package com.alexania.app.escola.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;

import com.alexania.app.escola.model.Professor;

public interface ProfessorRepository extends JpaRepository<Professor, Long>{
	public List <Professor>findByNomeContainingIgnoreCase(@Param("nome")String nome);

}
