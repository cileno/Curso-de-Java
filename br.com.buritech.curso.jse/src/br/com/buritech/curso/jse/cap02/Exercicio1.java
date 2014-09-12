package br.com.buritech.curso.jse.cap02;

public class Exercicio1 {
	public static void main(String[] args) {
		int idade = 38;
		
		System.out.println("Idade atual: " + idade);
		
		//idade += 10;
		
		System.out.println("Idade futura: " + (idade += 10));
	}
}
