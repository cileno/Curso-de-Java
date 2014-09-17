package br.com.buritech.curso.jse.cap12;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

public class EntradaDeDados {
	public static void main(String[] args) throws IOException {
		InputStream entrada = new FileInputStream("arq.txt");
		
		InputStreamReader reader = new InputStreamReader(entrada);
		
		BufferedReader buffer = new BufferedReader(reader);
		
		String texto = buffer.readLine();
		System.out.println(texto);
		
		while(texto != null){
			texto = buffer.readLine();
			System.out.println(texto);
		}
		
		buffer.close();
	}
}
