<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
	<head>
		<link rel="stylesheet" 
				href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css"	
				integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm"
				crossorigin="anonymous">
		<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
		<title>Tarefa: Alterar</title>
	</head>
	<body>
	<main class="container">	
		<h3>Alterar tarefa - ${mostraTarefa.id }</h3>			
		
		<form action="alteraTarefa" method="POST">
		
		<table align="center" class="table table-sm">
			<tr>
			<td><input type="hidden" name="id" value="${mostraTarefa.id }"/></td>
			</tr>
			
			<tr>
			<td>Descricao:</td>
			<td><textarea rows="5" cols="100" name="descricao"> <%-- --%>${mostraTarefa.descricao }<%-- --%></textarea><br/></td>
			</tr>
			
			<tr>
			<td>Finalizado:</td>
			<td><input type="checkbox" name="finalizado" value="true" ${mostraTarefa.finalizado? 'checked' : '' }/></td>
			</tr>
			
			<tr>
			<td>Data de Finalizacao:</td>
			<td><input type="text" name="dataFinalizacao" value="<fmt:formatDate value="${mostraTarefa.dataFinalizacao.time }" pattern="dd/MM/yyyy"/>"/></td>
			</tr>
			
			<tr>
			<td><button>Alterar</button></td>
			</tr>
			
		</table>
		
		</form>
		
		
	</body>
</html>