package cap15;

import java.io.IOException;
import java.io.ObjectOutputStream;
import java.net.Socket;

import javax.swing.JOptionPane;

public class Client {
	public static void main(String[] args) throws IOException{
		//Criando conexão
		Socket connection = new Socket("127.0.0.1", 12345);
		System.out.println("CLIENTE: Conectado à porta 12345");
		
		//Configuração do objeto de envio de mensagem
		ObjectOutputStream saida = new ObjectOutputStream(connection.getOutputStream());
		
		//envio de mesangem
		//String mensagem = "";
		Mensagem mensagem = null;
		
		Mensagem terminou = new Mensagem("CLIENTE", "TERMINATE");
		do{
			//mensagem = "CLIENTE: " + JOptionPane.showInputDialog("Mensagem");
			mensagem = new Mensagem("CLIENTE", JOptionPane.showInputDialog("Mensagem"));
			
			//Escrita do objeto String
			saida.writeObject(mensagem);
			saida.flush();
		} while(!mensagem.equals(terminou));
		
		//Ecerrando conexão
		saida.close();
		connection.close();
		
		System.out.println("CLIENTE ENCERRADO");
	}
}
