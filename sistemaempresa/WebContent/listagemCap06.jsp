<%@page import="java.util.List"%>
<%@page import="br.com.buritech.curso.jee.model.dao.EmpresaDAO"%>
<%@page import="br.com.buritech.curso.jee.model.bean.Empresa"%>
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
		
		<%
			EmpresaDAO dao = new EmpresaDAO();
			List<Empresa> empresasList = dao.listAllCompany();
			for (Empresa empresa : empresasList) {
		%>
		<tr>
			<td><%=empresa.getCnpj()%></td>
			<td><%=empresa.getRazaoSocial()%></td>
			<td><a href="dados.jsp?id=<%=empresa.getId()%>">Alterar</a></td>
			<td><a href="excluir.jsp?id=<%=empresa.getId()%>">Excluir</a></td>
		</tr>
		<%
			}
		%>
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
	<!-- <button onclick="dados.jsp">Cadastrar</button>&nbsp;&nbsp;&nbsp;
	<button onclick="history.go(-1)">Voltar</button> -->
</body>
</html>