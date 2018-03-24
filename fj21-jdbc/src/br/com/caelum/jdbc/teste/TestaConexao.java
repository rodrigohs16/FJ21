package br.com.caelum.jdbc.teste;

import java.sql.SQLException;
import java.util.Calendar;

import br.com.caelum.jdbc.dao.ContatoDAO;
import br.com.caelum.model.Contato;

public class TestaConexao {

	public static void main(String[] args) throws SQLException {
		//Connection connection = new ConnectionFactory().getConnection();
		//System.out.println("Conexao aberta");
		//connection.close();
		
		Contato contato = new Contato();
		contato.setNome("Rodrigo");
		contato.setEmail("rodrigohs16@gmail.com");
		contato.setEndereco("Rua Fernando Luz");
		
		Calendar calendario = Calendar.getInstance();
		calendario.set(1987, Calendar.MARCH, 11);
		contato.setDataNascimento(calendario);
		
		//grave nessa conexáo
		ContatoDAO contatoDao = new ContatoDAO();
		contatoDao.adiciona(contato);
		
		System.out.println("Gravado!");
		
		contatoDao.close();
		
		
		

	}

}
