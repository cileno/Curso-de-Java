package cap15;

import java.io.IOException;
import java.io.ObjectOutputStream;
import java.net.Socket;

import javax.swing.JOptionPane;

public class Client {
	public static void main(String[] args) throws IOException{
		//String mensagem = "";
		String msg = "Conectado à porta 12345";
		String ass = "CLIENTE";
		Mensagem mensagem = new Mensagem(ass, msg);
		
		//Criando conexão
		Socket connection = new Socket("127.0.0.1", 12345);
		//System.out.println("CLIENTE: Conectado à porta 12345");
		System.out.println(mensagem);
		
		//Configuração do objeto de envio de mensagem
		ObjectOutputStream saida = new ObjectOutputStream(connection.getOutputStream());
		
		//envio de mesangem
		
		Mensagem msgSaida = new Mensagem(ass, "TERMINATE");
		do{
			//mensagem = "CLIENTE: " + JOptionPane.showInputDialog("Mensagem");
			mensagem = new Mensagem(ass, JOptionPane.showInputDialog("Mensagem"));
			
			//Escrita do objeto String
			saida.writeObject(mensagem);
			saida.flush();
		} while(!mensagem.getMesangem().equals(msgSaida.getMesangem()));
		
		//Ecerrando conexão
		saida.close();
		connection.close();
		
		mensagem.setMesangem("ENCERRADO");
		
		System.out.println(mensagem);
	}
}
