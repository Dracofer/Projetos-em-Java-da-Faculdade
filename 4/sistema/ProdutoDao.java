package br.com.turma.sistema;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class ProdutoDao {
	
		public void cadastrar(Produto produto) {

			
			try {
				
			//1)Pegar uma conex�o com o banco de dados
			Connection con = Conexao.obterConex�o();
			
			//2) Definir o comando que ser� executado no banco de dados 
			String sql = "INSERT INTO produto(nome,pre�o,quantidade,subtotal) VALUES(?,?,?,?)";
			
			//3) preparar a linha de instru��o
			PreparedStatement preparador = con.prepareStatement(sql);
			preparador.setString(1, produto.getNome());
			preparador.setDouble(2, produto.getPre�o());
			preparador.setDouble(3, produto.getQuantidade());
			preparador.setDouble(4, produto.getSubtotal());
			
			preparador.execute();
			
			System.out.println("Produto cadastrado com sucesso!");
			
		} catch (SQLException e) {
			System.err.println("N�o foi possivel cadastrar o produto!");
			e.printStackTrace();
		}

	}

	    public ArrayList<Produto> mostrarTodos(){
	    	
	    	Connection con = Conexao.obterConex�o();
	    	ArrayList<Produto> produtos = new ArrayList<>();
	    	
	    	String sql = "SELECT * from produto";
	    	
	    	try {
	    		PreparedStatement preparador = con.prepareStatement(sql);
	    		ResultSet resultado = preparador.executeQuery();
	    		
	    		while(resultado.next()) {
	    			
	    			Produto produto = new Produto();
	    			produto.setCodigo(resultado.getInt("codigo"));
	    			produto.setNome(resultado.getString("nome"));
	    			produto.setPre�o(resultado.getDouble("pre�o"));
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
	    	
	    	Connection con = Conexao.obterConex�o();
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
	    			produto.setPre�o(resultado.getDouble("pre�o"));
	    			produto.setQuantidade(resultado.getInt("quantidade"));
	    			produto.setSubtotal(resultado.getDouble("subtotal"));
	    			
	    			
	    		}
	    		
	    	}catch (SQLException e) {
	    		e.printStackTrace();
	    	}
	    	
	    	return produto;
	    	
	    }
	    
	    public void excluirPorCodigo(int codigo) {


	    	
	    	Connection con = Conexao.obterConex�o();
	    	
	    	String sql = "DELETE FROM produto WHERE codigo=?";
	    	
	    	try {
	    		PreparedStatement preparador = con.prepareStatement(sql);
	    		preparador.setInt(1, codigo);
	    		
	    		preparador.execute();
	    		preparador.close();
	    		
	    		System.out.println("Produto exclu�do com sucesso!!!");
	    		
	    		
	    	}catch (SQLException e) {
	    		e.printStackTrace();
	    	}
	    }

	    public void alterarPorCodigo(Produto produto ) {
	    	
	    	Connection con = Conexao.obterConex�o();
	    	
	    	String sql = "UPDATE produto SET nome=?,pre�o=?,quantidade=?,subtotal=? WHERE codigo=?";
	    	
	    	try {
	    		PreparedStatement preparador = con.prepareStatement(sql);
	    		preparador.setString(1, produto.getNome());
	    		preparador.setDouble(2, produto.getPre�o());
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

