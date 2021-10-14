package com.project.kirihub.requestDTO;

import java.io.Serializable;

import com.project.kirihub.entity.Produto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ProdutoRequestDTO implements Serializable{

	private static final long serialVersionUID = 1L;
	
	private Long id;
	private String produtoNome;
	private Double valorDoProduto;
	private FormaDePagamentoRequestDTO formaDePagamento;
	
	public ProdutoRequestDTO(Produto produto) {
		id = produto.getId();
		produtoNome = produto.getProdutoNome();
		valorDoProduto = produto.getValorDoProduto();
	}
}
