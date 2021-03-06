<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@page import="java.util.List"%>
<%@page import="br.com.caelum.agenda.dao.ContatoDao"%>
<%@page import="br.com.caelum.agenda.modelo.Contato"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css"
	integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm"
	crossorigin="anonymous">
<main class="container">
<title>Lista Contatos</title>
</head>
<body>
	<%--<jsp:useBean id="dao" class="br.com.caelum.agenda.dao.ContatoDao" /> --%>
	<%--Esta comentando o codigo usando o '<%--' 
			<%//ContatoDao dao = new ContatoDao(); 
			List<Contato> contatos = dao.getLista();--%>

	<c:import url="cabecalho.jsp" />

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
			<c:forEach var="contato" items="${contatos}">
				<%--<%for(Contato contato : contatos){ --%>
				<tr>
					<td>${contato.id}</td>
					<td>${contato.nome}</td>

					<%--COMPARANDO SE TEM EMAIL COM CLAUSULA IF --%>
					<%-- 
					<td>
					<c:if test="${empty contato.email}">
					Email nao informado
					</c:if>
					<c:if test="${not empty contato.email}">
					<a href="mailto:${contato.email}">${contato.email}</a>
					</c:if>
					</td>--%>

					<%--COMPARANDO SE TEM EMAIL COM CLAUSULA CHOOSE --%>
					<td>
					<c:choose>
						<c:when test="${empty contato.email}">
							Email nao informado
						</c:when>
							<c:otherwise>
								<a href="mailto:${contato.email}">${contato.email}</a>
							</c:otherwise>
					</c:choose>
					</td>
					<td>${contato.endereco}</td>
					<td><fmt:formatDate value="${contato.dataNascimento.time}"
							pattern="dd/MM/yyyy" /></td>
							
					<td> <a href="mvc?logica=RemoveContatoLogica&id=${contato.id }">Remover</a>
					<td> <a href="mvc?logica=AlteraContatoLogica&id=${contato.id }">Alterar</a>
					</td>

					<%--<td><%=contato.getId()</td>
					<td><%=contato.getNome() %></td>
					<td><%=contato.getEmail() %></td>
					<td><%=contato.getEndereco() %></td>
					<td><%=contato.getDataNascimento().getTime()%></td>--%>
				</tr>
			</c:forEach>
		</tbody>
	</table>
	<c:import url="rodape.jsp" />
</body>
</html>