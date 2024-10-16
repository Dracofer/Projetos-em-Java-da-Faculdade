package br.com.turma.sistema;

import java.util.ArrayList;
import java.util.Scanner;

public class MenuPrincipal {

	public static void main(String[] args) {
		
		Scanner input = new Scanner(System.in);
		int opcao;
		int codigo;
		int codigoAlterar;
		String nome;
		double pre�o;
		int quantidade;
		double subtotal;
		
		do {
			System.out.println("======== MENU PRINCIPAL========");
			System.out.println("1 - Cadastrar Produto");
			System.out.println("2 - Mostrar Todos os Produtos");
			System.out.println("3 - Mostrar Produto pelo C�digo");
			System.out.println("4 - Alterar Produto");
			System.out.println("5 - Excluir Produto");
			System.out.println("6 - Sair do Sistema");
			System.out.print("Escolha a op��o desejada: ");
			
			opcao = input.nextInt();
			System.out.println();
			
			switch(opcao) {

				case 1:
					
					System.out.println("Cadastrar Produto");

					System.out.println("Digite o c�digo do Produto: ");
					codigo = input.nextInt();

					System.out.println("Digite o nome do Produto: ");
					nome = input.next();

					System.out.println("Digite o pre�o do Produto: ");
					pre�o = input.nextDouble();
					
					System.out.println("Digite a quantidade do Produto: ");
					quantidade = input.nextInt();
					System.out.println();
					
					subtotal = pre�o * (double)quantidade;	

					Produto produtos01 = new Produto (codigo,nome,pre�o,quantidade,subtotal);
					ProdutoDao produtoDao = new ProdutoDao();
					produtoDao.cadastrar(produtos01);
					break;

				case 2:
					
					System.out.println("Mostrar Todos os Produtos");
					
					ProdutoDao produtosDao = new ProdutoDao();
					ArrayList<Produto> produtosDoBanco = produtosDao.mostrarTodos();
					
					for(int i=0;i<produtosDoBanco.size(); i++) {
						
						Produto produtos = produtosDoBanco.get(i);
						
						System.out.println("C�digo: " + produtos.getCodigo());
						System.out.println("Produto: " + produtos.getNome());
						System.out.println("Pre�o: " + produtos.getPre�o());
						System.out.println("Quantidade: " + produtos.getQuantidade());
						System.out.println("SubTotal: " + produtos.getSubtotal());
						System.out.println();	
					}
					
					System.out.println("Estes s�o todos os nossos produtos!");
					System.out.println();
					break;

				case 3:
					
					System.out.println("Mostrar Produto Pelo C�digo");
					System.out.println();
					System.out.println("Digite o c�digo do item que deseja ver: ");
					System.out.println();
					codigo = input.nextInt();					
					
					ProdutoDao produtoDao2 = new ProdutoDao();
					Produto produtos = produtoDao2.mostrarPorCodigo(codigo);
					
					try {
						System.out.println("C�digo: " + produtos.getCodigo());
						System.out.println("Produto: " + produtos.getNome());
						System.out.println("Pre�o: " + produtos.getPre�o());
						System.out.println("Quantidade: " + produtos.getQuantidade());
						System.out.println("SubTotal: " + produtos.getSubtotal());
						System.out.println();	
						System.out.println("Produto consultado com sucesso!");
						System.out.println();
					}catch (Exception erro){
						System.err.println();
						System.err.println("Este produto n�o existe!");
						System.err.println();
					}
					
					break;

				case 4:
					
					System.out.println("Alterar produto");
					System.out.println();

					System.out.println("Digite o c�digo do produto que deseja alterar: ");
					codigoAlterar = input.nextInt();

					System.out.println("Novo c�digo para o produto: ");
					codigo = input.nextInt();
					
					System.out.println("Novo nome para o produto: ");
					nome = input.next();
					
					System.out.println("Nova quantidade do produto: ");
					quantidade = input.nextInt();
					
					System.out.println("Novo Pre�o do produto: ");
					pre�o = input.nextDouble();
					
					
					Produto produto02 = new Produto();
					produto02.setCodigo(codigo);
					produto02.setNome(nome);
					produto02.setPre�o(pre�o);
					produto02.setQuantidade(quantidade);
					produto02.setSubtotal(produto02.calcularSubtotal());
					produto02.setAlteracao(codigoAlterar);

					ProdutoDao produtoAlteracao = new ProdutoDao();
					produtoAlteracao.alterarPorCodigo(produto02);
					break;
					
				case 5:
					
					System.out.println("Excluir Produto");
					System.out.println("Digite o c�digo do produto que deseja excluir: ");
					
					codigo = input.nextInt();
					
					ProdutoDao produtosDao4 = new ProdutoDao();
					produtosDao4.excluirPorCodigo(codigo);
					
					break;
				case 6:
					System.out.println("Finalizar Sistema");
					break;
				default:
					System.out.println("Op��o Inv�lida");
			}
			
		}while(opcao!=6);
		input.close();
	}

}