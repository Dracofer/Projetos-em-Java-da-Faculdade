package br.com.turma.teste.produto;

import br.com.turma.sistema.Produto;
import br.com.turma.sistema.ProdutoDao;

public class TesteMostrarProdutoPorCódigo {
public static void main(String[] args) {
		
		ProdutoDao produtoDao = new ProdutoDao();
		Produto produto = produtoDao.mostrarPorCodigo(3);
		
			System.out.println("Código: " + produto.getCodigo());
			System.out.println("Nome: " + produto.getNome());
			System.out.printf("preço: %.1f - quantidade: %.1f", produto.getPreço(),produto.getQuantidade());
			System.out.println("subtotal: " + produto.getSubtotal());
			System.out.println();
			
		}

	}
