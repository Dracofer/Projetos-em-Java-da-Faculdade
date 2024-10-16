package br.com.turma.teste.produto;

import br.com.turma.sistema.Produto;
import br.com.turma.sistema.ProdutoDao;

public class TesteMostrarProdutoPorC�digo {
public static void main(String[] args) {
		
		ProdutoDao produtoDao = new ProdutoDao();
		Produto produto = produtoDao.mostrarPorCodigo(3);
		
			System.out.println("C�digo: " + produto.getCodigo());
			System.out.println("Nome: " + produto.getNome());
			System.out.printf("pre�o: %.1f - quantidade: %.1f", produto.getPre�o(),produto.getQuantidade());
			System.out.println("subtotal: " + produto.getSubtotal());
			System.out.println();
			
		}

	}
