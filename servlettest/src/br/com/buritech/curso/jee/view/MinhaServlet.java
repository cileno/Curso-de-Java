package br.com.buritech.curso.jee.view;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class MinhaServlet
 */
@WebServlet("/Teste")  //mapeamento da classe servlet
public class MinhaServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#service(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//recupera o objeto que escreve a resposta
		PrintWriter out = response.getWriter();
		
		//Código html
		out.println("<html>");
		out.println("<body");
		out.println("<h1>Minha primeira Servlet</h1>");
		out.println("</body");
		out.println("</html>");
	}

}
