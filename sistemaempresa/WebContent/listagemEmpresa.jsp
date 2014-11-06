<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<c:import url="cabecalho.jsp" />
<body>
	<h1>Listagem das Empresas Cadastradas</h1>
	<table border="2">
		<tr>
			<th>CNPJ</th>
			<th colspan="3">RAZÃO SOCIAL</th>
		</tr>
		<c:forEach var="empresa" items="${listaDeEmpresas}">
			<tr>
				<td>${empresa.cnpj}</td>
				<td>${empresa.razaoSocial}</td>
				<td><a href="controller?metodo=alterar&id=${empresa.id}">Alterar</a></td>
				<td><a href="controller??metodo=excluir&id=${empresa.id}">Excluir</a></td>
			</tr>
		</c:forEach>
	</table>
	<br>
	<button onclick="location.href='controller?metodo=cadastrar'">Cadastrar</button>
	&nbsp;&nbsp;&nbsp;
	<button onclick="history.go(-1)">Voltar</button>
</body>
<c:import url="rodape.jsp" />