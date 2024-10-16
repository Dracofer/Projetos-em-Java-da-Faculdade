package br.com.turma.jdbc;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class AlunoDao {
	
	public void cadastrar(Aluno aluno) {

		
		try {
			
		//1)Pegar uma conexão com o banco de dados
		Connection con = Conexao.obterConexão();
		
		//2) Definir o comando que será executado no banco de dados 
		String sql = "INSERT INTO aluno(nome,prim,seg,ter,qua,media,status_final) VALUES(?,?,?,?,?,?,?)";
		
		//3) preparar a linha de instrução
		PreparedStatement preparador = con.prepareStatement(sql);
		preparador.setString(1, aluno.getNome());
		preparador.setDouble(2, aluno.getPrim());
		preparador.setDouble(3, aluno.getSeg());
		preparador.setDouble(4, aluno.getTer());
		preparador.setDouble(5, aluno.getQua());
		preparador.setDouble(6, aluno.getMedia());
		preparador.setString(7, aluno.getStatus());
		
		preparador.execute();
		
		System.out.println("Aluno cadastrado com sucesso!");
		
	} catch (SQLException e) {
		System.err.println("Não foi possivel cadastrar o aluno!");
		e.printStackTrace();
	}

}

    public ArrayList<Aluno> mostrarTodos(){
    	
    	Connection con = Conexao.obterConexão();
    	ArrayList<Aluno> alunos = new ArrayList<>();
    	
    	String sql = "SELECT * from aluno";
    	
    	try {
    		PreparedStatement preparador = con.prepareStatement(sql);
    		ResultSet resultado = preparador.executeQuery();
    		
    		while(resultado.next()) {
    			
    			Aluno aluno = new Aluno();
    			aluno.setCodigo(resultado.getInt("codigo"));
    			aluno.setNome(resultado.getString("nome"));
    			aluno.setPrim(resultado.getDouble("Prim"));
    			aluno.setSeg(resultado.getDouble("Seg"));
    			aluno.setTer(resultado.getDouble("Ter"));
    			aluno.setQua(resultado.getDouble("Qua"));
    			aluno.setMedia(resultado.getDouble("Media"));
    			aluno.setStatus(resultado.getString("status_final"));
    			
    			alunos.add(aluno);
    		}
    		
    	}catch (SQLException e) {
    		e.printStackTrace();
    	}
    	
    	return alunos;
    	    	
    }
    
    public Aluno mostrarPorCodigo(int codigo){
    	
    	Connection con = Conexao.obterConexão();
    	Aluno aluno = null;
    	
    	String sql = "SELECT * from aluno WHERE codigo = ?";
    	
    	try {
    		PreparedStatement preparador = con.prepareStatement(sql);
    		preparador.setInt(1, codigo);
    		ResultSet resultado = preparador.executeQuery();
    		
    		if(resultado.next() ) {
    			aluno = new Aluno();
    			aluno.setCodigo(resultado.getInt("codigo"));
    			aluno.setNome(resultado.getString("nome"));
    			aluno.setPrim(resultado.getDouble("Prim"));
    			aluno.setSeg(resultado.getDouble("Seg"));
    			aluno.setTer(resultado.getDouble("Ter"));
    			aluno.setQua(resultado.getDouble("Qua"));
    			aluno.setMedia(resultado.getDouble("Media"));
    			aluno.setStatus(resultado.getString("status_final"));
    			
    		}
    		
    	}catch (SQLException e) {
    		e.printStackTrace();
    	}
    	
    	return aluno;
    	
    }
    
    public void excluirPorCodigo(int codigo) {


    	
    	Connection con = Conexao.obterConexão();
    	
    	String sql = "DELETE FROM aluno WHERE codigo=?";
    	
    	try {
    		PreparedStatement preparador = con.prepareStatement(sql);
    		preparador.setInt(1, codigo);
    		
    		preparador.execute();
    		preparador.close();
    		
    		System.out.println("Aluno excluído com sucesso!!!");
    		
    		
    	}catch (SQLException e) {
    		e.printStackTrace();
    	}
    }

    public void alterarPorCodigo(Aluno aluno ) {
    	
    	Connection con = Conexao.obterConexão();
    	
    	String sql = "UPDATE aluno SET nome=?,prim=?,seg=?,ter=?,qua=?,media=?,status_final=? WHERE codigo=?";
    	
    	try {
    		PreparedStatement preparador = con.prepareStatement(sql);
    		preparador.setString(1, aluno.getNome());
    		preparador.setDouble(2, aluno.getPrim());
    		preparador.setDouble(3, aluno.getSeg());
    		preparador.setDouble(4, aluno.getTer());
    		preparador.setDouble(5, aluno.getQua());
    		preparador.setDouble(6, aluno.getMedia());
    		preparador.setString(7, aluno.getStatus());
    		preparador.setInt(8, aluno.getCodigo());
    		
    		preparador.execute();
    		preparador.close();
    		
    		System.out.println("O aluno foi alterado com sucesso");
    		
    	}catch (SQLException e) {
    		System.err.println("Erro ao alterar o aluno!");
    		e.printStackTrace();
    	}
    	
    }


}