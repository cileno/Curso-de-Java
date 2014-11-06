package br.com.buritech.curso.jee.control;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.buritech.curso.jee.model.bean.Empresa;
import br.com.buritech.curso.jee.model.dao.EmpresaDAO;

//Lista de operações possíveis, usando enum
enum Metodo{CADASTRAR, ALTERAR, EXCLUIR, SALVAR, LISTAR};
/**
 * Servlet implementation class ServletController
 */
@WebServlet("/controller")
public class ServletController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	//Objeto que invocará os serviços da camada modelo
	private EmpresaDAO dao = new EmpresaDAO();
	
	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		//receberá a página a ser acessada
		String pagina = "";
		
		//Método invocado pela camada view
		String metodoSTR = request.getParameter("metodo");
		Metodo metodoEnum = Metodo.valueOf(metodoSTR.toUpperCase());
		
		//conforme a chamada da view, escolhe o procedimento a ser realizado
		switch (metodoEnum) {
//		case CADASTRAR:
//			pagina = cadastrar(request);
//			break;
//		case ALTERAR:
//			pagina = alterae(request);
//			break;
//		case EXCLUIR:
//			pagina = excluir(request);
//			break;
//		case SALVAR:
//			pagina = salvar(request);
//			break;
		case LISTAR:
			pagina = listar(request);
			break;
		}
		
		//definindo o objeto de redirecionamento
		RequestDispatcher dispatcher = request.getRequestDispatcher("/"+pagina);
		//redirecionando para a pr'oxima página
		dispatcher.forward(request, response);
	}

	private String listar(HttpServletRequest request) {
		List<Empresa> businessListing = dao.listAllCompany();
		request.setAttribute("listaDeEmpresas", businessListing);
		return "listagemEmpresa.jsp";
	}
}
