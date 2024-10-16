package escola;

public class Aluno {
	
	
	//Construtor
	
	public Aluno(String nomeAluno,double nota1,double nota2,double nota3,double nota4){
		this.nomeAluno = nomeAluno;
		this.nota1 = nota1;
		this.nota2 = nota2;
		this.nota3 = nota3;
		this.nota4 = nota4;
		this.media = this.calcularMedia();
		this.status = this.verificarStatus();
	}
	//Construtor Padrão
	public Aluno() {
		
	}

	private String nomeAluno;
	private double nota1;
	private double nota2;
	private double nota3;
	private double nota4;
	private double media;
	private String status;
	
	
	
	//Getters and Setters

	public String getNomeAluno() {
		return nomeAluno;
	}
	public double getNota1() {
		return nota1;
	}
	public double getNota2() {
		return nota2;
	}
	public double getNota3() {
		return nota3;
	}
	public double getNota4() {
		return nota4;
	}
	public double getMedia() {
		return media;
	}
	public String getStatus() {
		return status;
	}
	public void setNomeAluno(String nomeAluno) {
		this.nomeAluno = nomeAluno;
	}
	public void setNota1(double nota1) {
		this.nota1 = nota1;
	}
	public void setNota2(double nota2) {
		this.nota2 = nota2;
	}
	public void setNota3(double nota3) {
		this.nota3 = nota3;
	}
	public void setNota4(double nota4) {
		this.nota4 = nota4;
	}
	public void setMedia(double media) {
		this.media = media;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	
	
	
	
	//Métodos
	
	
	public double calcularMedia(){
		return (this.nota1 + this.nota2 + this.nota3 + this.nota4)/4;
	}
	
	public String verificarStatus() {
		if(this.media >= 7.0) {
			return "APROVADO";
		}else if(this.media >= 5.0 && this.media< 7.0) {
			return "RECUPERAÇÃO";
		}else if(this.media > 0 && this.media< 5.0) {
			return "REPROVADO";
		}else {
			return "NOTA INVÁLIDA";
		}

	}
}