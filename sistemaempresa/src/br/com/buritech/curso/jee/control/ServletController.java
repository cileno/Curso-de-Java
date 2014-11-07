package br.com.buritech.curso.jee.control;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
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
		case CADASTRAR:
			pagina = cadastrar(request);
			break;
		case ALTERAR:
			pagina = alterar(request);
			break;
		case EXCLUIR:
			pagina = excluir(request);
			break;
		case SALVAR:
			pagina = salvar(request);
			break;
		case LISTAR:
			pagina = listar(request);
			break;
		}
		
		//definindo o objeto de redirecionamento
		RequestDispatcher dispatcher = request.getRequestDispatcher("/"+pagina);
		//redirecionando para a pr'oxima página
		dispatcher.forward(request, response);
	}

	private String cadastrar(HttpServletRequest request) {
		request.setAttribute("empresa", new Empresa());
		return "dadosEmpresa.jsp";
	}

	private String alterar(HttpServletRequest request) {
		String id = request.getParameter("id");
		Empresa empresa = dao.searchCompany(new Long(id));
		request.setAttribute("empresa", empresa);
		return "dadosEmpresa.jsp";
	}

	private String excluir(HttpServletRequest request) {
		String id = request.getParameter("id");
		dao.deleteCompany(new Long(id));
		return "mensagem.jsp";
	}

	private String salvar(HttpServletRequest request) {
		Empresa empresa = new Empresa();
		
		String id = request.getParameter("edId");
		
		empresa.setCnpj(request.getParameter("edCNPJ"));
		empresa.setRazaoSocial(request.getParameter("edRazaoSocial"));
		empresa.setEndereco(request.getParameter("edEndereco"));
		empresa.setTelefone(request.getParameter("edTelefone"));
		empresa.setSite(request.getParameter("edSite"));
		empresa.setEmail(request.getParameter("edEmail"));
		
		String strDataCriacao = request.getParameter("edData");
		
		try {
			Date dtDataCriacao = new SimpleDateFormat("dd/MM/yyyy").parse(strDataCriacao);
			empresa.setDataCriacao(Calendar.getInstance());
			empresa.getDataCriacao().setTime(dtDataCriacao);
		} catch (ParseException e) {
			e.printStackTrace();
		}
		
		if(id == null || id.equals("")){
			dao.insertCompany(empresa);
		} else {
			empresa.setId(new Long(id));
			dao.updateCompany(empresa);
		}
		
		return "mensagem.jsp";
	}

	private String listar(HttpServletRequest request) {
		List<Empresa> businessListing = dao.listAllCompany();
		request.setAttribute("listaDeEmpresas", businessListing);
		return "listagemEmpresa.jsp";
	}
}
