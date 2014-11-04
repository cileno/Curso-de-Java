package br.com.buritech.curso.jee.model.connection;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionFactory {
	public static Connection getConnection() {
		Connection connection = null;

		try {
			// definindo o Driver JDBC
			Class.forName("com.mysql.jdbc.Driver");

			// criando a conexão
			connection = DriverManager.getConnection(
					"jdbc:mysql://localhost/cursojee", "root", "Jwm33249");

		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}

		// retornando a conexão gerada
		return connection;
	}
}
