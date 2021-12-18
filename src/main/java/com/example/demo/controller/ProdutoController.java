package com.example.demo.controller;

import java.net.URI;
import java.util.List;

import javax.transaction.Transactional;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

import com.example.demo.controller.dto.ProdutosDto;
import com.example.demo.controller.form.ProdutosForm;
import com.example.demo.model.Produtos;
import com.example.demo.repository.ProdutoRepository;

@RestController
@RequestMapping("/produtos")
public class ProdutoController {

	@Autowired
	private ProdutoRepository produtoRepository;

	@GetMapping
	public List<ProdutosDto> Listar(String nome) {
		if (nome == null) {
			List<Produtos> produto = produtoRepository.findAll();
			return ProdutosDto.converter(produto);
		} else {
			List<Produtos> produto = produtoRepository.findByNome(nome);
			return ProdutosDto.converter(produto);
		}
	}

	@PostMapping
	@ResponseStatus(HttpStatus.CREATED)
	public ResponseEntity<ProdutosDto> adicionar(@RequestBody @Valid ProdutosForm form,
			UriComponentsBuilder uriBuilder) {
		Produtos produto = form.converter();
		produtoRepository.save(produto);
		URI uri = uriBuilder.path("/produtos/{id}").buildAndExpand(produto.getId()).toUri();
		return ResponseEntity.created(uri).body(new ProdutosDto(produto));
	}

	@DeleteMapping("/{id}")
	@Transactional
	public ResponseEntity<?> deletar(@PathVariable Long id) {
		produtoRepository.deleteById(id);
		return ResponseEntity.ok().build();
	}

}
