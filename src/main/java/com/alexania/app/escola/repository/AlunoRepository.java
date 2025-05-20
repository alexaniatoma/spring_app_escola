package com.alexania.app.escola.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;

import com.alexania.app.escola.model.Aluno;

public interface AlunoRepository extends JpaRepository<Aluno, Long>{
	public List <Aluno>findByNomeContainingIgnoreCase(@Param("nome")String nome);

}
