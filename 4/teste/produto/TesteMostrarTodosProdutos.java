package br.com.turma.teste.produto;

import java.util.ArrayList;

import br.com.turma.sistema.Produto;
import br.com.turma.sistema.ProdutoDao;

public class TesteMostrarTodosProdutos {
	
public static void main(String[] args) {
		
		ProdutoDao produtoDao = new ProdutoDao();
		ArrayList<Produto> produtos = produtoDao.mostrarTodos();
		
		for(Produto produto:produtos) {
			
			System.out.println("C�digo: " + produto.getCodigo());
			System.out.println("Nome: " + produto.getNome());
			System.out.println("1� Produto: " + produto.getPre�o());
			System.out.println("2� Produto: " + produto.getQuantidade());
			System.out.println("subtotal: " + produto.getSubtotal());		
			System.out.println();
			
		}

	}

}
