<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib tagdir="/WEB-INF/tags" prefix="tagcustom" %>
<!DOCTYPE html>
<html>
	<head>
	<meta charset="UTF-8">
	<title>FJ21 - Adiciona Contato</title>
	
	<link href="css/jquery.css" rel="stylesheet">
	<script src="js/jquery.js"></script>
	<script src="js/jquery-ui.js"></script>

	</head>
	
	<body>
		<c:import url="cabecalho.jsp"></c:import>
		<h3>Adicione um contato:</h3>
		
		<form action="mvc?logica=AdicionaContatoLogica" method="POST">
		
		<table align="center">
		
			<tr>
			<td>Nome:</td> 
			<td><input type="text" name="nome" /> <br>
			</td>
			</tr>
			
			<tr>
			<td>Email:</td>
			<td><input type="email" name="email" /> <br>
			</td>
			</tr>
			
			<tr>
			<td>Endereco:</td>
			<td><input type="text" name="endereco" /> <br>
			</td>
			</tr>
			
			<tr>
			<td>Data Nascimento:</td>
			<%--<input type="text" name="dataNascimento" /> <br> --%>
			<td><tagcustom:campoData data="dataNascimento" /> <br>
			</td>
			</tr>
			
			<tr>
			<td>
			<button>Gravar</button>
			</td>
			</tr>
		</table>
		</form>
		<c:import url="rodape.jsp"></c:import>
	</body>
</html>