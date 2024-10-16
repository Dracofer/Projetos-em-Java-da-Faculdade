package br.com.turma.sistema;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Conexao {
	
		public static Connection obterConexão() {
			
			Connection con = null;
			try {
				con = DriverManager.getConnection("jdbc:mysql://localhost/dbprodutos?useSSL=false","root","root");
				System.out.println("Banco de Dados conectado com sucesso!");
			} catch (SQLException e) {
				System.err.println("Não foi possível conectar ao banco de dados");
				e.printStackTrace();
				
			}
			return con;
		}
	}
