package com.example.demo.controller.dto;

import java.util.List;
import java.util.stream.Collectors;

import com.example.demo.model.Preco;

import lombok.Data;

@Data
public class PrecoDto {
		private Double valor;
		
		public PrecoDto(Preco preco) {
			this.valor = preco.getValor();
		}

		public static List<PrecoDto> converter(List<Preco> preco) {
			// TODO Auto-generated method stub
			return preco.stream().map(PrecoDto::new).collect(Collectors.toList());
		}
}
