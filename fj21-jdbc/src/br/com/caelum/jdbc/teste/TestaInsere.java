package br.com.caelum.jdbc.teste;

import java.util.Calendar;

import br.com.caelum.jdbc.dao.ContatoDAO;
import br.com.caelum.model.Contato;

public class TestaInsere {

	public static void main(String[] args) {
		Contato contato = new Contato();
		contato.setNome("Leriane");
		contato.setEmail("leriane@leriane.com.br");
		contato.setEndereco("Rua Fernando Luz");
		
		Calendar calendario = Calendar.getInstance();
		calendario.set(1989, Calendar.MAY, 27);
		contato.setDataNascimento(calendario);
		
		//grave nessa conexáo
		ContatoDAO contatoDao = new ContatoDAO();
		contatoDao.adiciona(contato);
		
		System.out.println("Gravado!");
		
		contatoDao.close();

	}

}
