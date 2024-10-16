package br.com.turma.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/cadastrarinfo")
public class MeuServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("Solicitação (Requisição) GET executada com sucesso!!!");
		System.out.println(request.getParameter("nome"));
		System.out.println(request.getParameter("sobrenome"));
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("Solicitação (Requisição) POST executada com sucesso!!!");
		System.out.println(request.getParameter("nome"));
		System.out.println(request.getParameter("sobrenome"));
	}

}
