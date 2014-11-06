<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<c:import url="cabecalho.jsp" />
<body>
	<h1>
		<c:choose>
			<c:when test="${empresa.id==null}">Cadastrar Empresas</c:when>
			<c:otherwise>Alterar Dados da Empresa</c:otherwise>
		</c:choose>
	</h1>
	<form action="controller?metodo=salvar" method="post">
		<table>
			<c:if test="${empresa.id!=null}">
				<tr>
					<td>ID:</td>
					<td><input type="text" name="edId" value="${empresa.id}"
						readonly="readonly" /></td>
				</tr>
			</c:if>
			<tr>
				<td>CNPJ:</td>
				<td><input type="text" name="edCNPJ" value="${empresa.cnpj}" /></td>
			</tr>
			<tr>
				<td>RAZÃO SOCIAL:</td>
				<td><input type="text" name="edRazaoSocial"
					value="${empresa.razaoSocial}" /></td>
			</tr>
			<tr>
				<td>ENDEREÇO:</td>
				<td><input type="text" name="edEndeco"
					value="${empresa.endereco}" /></td>
			</tr>
			<tr>
				<td>TELEFONE:</td>
				<td><input type="text" name="edTelefone"
					value="${empresa.telefone}" /></td>
			</tr>
			<tr>
				<td>SITE:</td>
				<td><input type="text" name="edSite" value="${empresa.site}" /></td>
			</tr>
			<tr>
				<td>EMAIL:</td>
				<td><input type="text" name="edEmail" value="${empresa.email}" /></td>
			</tr>
			<tr>
				<td>Data de Criação:</td>
				<td><input type="text" name="edData"
					value="<fmt:formatDate value="${empresa.dataCriacao.time}" pattern="dd/MM/yyyy"/>"/>
				</td>
			</tr>
		</table>
	</form>


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