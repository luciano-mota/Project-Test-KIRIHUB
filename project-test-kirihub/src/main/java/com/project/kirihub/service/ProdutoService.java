package com.project.kirihub.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.project.kirihub.ResponseDTO.ProdutoResponseDTO;
import com.project.kirihub.ResponseDTO.RetornoDeDadosDeCompra;
import com.project.kirihub.entity.Produto;
import com.project.kirihub.repository.ProdutoRepository;
import com.project.kirihub.requestDTO.FormaDePagamentoRequestDTO;
import com.project.kirihub.requestDTO.ProdutoRequestDTO;
import com.project.kirihub.utils.FormatDoubleCasasDecimais;

import javassist.NotFoundException;

@Service
public class ProdutoService {

	@Autowired
	private ProdutoRepository produtoRepository;

	public List<Produto> findAll() {
		return produtoRepository.findAll();
	}

	@Transactional(readOnly = true)
	public ProdutoResponseDTO findById(Long id) throws NotFoundException {
		try {
			Optional<Produto> produtoObj = produtoRepository.findById(id);
			Produto produto = produtoObj.get();
			return new ProdutoResponseDTO(produto);
		} catch (Exception e) {
			throw new NotFoundException("ID não encontrado!", e);
		}
	}
	
	public ProdutoResponseDTO findByName(String nome) throws NotFoundException {
		try {
			Optional<Produto> produtoOp = produtoRepository.findByProdutoNomeIgnoreCase(nome);
			Produto produto = produtoOp.get();
			return new ProdutoResponseDTO(produto);
		} catch (Exception e) {
			throw new NotFoundException("Nome de produto não encontrado!", e);
		}
	}

	public RetornoDeDadosDeCompra compraParcelada(ProdutoRequestDTO produtoDTO) throws NotFoundException {
		Optional<Produto> produtoOp = produtoRepository.findByProdutoNomeIgnoreCase(produtoDTO.getProdutoNome());
		Produto produto = produtoOp.get();
		if (produto.getId().equals(produtoDTO.getId())) {
			return dadosDeCompra(produtoDTO.getFormaDePagamento(), produtoDTO, produto);
		} else {
			throw new NotFoundException("Item não encontrado");
		}
	}

	public RetornoDeDadosDeCompra dadosDeCompra(FormaDePagamentoRequestDTO pagamentoRequestDTO,
			ProdutoRequestDTO produtoRequestDTO, Produto produto) {
		RetornoDeDadosDeCompra dadosDeCompra = new RetornoDeDadosDeCompra();
		dadosDeCompra.setNumeroDaParcela(pagamentoRequestDTO.getNumeroDeParcelas());
		if (pagamentoRequestDTO.getNumeroDeParcelas() > 6) {
			dadosDeCompra.setTaxaDeJuros(FormatDoubleCasasDecimais.format(2.369));
		} else {
			dadosDeCompra.setTaxaDeJuros(FormatDoubleCasasDecimais.format(0.0));
		}
		dadosDeCompra.setValorDaParcela(FormatDoubleCasasDecimais.format(calculoDaParcela(produtoRequestDTO, pagamentoRequestDTO, produto)));

		return dadosDeCompra;

	}

	public Double calculoDaParcela(ProdutoRequestDTO produtoDTO, FormaDePagamentoRequestDTO formaDePagamentoDTO,
			Produto produto) {
		Double valor = produto.getValorDoProduto() - formaDePagamentoDTO.getValorDeEntrada();
		Double resultado = valor / formaDePagamentoDTO.getNumeroDeParcelas();
		if (formaDePagamentoDTO.getNumeroDeParcelas() > 6) {
			return resultado * 2.369;
		}
		return resultado;
	}
}