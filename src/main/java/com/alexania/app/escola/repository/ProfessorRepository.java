package com.alexania.app.escola.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.alexania.app.escola.model.Professor;

public interface ProfessorRepository extends JpaRepository<Professor, Long>{

}
