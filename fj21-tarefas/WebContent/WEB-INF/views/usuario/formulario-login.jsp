<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
	<head>
		<link rel="stylesheet"
		href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css"
		integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm"
		crossorigin="anonymous">
		<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
		<title>Login -- Tarefas</title>
	</head>
	<body>
	<main class="container">
		<h2>Pagina de Login de Tarefas</h2>
		
		<form action="efetuaLogin" method="POST">
		<p>${param.error }</p>
		
			<table align="center" class="table table-sm">
				<tr>
				<td>Login:</td>
				<td> <input type="text" name="login"> </td>
				</tr>
				
				<tr>
				<td>Senha:</td>
				<td> <input type="password" name="senha"></td>
				</tr>
				
				<tr>
				<td><button>Entrar</button></td>
				</tr>
				
			</table>
		
		</form>
	</body>
</html>