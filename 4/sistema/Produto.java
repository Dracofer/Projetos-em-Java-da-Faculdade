package br.com.turma.sistema;

public class Produto {
	
	// Construtor
	public Produto (int codigo,String nome, double pre�o, int quantidade, double subtotal) {
		this.codigo = codigo;
		this.nome = nome;
		this.pre�o = pre�o;
		this.quantidade = quantidade;
		this.subtotal = pre�o * quantidade;
	}

	public Produto () {
		
	}

	public Produto (int codigo,String nome, double pre�o, int quantidade, double subtotal, int alteracao) {
		this.codigo = codigo;
		this.nome = nome;
		this.pre�o = pre�o;
		this.quantidade = quantidade;
		this.subtotal = pre�o * quantidade;
		this.alteracao = alteracao;
	}

	
	// Atributos
	private int codigo;
	private String nome;
	private double pre�o;
	private int quantidade;
	private double subtotal;
	private int alteracao;
	
	// M�todos de calculos
	public double calcularSubtotal() {
		return this.quantidade * this.pre�o;
	}
	
	// M�todos Set/Get
	public void setCodigo(int codigo) {
		this.codigo = codigo;
	}
	public int getCodigo() {
		return codigo;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getNome() {
		return nome;
	}

	public void setPre�o(double pre�o) {
		this.pre�o = pre�o;
	}
	public double getPre�o() {
		return pre�o;
	}

	public void setQuantidade(int d) {
		this.quantidade = d;
	}
	public double getQuantidade() {
		return quantidade;
	}
	
	public void setSubtotal(double subtotal) {
		this.subtotal = subtotal;
	}
	public double getSubtotal() {
		return subtotal;
	}

	public void setAlteracao(int alteracao) {
		this.alteracao =alteracao; 
	}
	public int getAlteracao() {
		return alteracao;
	}
	
}
