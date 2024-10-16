package br.com.turma.teste.produto;

import br.com.turma.sistema.Produto;
import br.com.turma.sistema.ProdutoDao;

public class TesteAlterarPorCódigo {
	
public static void main(String[] args) {
		
		Produto produto = new Produto();
		produto.setCodigo(2);
		produto.setNome("Salame");
		produto.setPreço(6.5);
		produto.setQuantidade(9);
		produto.setSubtotal(produto.calcularSubtotal());
		
		ProdutoDao produtoDao = new ProdutoDao();
		produtoDao.alterarPorCodigo(produto);

	}

}

