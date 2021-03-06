package br.com.caelum.agenda.filtro;

import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.annotation.WebServlet;

import br.com.caelum.agenda.ConnectionFactory;

@WebFilter("/*")
public class FiltroConexao implements Filter{

	@Override
	public void destroy() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void doFilter(ServletRequest servletreq, ServletResponse servletresp, FilterChain filterchain)
			throws IOException, ServletException {
		
		try {
			Connection connection = new ConnectionFactory().getConnection();
			
			servletreq.setAttribute("conexao", connection);
			
			filterchain.doFilter(servletreq, servletresp);
			
			connection.close();
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			throw new ServletException(e);
		}
		
	}

	@Override
	public void init(FilterConfig arg0) throws ServletException {
		// TODO Auto-generated method stub
		
	}
	
}
