package cap12;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;

import br.com.buritech.curso.jse.utils.ShowIO;

public class Tabuada {
	public static void main(String[] args) throws IOException{		
		//obtendo a saída em bytes
		OutputStream saida = new FileOutputStream("tabuada.txt",true);
		
		//convertendo de bytes para caracteres
		OutputStreamWriter writer = new OutputStreamWriter(saida);
		
		//convertendo de caracter para String
		//BufferedWriter buffer = new BufferedWriter(escrever);
		PrintWriter escrever = new PrintWriter(writer);
		
		//lendo um número para calcular a tabuada equivalente
		int num = ShowIO.strToInt("Informe um número para a tabuada");

		escrever.printf("+--Resultado--+%n");
		for(int x = 1; x <= 10; x++){
			escrever.printf("| %2d X %d = %2d |%n", x, num, (x * num));
		}
		escrever.printf("+-------------+%n");
		
		//fechando o arquivo
		escrever.close();
		
		//Mostrando o resultado
		InputStream entrada = new FileInputStream("tabuada.txt");
		InputStreamReader reader = new InputStreamReader(entrada);
		BufferedReader leitura = new BufferedReader(reader);
		String resultado = leitura.readLine();
		System.out.println(resultado);
		while(resultado != null){
			resultado = leitura.readLine();
			System.out.println(resultado);
		}
		leitura.close();
		//ShowIO.showMensage(resultado);
	}
}
