<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Sobre o filme</title>
</head>
<body>
	<h2>Informações do Filme</h2>
	
	<%
		String nome = request.getParameter("nome");
		String genero = request.getParameter("genero");
		Integer ano = Integer.valueOf(request.getParameter("ano"));
		
		out.println(String.format("Nome: %s <br>", nome));
		out.println(String.format("Gênero: %s <br>", genero));
		out.println(String.format("Ano: %s", ano));
	%>
</body>
</html>