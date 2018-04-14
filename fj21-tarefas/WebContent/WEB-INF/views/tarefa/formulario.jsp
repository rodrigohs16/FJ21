<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
		<title>Adicionar Tarefas</title>
	</head>
	<body>
		<h3>Adicionar Tarefas</h3>
		
		<form:errors path="tarefa.descricao"/>
		<form action="adicionaTarefa" method="POST">
			Descricao: <br/>
			<textarea rows="5" cols="100" name="descricao"></textarea>
			
			<button>Adicionar</button>
		</form>
	</body>
</html>