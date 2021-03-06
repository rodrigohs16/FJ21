package br.com.caelum.mvc.logica;

import java.sql.Connection;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.caelum.agenda.dao.ContatoDao;
import br.com.caelum.agenda.modelo.Contato;

public class AdicionaContatoLogica implements Logica {
	public String executa(HttpServletRequest req, HttpServletResponse resp)throws Exception{
					
		Contato contato = new Contato();
		
		//contato.setId(Long.parseLong(req.getParameter("id")));
		contato.setNome(req.getParameter("nome"));
		contato.setEmail(req.getParameter("email"));
		contato.setEndereco(req.getParameter("endereco"));
		
		Date data = new Date();
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		Calendar dataNascimento = Calendar.getInstance();
		data = sdf.parse(req.getParameter("dataNascimento"));
		dataNascimento.setTime(data);
		
		contato.setDataNascimento(dataNascimento);
		
		Connection connection = (Connection) req.getAttribute("conexao");
		ContatoDao dao = new ContatoDao(connection);
		
		dao.adiciona(contato);
		
		
		return "/WEB-INF/contato-adicionado.jsp";
		
	}

}
