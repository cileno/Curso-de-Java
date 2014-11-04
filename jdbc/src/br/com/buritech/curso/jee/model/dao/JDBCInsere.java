package br.com.buritech.curso.jee.model.dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Calendar;

import br.com.buritech.curso.jee.model.connection.ConnectionFactory;

public class JDBCInsere {
	public static void main(String[] args) {
		
		System.out.println("INICIO do processo");
		
		//realizando conexão
		Connection connect = ConnectionFactory.getConnection();
		
		//definindo a sql para executar a inserção
		String sql = "Insert into empresa ("
				+ "cnpj, razaosocial, endereco, telefone, site, email, dtcriacao)"
				+ "values (?, ?, ?, ?, ?, ?, ?)";
		
		//Criando o objeto que irá executar a SQL
		try {
			PreparedStatement stmt = connect.prepareStatement(sql);
			
			//passando os parametros para a sql
			stmt.setString(1, "123456789");
			stmt.setString(2, "Buritech");
			stmt.setString(3, "Av. Danilo Areosa, Bloco E");
			stmt.setString(4, "8118-7682");
			stmt.setString(5, "www.buritech.com.br");
			stmt.setString(6,"atendimento@buritech.com.br");
			stmt.setDate(7, new Date(Calendar.getInstance().getTimeInMillis()));
			
			System.out.println("executando o insert.");
			
			//executa a SQL
			stmt.execute();
			
			System.out.println("Insert realizado com sucesso.");
			
			System.out.println("finalizando a conexão");
			//fecha conexão
			stmt.close();
			connect.close();
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		System.out.println("FIM do processo.");
	}
}
