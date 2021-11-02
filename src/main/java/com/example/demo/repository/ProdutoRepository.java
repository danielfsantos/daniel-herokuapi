package com.example.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.model.Produtos;

public interface ProdutoRepository extends JpaRepository<Produtos, Long>{

}
