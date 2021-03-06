package br.com.caelum.mvc.logica;


import java.sql.Connection;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.sun.org.apache.bcel.internal.generic.DALOAD;

import br.com.caelum.agenda.dao.ContatoDao;
import br.com.caelum.agenda.modelo.Contato;

public class AlteraContatoLogica implements Logica{
	public String executa(HttpServletRequest req, HttpServletResponse resp) throws Exception{
		
		long id= Long.parseLong(req.getParameter("id"));
		
		Connection connection = (Connection) req.getAttribute("conexao");
		ContatoDao dao = new ContatoDao(connection);
		
		 Contato contato = new Contato();
		 contato.setId(id);
		 contato.setNome(req.getParameter("nome"));
		 contato.setEmail(req.getParameter("email"));
		 contato.setEndereco(req.getParameter("endereco"));
		 
		 Date data = new Date();
		 SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		 Calendar dataNascimento = Calendar.getInstance();
		 data = sdf.parse(req.getParameter("dataNascimento"));
		 dataNascimento.setTime(data);
		 contato.setDataNascimento(dataNascimento);
			
			if(contato.getId() == null){
				dao.adiciona(contato);
			}else{
				dao.atualiza(contato);
			}
		 
		 
		 //System.out.println("Alterando contato");
		 
		 return "mvc?logica=ListaContatoLogica";
	}

}
