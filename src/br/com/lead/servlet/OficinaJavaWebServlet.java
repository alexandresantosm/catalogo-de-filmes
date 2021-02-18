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

@WebServlet("/oficina-filme")
public class OficinaJavaWebServlet extends HttpServlet {
	
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
		
		try {
			Integer ano = Integer.valueOf(req.getParameter("ano"));
			
			out.println("<h2>Lista de filmes, utilizando Servlet</h2>");
			
			out.println("<ol>");
			
			filmes
				.stream()
					.filter(filme -> filme.getAno() >= ano)
						.forEach(filme -> {
						out.println(String.format("<li>Nome: %s <br>", filme.getNome()));
						out.println(String.format("Gênero: %s <br>", filme.getGenero()));
						out.println(String.format("Ano: %s </li>", filme.getAno()));
			});
			
			out.println("<ol>");
		} catch (Exception e) {
			
			out.println("Parâmetro inválido!");
		}
		
		out.close();
	}
}
