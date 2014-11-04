package br.com.buritech.curso.jee.view;

import java.io.IOException;
import java.io.PrintWriter;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.buritech.curso.jee.model.bean.Empresa;
import br.com.buritech.curso.jee.model.dao.EmpresaDAO;

/**
 * Servlet implementation class AdicionarEmpresaServlet
 */
@WebServlet("/adicionarEmpresa")
public class AdicionarEmpresaServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#service(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void service(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		PrintWriter out = response.getWriter();
		
		//Alimentando um objeto empresa
		Empresa empresa = new Empresa();
		empresa.setCnpj(request.getParameter("cnpj"));
		empresa.setRazaoSocial(request.getParameter("razaoSocial"));
		empresa.setEndereco(request.getParameter("endereco"));
		empresa.setTelefone(request.getParameter("telefone"));
		empresa.setSite(request.getParameter("site"));
		empresa.setEmail(request.getParameter("email"));
		
		String strDataCriacao = request.getParameter("dataCriacao");
		try {
			Date dtCriacao = new SimpleDateFormat("dd/MM/yyyy").parse(strDataCriacao);
			
			empresa.setDataCriacao(Calendar.getInstance());
			empresa.getDataCriacao().setTime(dtCriacao);
			
		} catch (ParseException e) {
			System.out.println("Erro de conversão de data");
			return;
		}
		
		//salvando os dados da empresa no banco
		EmpresaDAO dao = new EmpresaDAO();
		dao.insertCompany(empresa);
		
		//Imprimindo mensagem de sucesso no cadastro
		out.println("<html>");
		out.println("<body>");
		out.println("Empresa <h1>" + empresa.toString()
				+"</h1> adicionada com sucesso");
		out.println("<form action =\"cadastro.html\">");
		out.println("<input type=\"submit\" value=\"Voltar\"/>");
		out.println("</form>");
		out.println("</body>");
		out.println("</html>");
	}

}
