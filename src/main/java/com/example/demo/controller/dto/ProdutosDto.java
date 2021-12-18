package com.example.demo.controller.dto;

import java.util.List;
import java.util.stream.Collectors;

import com.example.demo.model.Produtos;

import lombok.Data;

@Data
public class ProdutosDto {
	
	private Long id;
	private String nome;
	private String valor;
	
	
	public ProdutosDto(Produtos produto){
		this.id = produto.getId();
		this.nome = produto.getNome();
		this.valor = produto.getValor();
	}
		
	public static List<ProdutosDto> converter(List<Produtos> produtos) {
		return produtos.stream().map(ProdutosDto::new).collect(Collectors.toList());
	}

}
