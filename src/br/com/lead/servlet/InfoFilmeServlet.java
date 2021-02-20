package br.com.lead.servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;

@WebServlet("/info-filme")
public class InfoFilmeServlet extends HttpServlet {

	private static final long serialVersionUID = 1L;
	
	@Override
	public void service(ServletRequest req, ServletResponse res) throws ServletException, IOException {
		String nome = req.getParameter("nome");
		String genero = req.getParameter("genero");
		Integer ano = Integer.valueOf(req.getParameter("ano"));
		
		
		
		req.setAttribute("nome", nome);
		req.setAttribute("genero", genero);
		req.setAttribute("ano", ano);
		
		RequestDispatcher dispatcher = req.getRequestDispatcher("/info-filme.jsp");
		dispatcher.forward(req, res);
	}
}
