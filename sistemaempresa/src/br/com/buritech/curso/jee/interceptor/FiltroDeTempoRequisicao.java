package br.com.buritech.curso.jee.interceptor;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;


@WebFilter("*.jsp")
public class FiltroDeTempoRequisicao implements Filter {

	@Override
	public void destroy() {
		System.out.println("Fim do filtro");
		
	}

	@Override
	public void doFilter(ServletRequest request, ServletResponse response,
			FilterChain chain) throws IOException, ServletException {
		//processamento antes da requisição
		long horaInicio = System.currentTimeMillis();
		
		//Execução da requisição do usuário
		chain.doFilter(request, response);
		
		//processamento após a requisição
		long horaFim = System.currentTimeMillis();
		
		System.out.println("URL: " + ((HttpServletRequest)request).getRequestURL());
		System.out.println("Tempo em milis: " + (horaFim - horaInicio));
	}

	@Override
	public void init(FilterConfig arg0) throws ServletException {
		System.out.println("Início do filtro");
		
	}

}
