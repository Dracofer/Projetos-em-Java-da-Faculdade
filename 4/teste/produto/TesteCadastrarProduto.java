package br.com.turma.teste.produto;

import br.com.turma.sistema.Produto;
import br.com.turma.sistema.ProdutoDao;

public class TesteCadastrarProduto {

	public static void main(String[] args) {
				
			Produto produto = new Produto(0, "Escova de Dente",7.5,3, 0);
			
			ProdutoDao produtoDao = new ProdutoDao();
			produtoDao.cadastrar(produto);

		}
		}