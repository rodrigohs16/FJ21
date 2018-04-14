package br.com.caelum.mvc.logica;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class FormContatoLogica implements Logica{
	public String executa(HttpServletRequest req, HttpServletResponse resp) throws Exception{
		
		return "adiciona-contato.jsp";
	}

}
