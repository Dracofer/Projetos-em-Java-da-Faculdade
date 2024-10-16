package br.com.turma.teste;

import br.com.turma.jdbc.Aluno;
import br.com.turma.jdbc.AlunoDao;

public class TesteCadastrarAluno {
	
	public static void main(String[] args) {
		
	Aluno aluno = new Aluno("Bernado Figueira",7.5,8.0,9.5,7.0);
	
	AlunoDao alunoDao = new AlunoDao();
	alunoDao.cadastrar(aluno);

}
}