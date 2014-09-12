package br.com.buritech.curso.jse.cap02;

public class NumerosPares {
	public static void main(String[] args) {
		int num = 0;
		
		while((++num) <= 15){
			if((num % 2) == 0)
				System.out.print(num + " ");
			//num++;
		}
	}
}
