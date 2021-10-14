package com.project.kirihub.ResponseDTO;

import com.project.kirihub.requestDTO.FormaDePagamentoRequestDTO;
import com.project.kirihub.requestDTO.ProdutoRequestDTO;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class RetornoDeDadosDeCompra {

	private Integer numeroDaParcela;
	private String valorDaParcela;
	private String taxaDeJuros;
	
	public RetornoDeDadosDeCompra( FormaDePagamentoRequestDTO formaDePagamentoDTO, String valorParcela, String taxa) {
		numeroDaParcela = formaDePagamentoDTO.getNumeroDeParcelas();
		valorDaParcela = valorParcela;
		taxaDeJuros = taxa;
	}
}
