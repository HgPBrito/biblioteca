package com.generation.biblioteca.controller;

import java.util.List;

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
import org.springframework.web.bind.annotation.RestController;

import com.generation.biblioteca.model.Livro;
import com.generation.biblioteca.repository.LivroRepository;

@RestController
@RequestMapping("/livro")
@CrossOrigin("*")
public class LivroController {

	@Autowired 
	private LivroRepository repository;
	
	@GetMapping
	public ResponseEntity<List<Livro>> GetAll(){
		return ResponseEntity.ok(repository.findAll());
	}
	
	@GetMapping("/{isbn}")
	public ResponseEntity<Livro> GetByISBN(@PathVariable long isbn){
		return repository.findById(isbn)
				.map(resp -> ResponseEntity.ok(resp))
				.orElse(ResponseEntity.notFound().build());
	}
	
	@PostMapping
	public ResponseEntity<Livro> Post(@RequestBody Livro livro){
		return ResponseEntity.status(HttpStatus.CREATED).body(repository.save(livro));
	}
	
	@PutMapping
	public ResponseEntity<Livro> Put(@RequestBody Livro livro){
		return ResponseEntity.status(HttpStatus.OK).body(repository.save(livro));
	}
	
	@DeleteMapping("/{isbn}")
	public void Delete(@PathVariable long isbn) {
		repository.deleteById(isbn);
	}
}
