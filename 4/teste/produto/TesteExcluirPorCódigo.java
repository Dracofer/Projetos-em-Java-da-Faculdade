package br.com.turma.teste.produto;

import br.com.turma.sistema.ProdutoDao;

public class TesteExcluirPorC�digo {
	
	public static void main(String[] args) {
	
	ProdutoDao produtoDao =new ProdutoDao();
	produtoDao.excluirPorCodigo(2);


}
}