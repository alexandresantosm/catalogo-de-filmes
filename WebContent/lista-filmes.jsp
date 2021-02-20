<%@ page import="java.util.ArrayList" %>
<%@ page import="br.com.lead.modelo.Filme" %>

<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Lista de Filmes</title>
</head>
<body>
	<h2>Lista de Filmes</h2>
	
	<ol>
	
		<%
			ArrayList<Filme> listaDeFilmes = new ArrayList<>();
			
			listaDeFilmes = (ArrayList) request.getAttribute("listaFiltrada");
			
			for(Filme filme : listaDeFilmes) {
		%>
		
		<li>
			<%
				out.println(String.format("Nome: %s <br>", filme.getNome()));
				out.println(String.format("Gênero: %s <br>", filme.getGenero()));
				out.println(String.format("Ano: %s", filme.getAno()));
			%>
		</li>
		
		<%
			}
		%>
	
	</ol>
</body>
</html>