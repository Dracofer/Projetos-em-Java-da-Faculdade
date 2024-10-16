package br.com.turma.teste;

import br.com.turma.jdbc.Aluno;
import br.com.turma.jdbc.AlunoDao;

public class TesteMostrarAlunoPorCodigo {
public static void main(String[] args) {
		
		AlunoDao alunoDao = new AlunoDao();
		Aluno aluno = alunoDao.mostrarPorCodigo(6);
		
			System.out.println("Código: " + aluno.getCodigo());
			System.out.println("Nome: " + aluno.getNome());
			System.out.printf("1º Bim: %.1f - 2º Bim: %.1f - 3º Bim: %.1f - 4º Bim: %.1f\n", aluno.getPrim(),aluno.getSeg(),aluno.getTer(),aluno.getQua());
			System.out.println("Media: " + aluno.getMedia());
			System.out.println("Status Dinal: " + aluno.getStatus());
			System.out.println();
			
		}

	}
