package br.com.lead.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;

import br.com.lead.modelo.Filme;

@WebServlet("/persistir-filme")
public class PersisteFilmeSevlet extends HttpServlet {

	private static final long serialVersionUID = 1L;

	@Override
	public void service(ServletRequest req, ServletResponse res) throws ServletException, IOException {
		String nome = req.getParameter("nome");
		String genero = req.getParameter("genero");
		Integer ano = Integer.valueOf(req.getParameter("ano"));
		
		Filme filme = new Filme(nome, genero, ano);
		
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("catalogodefilmes");
		EntityManager em = emf.createEntityManager();
		
		em.getTransaction().begin();
		em.persist(filme);
		em.getTransaction().commit();
		
		em.close();
		emf.close();
		
		PrintWriter out = res.getWriter();
		out.println("Filme cadastrado com sucesso!");
	}
}
