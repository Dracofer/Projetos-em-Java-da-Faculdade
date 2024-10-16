package br.com.turma.controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.turma.jdbc.Aluno;
import br.com.turma.jdbc.AlunoDao;

@WebServlet("/entrada")
public class EntradaServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
 
	protected void doGet(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
	
			
			String acao = request.getParameter("acao");
			
			if (acao.equals("mostrar")) {
				AlunoDao alunoDao = new AlunoDao();
				ArrayList<Aluno> alunos = alunoDao.mostrarTodos();
				
				request.setAttribute("alunos", alunos);
				RequestDispatcher rd = request.getRequestDispatcher("/telamostraralunos.jsp");
				rd.forward(request, response);
				
			}else if (acao.equals("incluir")) {
				
				RequestDispatcher rd = request.getRequestDispatcher("/telacadastraraluno.jsp");
				rd.forward(request, response);
				
			}else if (acao.equals("excluir")) {
				
				int codigo = Integer.parseInt(request.getParameter("codigo"));
				
				AlunoDao alunoDao = new AlunoDao();
				alunoDao.excluirPorCodigo(codigo);
				
				response.sendRedirect("http://localhost:8080/SistemaEscola2/entrada?acao=mostrar");
				
			}else if (acao.equals("alterar")) {
				
				int codigo = Integer.parseInt(request.getParameter("codigo"));
				
				AlunoDao alunoDao = new AlunoDao();
				Aluno aluno = alunoDao.mostrarPorCodigo(codigo);
				
				request.setAttribute("aluno", aluno);
				RequestDispatcher rd = request.getRequestDispatcher("/telaalteraraluno.jsp");
				rd.forward(request, response);
			}
		}
			
			
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String acao = request.getParameter("txtacao");
		
		String nome = request.getParameter("txtnome");
		double prim = Double.parseDouble(request.getParameter("txtprim"));
		double seg = Double.parseDouble(request.getParameter("txtseg"));
		double ter = Double.parseDouble(request.getParameter("txtter"));
		double qua = Double.parseDouble(request.getParameter("txtqua"));
		
		AlunoDao alunoDao = new AlunoDao();
		Aluno aluno = new Aluno(nome, prim, seg, ter, qua);
		
		if(acao.equals("cadastrar")) {
			alunoDao.cadastrar(aluno);
			response.sendRedirect("http://localhost:8080/SistemaEscola2/entrada?acao=mostrar");
		}else if(acao.equals("alterar")) {
			aluno.setCodigo(Integer.parseInt(request.getParameter("txtcodigo")));
			alunoDao.alterarPorCodigo(aluno);
			response.sendRedirect("http://localhost:8080/SistemaEscola2/entrada?acao=mostrar");			
		}
	}

}
