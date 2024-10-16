package br.com.turma.sistema;

public class Produto {
	
	// Construtor
	public Produto (int codigo,String nome, double preço, int quantidade, double subtotal) {
		this.codigo = codigo;
		this.nome = nome;
		this.preço = preço;
		this.quantidade = quantidade;
		this.subtotal = preço * quantidade;
	}

	public Produto () {
		
	}

	public Produto (int codigo,String nome, double preço, int quantidade, double subtotal, int alteracao) {
		this.codigo = codigo;
		this.nome = nome;
		this.preço = preço;
		this.quantidade = quantidade;
		this.subtotal = preço * quantidade;
		this.alteracao = alteracao;
	}

	
	// Atributos
	private int codigo;
	private String nome;
	private double preço;
	private int quantidade;
	private double subtotal;
	private int alteracao;
	
	// Métodos de calculos
	public double calcularSubtotal() {
		return this.quantidade * this.preço;
	}
	
	// Métodos Set/Get
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

	public void setPreço(double preço) {
		this.preço = preço;
	}
	public double getPreço() {
		return preço;
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
