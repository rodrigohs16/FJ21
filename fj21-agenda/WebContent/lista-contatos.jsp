<%@page import="java.util.List"%>
<%@page import="br.com.caelum.agenda.dao.ContatoDao"%>
<%@page import="br.com.caelum.agenda.modelo.Contato"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
		<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css" integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm" crossorigin="anonymous">
		<main class="container">
		<title>Lista Contatos</title>
		</head>
		<body>
			<%ContatoDao dao = new ContatoDao(); 
			List<Contato> contatos = dao.getLista();%>
		<table class="table">
			<thead>
				<tr>
					<th>Id</th>
					<th>Nome</th>
					<th>Email</th>
					<th>Endereco</th>
					<th>Data de Nascimento</th>
				</tr>
			<tbody>
				<%for(Contato contato : contatos){ %>
				<tr>
					<td><%=contato.getId() %></td>
					<td><%=contato.getNome() %></td>
					<td><%=contato.getEmail() %></td>
					<td><%=contato.getEndereco() %></td>
					<td><%=contato.getDataNascimento().getTime()%></td>
				</tr>
				<%} %>	
					
			</tbody>
		</table>
	</body>
</html>