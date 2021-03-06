package br.com.caelum.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.caelum.agenda.dao.ContatoDao;
import br.com.caelum.agenda.modelo.Contato;

@WebServlet("/adicionaContato")
public class AdicionaContatoServlet extends HttpServlet {
	
	
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		//Simular o erro de Pagina 500
		//System.out.println(1/0);
		
		// busca writer
		PrintWriter pw = resp.getWriter();
		try {
			
			// buscando os parametros no request
			String nome = req.getParameter("nome");
			String email = req.getParameter("email");
			String endereco = req.getParameter("endereco");
			String data = req.getParameter("dataNascimento");
			// Calendar dataNascimento = null;

			// fazendo conversao da data
			Date date = new SimpleDateFormat("dd/MM/yyyy").parse(data);
			Calendar calendar = Calendar.getInstance();
			calendar.setTime(date);

			// monta um objeto contato
			Contato contato = new Contato();
			contato.setNome(nome);
			contato.setEmail(email);
			contato.setEndereco(endereco);
			contato.setDataNascimento(calendar);

			// salva contato
			Connection connection = (Connection) req.getAttribute("conexao");
			ContatoDao dao = new ContatoDao(connection);
			dao.adiciona(contato);
			
			// Imprime
			req.getRequestDispatcher("/contato-adicionado.jsp").forward(req, resp);
			
			//pw.println("<html><body>" + contato.getNome() + " adicionado com sucesso!");
			//pw.println("</body></html>");

		} catch (ParseException e) {
			pw.println("Erro de conversao de data");
			return;// para a execucao do metodo
		}

	}

}
