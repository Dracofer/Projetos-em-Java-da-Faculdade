package br.com.turma.teste.produto;

import java.sql.SQLException;

import br.com.turma.sistema.Conexao;

public class TesteConex�oBancoDeDados {
		public static void main(String[] args) throws SQLException { 

			Conexao.obterConex�o();
	}
}
