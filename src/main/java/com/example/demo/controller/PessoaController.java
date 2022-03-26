package com.example.demo.controller;

import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.controller.dto.PessoaDto;
import com.example.demo.controller.dto.detalhesPessoaDto;
import com.example.demo.model.Pessoa;
import com.example.demo.repository.PessoaRepository;

@RequestMapping("/pessoa")
@RestController
public class PessoaController {

	@Autowired
	private PessoaRepository pessoaRepository;

	@PostMapping
	public Pessoa savePessoa(@RequestBody Pessoa pessoa) {
		return pessoaRepository.save(pessoa);
	}

	@GetMapping
	public Page<PessoaDto> listar(@RequestParam(required = false) String nome,
			@PageableDefault(sort = "nome", direction = Direction.ASC, page = 0, size = 10) Pageable paginacao) {

		if (nome == null) {
			Page<Pessoa> pessoa = pessoaRepository.findAll(paginacao);
			return PessoaDto.converter(pessoa);
		}

		Page<Pessoa> pessoa = pessoaRepository.findByNome(nome, paginacao);
		return PessoaDto.converter(pessoa);

	}

	@GetMapping("/{Id}")
	public ResponseEntity<detalhesPessoaDto> detalhar(@PathVariable Long Id) {
		Optional<Pessoa> pessoa = pessoaRepository.findById(Id);
		if (pessoa.isPresent()) {
			return ResponseEntity.ok(new detalhesPessoaDto(pessoa.get()));
		}
		return ResponseEntity.notFound().build();
	}

	@DeleteMapping("/{Id}")
	@Transactional
	public ResponseEntity<?> excluirPessoa(@PathVariable Long Id) {
		Optional<Pessoa> pessoa = pessoaRepository.findById(Id);
		if (pessoa.isPresent()) {
			pessoaRepository.deleteById(Id);
			return ResponseEntity.ok().build();
		}
		return ResponseEntity.notFound().build();
	}

}
