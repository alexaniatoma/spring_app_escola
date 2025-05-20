package com.alexania.app.escola.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import com.alexania.app.escola.model.Aluno;
import com.alexania.app.escola.model.Professor;
import com.alexania.app.escola.repository.ModalidadeRepository;
import com.alexania.app.escola.repository.ProfessorRepository;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/professores")
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class ProfessorController {
	
	@Autowired
	private ProfessorRepository professorRepository;
	
	@Autowired
	private ModalidadeRepository modalidadeRepository;
	
	@GetMapping
	public ResponseEntity<List<Professor>> getAll(){
		return ResponseEntity.ok(professorRepository.findAll());
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<Professor>getById(@PathVariable Long id) {
		return professorRepository.findById(id)
				.map(resposta -> ResponseEntity.ok(resposta))
				.orElse(ResponseEntity.status(HttpStatus.NOT_FOUND).build());
	}
	
	@GetMapping("/nome/{nome}")
	public ResponseEntity<List<Professor>>getByNome(@PathVariable String nome) {
		return ResponseEntity.ok(professorRepository.findByNomeContainingIgnoreCase(nome));
	}
	
	@PostMapping
	public ResponseEntity<Professor> post(@Valid @RequestBody Professor professor) {
		if(modalidadeRepository.existsById(professor.getModalidade().getId()))
		return ResponseEntity.status(HttpStatus.CREATED)
				.body(professorRepository.save(professor));
		throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Modalidade não existe!", null);
	}
	
	@PutMapping
	public ResponseEntity<Professor> put(@Valid @RequestBody Professor professor) {
		if(professorRepository.existsById(professor.getId())) {
			if(modalidadeRepository.existsById(professor.getModalidade().getId()))
				return ResponseEntity.status(HttpStatus.OK)
						.body(professorRepository.save(professor));	
				
		throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Modalidade não existe!" , null);
		
		}
		
	return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
				
	}
	
	@ResponseStatus(HttpStatus.NO_CONTENT)
	@DeleteMapping("/{id}")
	public void delete(@PathVariable Long id) {
		Optional<Professor> professor = professorRepository.findById(id);
		
		if(professor.isEmpty())
			throw new ResponseStatusException(HttpStatus.NOT_FOUND);

			professorRepository.deleteById(id);		
	}
	
}
