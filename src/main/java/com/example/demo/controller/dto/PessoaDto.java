package com.example.demo.controller.dto;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.data.domain.Page;

import com.example.demo.model.Pessoa;

import lombok.Data;

@Data
public class PessoaDto {

	private String nome;
	private String sobrenome;

	public PessoaDto(Pessoa pessoa) {
		this.nome = pessoa.getNome();
		this.sobrenome = pessoa.getSobrenome();
	}

	public static Page<PessoaDto> converter(Page<Pessoa> pessoa) {
		return pessoa.map(PessoaDto::new);
	}

}
