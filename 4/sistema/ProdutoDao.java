package br.com.turma.sistema;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class ProdutoDao {
	
		public void cadastrar(Produto produto) {

			
			try {
				
			//1)Pegar uma conexão com o banco de dados
			Connection con = Conexao.obterConexão();
			
			//2) Definir o comando que será executado no banco de dados 
			String sql = "INSERT INTO produto(nome,preço,quantidade,subtotal) VALUES(?,?,?,?)";
			
			//3) preparar a linha de instrução
			PreparedStatement preparador = con.prepareStatement(sql);
			preparador.setString(1, produto.getNome());
			preparador.setDouble(2, produto.getPreço());
			preparador.setDouble(3, produto.getQuantidade());
			preparador.setDouble(4, produto.getSubtotal());
			
			preparador.execute();
			
			System.out.println("Produto cadastrado com sucesso!");
			
		} catch (SQLException e) {
			System.err.println("Não foi possivel cadastrar o produto!");
			e.printStackTrace();
		}

	}

	    public ArrayList<Produto> mostrarTodos(){
	    	
	    	Connection con = Conexao.obterConexão();
	    	ArrayList<Produto> produtos = new ArrayList<>();
	    	
	    	String sql = "SELECT * from produto";
	    	
	    	try {
	    		PreparedStatement preparador = con.prepareStatement(sql);
	    		ResultSet resultado = preparador.executeQuery();
	    		
	    		while(resultado.next()) {
	    			
	    			Produto produto = new Produto();
	    			produto.setCodigo(resultado.getInt("codigo"));
	    			produto.setNome(resultado.getString("nome"));
	    			produto.setPreço(resultado.getDouble("preço"));
	    			produto.setQuantidade(resultado.getInt("quantidade"));
	    			produto.setSubtotal(resultado.getDouble("subtotal"));
	    			
	    			
	    			produtos.add(produto);
	    		}
	    		
	    	}catch (SQLException e) {
	    		e.printStackTrace();
	    	}
	    	
	    	return produtos;
	    	    	
	    }
	    
	    public Produto mostrarPorCodigo(int codigo){
	    	
	    	Connection con = Conexao.obterConexão();
	    	Produto produto = null;
	    	
	    	String sql = "SELECT * from produto WHERE codigo = ?";
	    	
	    	try {
	    		PreparedStatement preparador = con.prepareStatement(sql);
	    		preparador.setInt(1, codigo);
	    		ResultSet resultado = preparador.executeQuery();
	    		
	    		if(resultado.next() ) {
	    			produto = new Produto();
	    			produto.setCodigo(resultado.getInt("codigo"));
	    			produto.setNome(resultado.getString("nome"));
	    			produto.setPreço(resultado.getDouble("preço"));
	    			produto.setQuantidade(resultado.getInt("quantidade"));
	    			produto.setSubtotal(resultado.getDouble("subtotal"));
	    			
	    			
	    		}
	    		
	    	}catch (SQLException e) {
	    		e.printStackTrace();
	    	}
	    	
	    	return produto;
	    	
	    }
	    
	    public void excluirPorCodigo(int codigo) {


	    	
	    	Connection con = Conexao.obterConexão();
	    	
	    	String sql = "DELETE FROM produto WHERE codigo=?";
	    	
	    	try {
	    		PreparedStatement preparador = con.prepareStatement(sql);
	    		preparador.setInt(1, codigo);
	    		
	    		preparador.execute();
	    		preparador.close();
	    		
	    		System.out.println("Produto excluído com sucesso!!!");
	    		
	    		
	    	}catch (SQLException e) {
	    		e.printStackTrace();
	    	}
	    }

	    public void alterarPorCodigo(Produto produto ) {
	    	
	    	Connection con = Conexao.obterConexão();
	    	
	    	String sql = "UPDATE produto SET nome=?,preço=?,quantidade=?,subtotal=? WHERE codigo=?";
	    	
	    	try {
	    		PreparedStatement preparador = con.prepareStatement(sql);
	    		preparador.setString(1, produto.getNome());
	    		preparador.setDouble(2, produto.getPreço());
	    		preparador.setDouble(3, produto.getQuantidade());
	    		preparador.setDouble(4, produto.getSubtotal());
	    		preparador.setInt(5, produto.getCodigo());
	    		
	    		preparador.execute();
	    		preparador.close();
	    		
	    		System.out.println("O produto foi alterado com sucesso");
	    		
	    	}catch (SQLException e) {
	    		System.err.println("Erro ao alterar o produto!");
	    		e.printStackTrace();
	    	}
	    	
	    }


	}

