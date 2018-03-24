package br.com.caelum.jdbc.teste;

import java.util.List;

import br.com.caelum.jdbc.dao.ContatoDAO;
import br.com.caelum.model.Contato;

public class TestaLista {

	public static void main(String[] args) {
		ContatoDAO dao = new ContatoDAO();

		List<Contato> contatos = dao.getList();

		// criado metodo de Ïmprime Contato"na classe ContatoDAO.
		dao.ImprimeContato(contatos);

	}

}
