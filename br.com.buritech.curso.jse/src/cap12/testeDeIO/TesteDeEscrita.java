package cap12.testeDeIO;

import java.io.BufferedWriter;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.io.OutputStreamWriter;

import javax.swing.JOptionPane;

public class TesteDeEscrita {

	public static void main(String[] args) throws IOException {
		OutputStream saida = new FileOutputStream("dados.txt", true);
		
		OutputStreamWriter writer = new OutputStreamWriter(saida);
		
		BufferedWriter buffer = new BufferedWriter(writer);
		
		String texto = JOptionPane.showInputDialog("Digite algo");
		
				
		//buffer.write(texto);
		buffer.newLine();
//		texto = JOptionPane.showInputDialog("Digite algo");
		buffer.append(texto);
	//	buffer.write(texto);
		
		buffer.close();
	}

}