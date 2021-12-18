package com.example.demo.controller;

import java.net.URI;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

import com.example.demo.controller.dto.PrecoDto;
import com.example.demo.model.Preco;
import com.example.demo.repository.PrecoRepository;


@RestController
@RequestMapping("/preco")
public class precoController {
		
	
		@Autowired
		private PrecoRepository precoRepository;
		
	
		@GetMapping("/{id}")
		public PrecoDto detalharPreco(@PathVariable() Long id) {
			Preco preco = precoRepository.getOne(id);
			return new PrecoDto(preco);
		}
		
		@PostMapping
		public Preco savePreco(@RequestBody Preco preco) {
			return precoRepository.save(preco);
		}
		
		
		
	
}
