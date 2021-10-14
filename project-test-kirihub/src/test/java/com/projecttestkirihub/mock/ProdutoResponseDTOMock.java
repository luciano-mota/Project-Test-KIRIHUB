package com.projecttestkirihub.mock;

import com.project.kirihub.entity.Produto;

public class ProdutoResponseDTOMock {
	public static Produto retornoObjProduto() {
		Produto produto = new Produto();
		produto.setId(2L);
		produto.setProdutoNome("TV");
		produto.setValorDoProduto(750.00);
		return produto;
	}
}
