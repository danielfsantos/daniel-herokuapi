package com.example.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.model.Preco;

public interface PrecoRepository extends JpaRepository<Preco, Long>{
	
	
}
