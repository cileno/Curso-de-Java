package br.com.buritech.curso.jee.view;

import java.sql.Connection;
import java.sql.SQLException;

import br.com.buritech.curso.jee.model.connection.ConnectionFactory;

public class TesteJDBC {

	public static void main(String[] args) {
		System.out.println("INÍCIO do processamento");
		
		Connection connect = ConnectionFactory.getConnection();
		System.out.println("Conexão realizada com sucesso");
		
		//fechando a conexão
		try {
			connect.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		System.out.println("FIM do processamento.");

	}

}
