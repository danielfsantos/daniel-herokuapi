package com.example.demo.controller.dto;

import com.example.demo.model.Pessoa;

import lombok.Data;

@Data
public class detalhesPessoaDto {
	private String nome;
	private String sobrenome;
	
	public detalhesPessoaDto(Pessoa pessoa) {
		this.nome = pessoa.getNome();
		this.sobrenome = pessoa.getSobrenome();
	}
	
	
}
