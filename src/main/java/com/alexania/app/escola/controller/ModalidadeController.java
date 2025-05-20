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

import com.alexania.app.escola.model.Modalidade;
import com.alexania.app.escola.model.Professor;
import com.alexania.app.escola.repository.ModalidadeRepository;
import com.alexania.app.escola.repository.ProfessorRepository;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/modalidades")
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class ModalidadeController {
	
	@Autowired
	private ModalidadeRepository modalidadeRepository;

	
	@GetMapping
	public ResponseEntity<List<Modalidade>> getAll(){
		return ResponseEntity.ok(modalidadeRepository.findAll());
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<Modalidade>getById(@PathVariable Long id) {
		return modalidadeRepository.findById(id)
				.map(resposta -> ResponseEntity.ok(resposta))
				.orElse(ResponseEntity.status(HttpStatus.NOT_FOUND).build());
	}
	
	@GetMapping("/descricao/{descricao}")
	public ResponseEntity<List<Modalidade>>getByNome(@PathVariable String descricao) {
		return ResponseEntity.ok(modalidadeRepository.findByDescricaoContainingIgnoreCase(descricao));
	}
	
	@PostMapping
	public ResponseEntity<Modalidade> post(@Valid @RequestBody Modalidade modalidade) {
		return ResponseEntity.status(HttpStatus.CREATED)
				.body(modalidadeRepository.save(modalidade));
	}
	
	@PutMapping
	public ResponseEntity<Modalidade> put(@Valid @RequestBody Modalidade modalidade) {
		return modalidadeRepository.findById(modalidade.getId())
				.map(resposta -> ResponseEntity.status(HttpStatus.OK)
						.body(modalidadeRepository.save(modalidade)))
				.orElse(ResponseEntity.status(HttpStatus.NOT_FOUND).build());
	}
	
	@ResponseStatus(HttpStatus.NO_CONTENT)
	@DeleteMapping("/{id}")
	public void delete(@PathVariable Long id) {
		Optional<Modalidade> modalidade = modalidadeRepository.findById(id);
		
		if(modalidade.isEmpty())
			throw new ResponseStatusException(HttpStatus.NOT_FOUND);

			modalidadeRepository.deleteById(id);		
	}
	
}
