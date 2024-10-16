package br.com.turma.jdbc;

public class Aluno {
	
	
	public Aluno(int codigo, String nome, double prim, double seg, double ter, double qua) {
		this.codigo = codigo;
		this.nome = nome;
		this.prim = prim;
		this.seg = seg;
		this.ter = ter;
		this.qua = qua;
		this.media = this.calcularMedia();
		this.status = verificarStatus();
	}
	public Aluno(String nome, double prim, double seg, double ter, double qua) {
		this.nome = nome;
		this.prim = prim;
		this.seg = seg;
		this.ter = ter;
		this.qua = qua;
		this.media = this.calcularMedia();
		this.status = verificarStatus();
	}
	
	public Aluno() {
		
	}

	private int codigo;
	private String nome;
	private double prim;
	private double seg;
	private double ter;
	private double qua;
	private double String;
	private double media;
	private String status;
	
	public double calcularMedia() {
		return (this.prim + this.seg + this.ter + this.qua)/4;
	}
	
	public String verificarStatus() {
		if(this.media>=7 && this.media<=10) {
			return "APROVADO";
		}else if(this.media >=5 && this.media<7) {
			return "RECUPERAÇÃO";
		}else if(this.media>=0 && this.media<5) {
			return "REPROVADO";
		}else {
			return "NOTA INVÁLIDA!";
		}
	}

	public int getCodigo() {
		return codigo;
	}

	public void setCodigo(int codigo) {
		this.codigo = codigo;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public double getPrim() {
		return prim;
	}

	public void setPrim(double prim) {
		this.prim = prim;
	}

	public double getSeg() {
		return seg;
	}

	public void setSeg(double seg) {
		this.seg = seg;
	}

	public double getTer() {
		return ter;
	}

	public void setTer(double ter) {
		this.ter = ter;
	}

	public double getQua() {
		return qua;
	}

	public void setQua(double qua) {
		this.qua = qua;
	}

	public double getString() {
		return String;
	}

	public void setString(double string) {
		String = string;
	}

	public double getMedia() {
		return media;
	}

	public void setMedia(double media) {
		this.media = media;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	
	
}
