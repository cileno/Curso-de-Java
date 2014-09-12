package br.com.buritech.curso.jse.cap02;

public class FatorialDeAteDez {
	public static void main(String[] args) {
		int fat = 1;
		int num = 0;
		
		while(num <= 10){
			System.out.println("O fatoria de " + fat + " é "
					+ "(" + num + "!) * " + ++num);
		}
	}
}
