<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
	<head>
		<link rel="stylesheet"
		href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css"
		integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm"
		crossorigin="anonymous">
		<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
		<title>Adicionar Tarefas</title>
	</head>
	<body>
		<main class="container">
		<h3>Adicionar Tarefas</h3>
		
		<form:errors path="tarefa.descricao"/>
		<form action="adicionaTarefa" method="POST">
		<table align="center" class="table table-sm">
			
			<tr>
			<td>Descricao: </td>
			<td><textarea rows="5" cols="100" name="descricao"></textarea></td>
			</tr>
			
			<tr>
			<td><button>Adicionar</button></td>
			</tr>
			
		</table>
		</form>
	</body>
</html>