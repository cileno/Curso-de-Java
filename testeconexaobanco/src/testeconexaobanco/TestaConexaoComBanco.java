package testeconexaobanco;


import java.sql.Connection;
import java.sql.SQLException;


public class TestaConexaoComBanco {

	public static void main(String[] args) {
		Connection conn = ConnectionFactory.getConnection();
		
		System.out.println("Conexão realizada");
		
		try {
			conn.close();
		} catch (SQLException e) {
			
			e.printStackTrace();
		}

	}

}
