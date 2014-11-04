<%@page import="java.util.*"%>
<%@page import="java.text.SimpleDateFormat"%>
<%@page import="br.com.buritech.curso.jee.model.bean.Empresa"%>
<%@page import="br.com.buritech.curso.jee.model.dao.EmpresaDAO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Salvando os Dados da Empresa</title>
</head>
<%
	String operacao = "";

	EmpresaDAO dao = new EmpresaDAO();
	Empresa empresa = new Empresa();

	String id = request.getParameter("edId");

	empresa.setCnpj(request.getParameter("edCNPJ"));
	empresa.setRazaoSocial(request.getParameter("edRazaoSocial"));
	empresa.setEndereco(request.getParameter("edEndereco"));
	empresa.setTelefone(request.getParameter("edTelefone"));
	empresa.setSite(request.getParameter("edSite"));
	empresa.setEmail(request.getParameter("edEmail"));

	Date dtDataCriacao = new SimpleDateFormat("dd/MM/yyyy")
			.parse(request.getParameter("edDataCriacao"));
	empresa.setDataCriacao(Calendar.getInstance());
	empresa.getDataCriacao().setTime(dtDataCriacao);

	if (id == null) {
		dao.insertCompany(empresa);

		operacao = "Cadastro Realizado";
	} else {
		empresa.setId(new Long(id));

		dao.updateCompany(empresa);

		operacao = "Alteração Realizada";
	}
%>
<body>
	<h1><%=operacao%>
		com Sucesso
	</h1>
	<a href="index.html">Página Inicial</a>
	<br>
	<a href="listagem.jsp">Página de Listagem</a>
</body>
</html>