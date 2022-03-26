package com.example.demo.controller.form;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import com.example.demo.model.Produtos;


import lombok.Data;

@Data
public class ProdutosForm {
	
	@NotNull @NotEmpty
	private String nome;
	@NotNull @NotEmpty 
	private String valor;

	public Produtos converter() {
		return new Produtos(nome,valor);
	}
}
