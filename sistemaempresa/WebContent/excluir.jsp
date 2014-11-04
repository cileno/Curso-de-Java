<%@page import="br.com.buritech.curso.jee.model.bean.Empresa"%>
<%@page import="br.com.buritech.curso.jee.model.dao.EmpresaDAO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Excluir Empresa</title>
</head>
<%
	String id = request.getParameter("id");
	EmpresaDAO dao = new EmpresaDAO();
	Empresa empresa = dao.searchCompany(new Long(id));
	dao.deleteCompany(empresa.getId());
%>
<body>
	<h1>Empresa Excluída: <br>
		<%=empresa.toString() %>
	</h1>
	<a href="index.html">Página Inicial</a>
	<a href="listagem.jsp">Página de Listagem</a>
</body>
</html>