package br.com.turma.teste;

import java.sql.SQLException;

import br.com.turma.jdbc.Conexao;

public class TesteConexaoBancoDeDados {
	public static void main(String[] args) throws SQLException { 

		Conexao.obterConex�o();
}
}