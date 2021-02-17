package br.com.lead.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Arrays;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.lead.modelo.Filme;

@WebServlet("/filme")
public class FilmeServlet extends HttpServlet {

	private static final long serialVersionUID = 1L;
	
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		Filme coringa = new Filme("Coringa", "Drama", 2019);
		Filme matrix = new Filme("Matrix", "Ação", 1999);
		Filme forrestGump = new Filme("Forrest Gump", "Drama", 1994);
		
		ArrayList<Filme> filmes = new ArrayList<>();
		
		filmes.addAll(Arrays.asList(coringa, matrix, forrestGump));
		
		res.setContentType("text/HTML");
		
		PrintWriter out = res.getWriter();
		
		out.println("<h2>Lista de filmes, utilizando Servlet</h2>");
		
		out.println("<ol>");
		
		filmes.forEach(filme -> {
			out.println(String.format("<li>Nome: %s <br>", filme.getNome()));
			out.println(String.format("Gênero: %s <br>", filme.getNome()));
			out.println(String.format("Ano: %s </li>", filme.getNome()));
		});
		
		out.println("<ol>");
		
		out.close();
	}

}
