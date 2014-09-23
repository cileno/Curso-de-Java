package cap12.testeDeIO;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

public class TesteDeLeitura {

	public static void main(String[] args) throws IOException {
		InputStream entrada = new FileInputStream("dados.txt");
		
		InputStreamReader reader = new InputStreamReader(entrada);
		
		BufferedReader buffer = new BufferedReader(reader);
		
		String txt = buffer.readLine();
		System.out.println(txt);
		
		while(txt != null){
			txt = buffer.readLine();
			System.out.println(txt);
		}
		
		buffer.close();

	}

}
