package br.com.caelum.jdbc.dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import br.com.caelum.jdbc.ConnectionFactory;
import br.com.caelum.model.Contato;

public class ContatoDAO {

	private Connection connection;

	public ContatoDAO() {
		this.connection = new ConnectionFactory().getConnection();
	}

	public void adiciona(Contato contato) {
		String sql = "insert into contatos " + "(nome,email,endereco,dataNascimento)" + " values (?,?,?,?)";

		try {
			PreparedStatement stmt = connection.prepareStatement(sql);
			stmt.setString(1, contato.getNome());
			stmt.setString(2, contato.getEmail());
			stmt.setString(3, contato.getEndereco());
			stmt.setDate(4, new Date(contato.getDataNascimento().getTimeInMillis()));

			stmt.execute();
			stmt.close();

		} catch (SQLException e) {
			throw new RuntimeException();
		}		

	}
	
	public void close(){
		try {
			this.connection.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public List<Contato> getList(){
		//criando a lista de contatos
		List<Contato> contatos = new ArrayList<Contato>();
		
		try {
			PreparedStatement stmt = this.connection.prepareStatement("select * from contatos");
			ResultSet resultrest /*ou rs*/ = stmt.executeQuery();
			
			while(resultrest.next()){
				//criando objeto contato
				Contato contato = new Contato();
				contato.setId(resultrest.getLong("id"));
				contato.setNome(resultrest.getString("nome"));
				contato.setEmail(resultrest.getString("email"));
				contato.setEndereco(resultrest.getString("endereco"));
				
				//montando a data atraves do Calendar
				Calendar data = Calendar.getInstance();
				data.setTime(resultrest.getDate("dataNascimento"));
				contato.setDataNascimento(data);
				
				//adicionando o objeto a lista
				contatos.add(contato);				
			}
			resultrest.close();
			stmt.close();
			return contatos;
						
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}
	
	public void ImprimeContato(List<Contato> contatos){
		for (Contato contato : contatos){
			System.out.println("Nome: " + contato.getNome());
			System.out.println("Email: " + contato.getEmail());
			System.out.println("Endereco: " + contato.getEndereco());
			System.out.println("Data Nascimento: " + contato.getDataNascimento().getTime());
			System.out.println("========================================");
		}
	}
}
