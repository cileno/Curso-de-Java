package br.com.buritech.curso.jse.cap02;

public class Exercicio2 {
	public static void main(String[] args) {
		int idade = 38;

		String faixa = (idade <= 12) ? "Criança"
				: ((idade > 12 && idade <= 17) ? "Adolescente" : "Adulto");
		
		System.out.println(faixa);
	}
}
