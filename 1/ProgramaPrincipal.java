package escola;

public class ProgramaPrincipal {

public static void main(String[] args) {
		
		Aluno estudante = new Aluno("Kevin Bizzi", 7.5, 8.0, 6.5, 9.0);
		
		System.out.println("Nome: " + estudante.getNomeAluno());
		System.out.println("Primeiro bimestre: " + estudante.getNota1());
		System.out.println("Segundo bimestre: " + estudante.getNota2());
		System.out.println("Terceiro bimestre: " + estudante.getNota3());
		System.out.println("Quarto bimestre: " + estudante.getNota4());
		System.out.println("Média: " + estudante.getMedia());
		System.out.println("Status: " + estudante.getStatus());
		
		Aluno estudante2 = new Aluno();
		estudante2.setNomeAluno("Pedro Carlos");
		estudante2.setNota1(9.5);
		estudante2.setNota2(8.0);
		estudante2.setNota3(5.5);
		estudante2.setNota4(5.0);
		estudante2.setMedia(estudante2.calcularMedia());
		estudante2.setStatus(estudante2.verificarStatus());
		
		System.out.println("Nome: " + estudante2.getNomeAluno());
		System.out.println("Primeiro bimestre: " + estudante2.getNota1());
		System.out.println("Segundo bimestre: " + estudante2.getNota2());
		System.out.println("Terceiro bimestre: " + estudante2.getNota3());
		System.out.println("Quarto bimestre: " + estudante2.getNota4());
		System.out.println("Média: " + estudante2.getMedia());
		System.out.println("Status: " + estudante2.getStatus());
		
		
	}


}