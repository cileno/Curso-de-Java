package cap15;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {

	public static void main(String[] args) throws IOException,
			ClassNotFoundException {

		String msg = "abertura da porta 12345";
		String ass = "SERVER";

		Mensagem mensagem = new Mensagem(ass, msg);

		// Criando servidor
		ServerSocket server = new ServerSocket(12345);
		//System.out.println("SERVER: abertura da porta 12345");
		System.out.println(mensagem);

		// aguardando conexões
		Socket connection = server.accept();
		//System.out.println("SERVER: Conectado - " + connection.getInetAddress().getHostName());

		mensagem.setMesangem("Conectado - " + connection.getInetAddress().getHostName());
		System.out.println(mensagem);

		// Configuração de objetos de RW
		ObjectInputStream entrada = new ObjectInputStream(connection.getInputStream());
		
		ass = "CLIENTE";
		msg = "TERMINATE";
		Mensagem mensagemSaida = new Mensagem(ass, msg);		

		// Processando conexão
		do {
			// Leitura do objeto
			// mensagem = (String) entrada.readObject();
			
			mensagem = (Mensagem) entrada.readObject();

			System.out.println(mensagem);
		} while (!mensagem.getMesangem().equals(mensagemSaida.getMesangem()));

		// fechando as conexões
		entrada.close();
		server.close();
		
		mensagem.setAssunto("SERVER");
		mensagem.setMesangem("ENCERRADO");
		
		//System.out.println("SERVIDOR ENCERRADO");
		System.out.println(mensagem);
	}

}
