package cap15;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {

	public static void main(String[] args) throws IOException,
			ClassNotFoundException {

		// String mensagem = "";

		Mensagem mensagem = null;
		Mensagem terminou = new Mensagem("CLIENTE", "TERMINATE");

		// Criando servidor
		ServerSocket server = new ServerSocket(12345);
		System.out.println("SERVER: abertura da porta 12345");

		// aguardando conexões
		Socket connection = server.accept();
		System.out.println("SERVER: Conectado - "
				+ connection.getInetAddress().getHostName());

		// Configuração de objetos de RW
		ObjectInputStream entrada = new ObjectInputStream(
				connection.getInputStream());
		
		

		// Processando conexão
		do {
			// Leitura do objeto
			// mensagem = (String) entrada.readObject();
			
			//String msg = (String) entrada.readObject();
			mensagem = (Mensagem) entrada.readObject();

			System.out.println(mensagem);
		} while (!mensagem.equals(terminou));

		// fechando as conexões
		entrada.close();
		server.close();

		System.out.println("SERVIDOR ENCERRADO");

	}

}
