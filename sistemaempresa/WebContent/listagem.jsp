<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Listagem de Empresas</title>
</head>
<body>
	<table border="2">
		<tr>
			<th>CNPJ</th>
			<th colspan="3">RAZÃO SOCIAL</th>
		</tr>
		<!-- cria a lista -->
		<jsp:useBean id="dao"
			class="br.com.buritech.curso.jee.model.dao.EmpresaDAO" />
		<c:forEach var="empresa" items="${dao.listAllCompany()}">
			<tr>
				<td>${empresa.cnpj}</td>
				<td>${empresa.razaoSocial}</td>
				<td><a href="dados.jsp?id=${empresa.id}">Alterar</a></td>
				<td><a href="excluir.jsp?id=${empresa.id}">Excluir</a></td>
			</tr>
	</c:forEach>
	</table>
	<br>
	<form action="dados.jsp" method="post">
		<table>
			<tr>
				<td><input type="submit" value="Cadastrar" /></td>
				<td><input type="button" value="Voltar"
					onclick="history.go(-1)" /></td>
			</tr>
		</table>
	</form>
</body>
</html>