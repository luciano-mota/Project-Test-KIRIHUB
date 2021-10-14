package com.project.kirihub.requestDTO;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class FormaDePagamentoRequestDTO {
	
	private Double valorDeEntrada;
	private int numeroDeParcelas;
}
