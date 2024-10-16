package br.com.turma.teste;

import br.com.turma.jdbc.Aluno;
import br.com.turma.jdbc.AlunoDao;

public class TesteAlterarPorCodigo {

	public static void main(String[] args) {
		
		Aluno aluno01 = new Aluno();
		aluno01.setCodigo(6);
		aluno01.setNome("Paulo Lima");
		aluno01.setPrim(6.5);
		aluno01.setSeg(9.5);
		aluno01.setTer(8.5);
		aluno01.setQua(7.5);
		aluno01.setMedia(aluno01.calcularMedia());
		aluno01.setStatus(aluno01.verificarStatus());
		
		AlunoDao alunoDao = new AlunoDao();
		alunoDao.alterarPorCodigo(aluno01);

	}

}
