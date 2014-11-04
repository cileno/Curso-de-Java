<%@page import="br.com.buritech.curso.jee.model.bean.Empresa"%>
<%@page import="br.com.buritech.curso.jee.model.dao.EmpresaDAO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Dados da Empresa</title>
</head>
<%
	String id = request.getParameter("id");
	EmpresaDAO dao = null;
	Empresa empresa = null;

	if (id != null) {
		dao = new EmpresaDAO();
		empresa = dao.searchCompany(Long.parseLong(id));
	} else {
		empresa = new Empresa();
	}
%>
<body>
	<h1>
		<%
			if (id == null) {
		%>
		Cadastrar Empresas
		<%
			} else {
		%>
		Alterar Dados da Empresa
		<%
			}
		%>
	</h1>

	<form action="salvardados.jsp" method="post">
		<table>
			<%
				if (empresa.getId() != null) {
			%>
			<tr>
				<td>ID:</td>
				<td><input type="text" name="edId" value="<%=empresa.getId()%>" /></td>
			</tr>
			<%
				}
			%>
			<tr>
				<td>CNPJ:</td>
				<td><input type="text" name="edCNPJ"
					value="<%=empresa.getCnpj()%>" /></td>
			</tr>
			<tr>
				<td>RAZÃO SOCIAL:</td>
				<td><input type="text" name="edRazaoSocial"
					value="<%=empresa.getRazaoSocial()%>" /></td>
			</tr>
			<tr>
				<td>ENDEREÇO:</td>
				<td><input type="text" name="edEndereco"
					value="<%=empresa.getEndereco()%>" /></td>
			</tr>
			<tr>
				<td>TELEFONE:</td>
				<td><input type="text" name="edTelefone"
					value="<%=empresa.getTelefone()%>" /></td>
			</tr>
			<tr>
				<td>SITE:</td>
				<td><input type="text" name="edSite"
					value="<%=empresa.getSite()%>" /></td>
			</tr>
			<tr>
				<td>EMAIL:</td>
				<td><input type="text" name="edEmail"
					value="<%=empresa.getEmail()%>" /></td>
			</tr>
			<tr>
				<td>Data de Criação:</td>
				<td><input type="text" name="edDataCriacao"
					value="<%=empresa.getDataCriacao()%>" /></td>
			</tr>
			<tr>
				<td><input type="submit" value="Enviar Dados" /></td>
				<td><input type="button" value="Cancelar"
					onclick="history.go(-1)" /></td>
			</tr>
		</table>
	</form>
</body>
</html>