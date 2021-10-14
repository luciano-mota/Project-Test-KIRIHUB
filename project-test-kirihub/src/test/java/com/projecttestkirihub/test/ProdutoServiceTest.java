package com.projecttestkirihub.test;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.doReturn;

import java.util.Optional;
import java.util.UUID;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.junit.jupiter.api.TestInstance.Lifecycle;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;

import com.project.kirihub.ResponseDTO.ProdutoResponseDTO;
import com.project.kirihub.repository.ProdutoRepository;
import com.project.kirihub.service.ProdutoService;
import com.projecttestkirihub.mock.ProdutoResponseDTOMock;

import javassist.NotFoundException;

@TestInstance(Lifecycle.PER_CLASS)
public class ProdutoServiceTest {

	@InjectMocks
	private ProdutoService produtoService;

	@Mock
	private ProdutoRepository produtoRepository;

	@BeforeAll
	public void setUp() {
		MockitoAnnotations.initMocks(this);
	}

	@Test
	public void sucesso_BuscaDeUsuarioPorId() throws NotFoundException {
		doReturn(Optional.of(ProdutoResponseDTOMock.retornoObjProduto())).when(produtoRepository)
				.findById(Mockito.anyLong());
		ProdutoResponseDTO produtoDto = produtoService.findById(2L);
		assertNotNull(produtoDto);
	}

	@Test
	public void finById_Error_NotFound() {
		Mockito.doReturn(Optional.empty()).when(produtoRepository).findById(Mockito.anyLong());
		Exception exception = assertThrows(NotFoundException.class, () -> {
			ProdutoResponseDTO produtoDto = produtoService.findById(2L);
		});
		assertTrue(exception.getMessage().contains("ID não encontrado!"));
	}

	@Test
	public void sucesso_BuscaDeUsuarioPorNome() throws NotFoundException {
		doReturn(Optional.of(ProdutoResponseDTOMock.retornoObjProduto())).when(produtoRepository)
				.findByProdutoNomeIgnoreCase(Mockito.anyString());
		ProdutoResponseDTO produtoDto = produtoService.findByName("TV");
		assertNotNull(produtoDto);
	}

	@Test
	public void finByName_Error_NotFound() {
		Mockito.doReturn(Optional.empty()).when(produtoRepository).findByProdutoNomeIgnoreCase(Mockito.anyString());
		Exception exception = assertThrows(NotFoundException.class, () -> {
			ProdutoResponseDTO produtoDto = produtoService.findByName("TV");
		});
		assertTrue(exception.getMessage().contains("Nome de produto não encontrado!"));
	}
}
