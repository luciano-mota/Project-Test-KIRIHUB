package com.project.kirihub.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.project.kirihub.entity.Produto;

public interface ProdutoRepository extends JpaRepository<Produto, Long>{

	Optional<Produto> findByProdutoNomeIgnoreCase(String produtoNome);

}
