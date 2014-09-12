package br.com.buritech.curso.jse.cap02;

public class Exercicio3_Gastos {
	public static void main(String[] args) {
		double gastosDeJaneiro = 15000;
		double gastosDeFevereiro = 23000;
		double gastosDeMarco = 17000;
		
		double totalGastosTrimestre = gastosDeJaneiro + gastosDeFevereiro + gastosDeMarco;
				
		System.out.println("Gastos de Janeiro:   " + gastosDeJaneiro);
		System.out.println("Gastos de Fevereiro: " + gastosDeFevereiro);
		System.out.println("Gastos de Março:     " + gastosDeMarco);
		System.out.println("Gastos no Trimestre: " + totalGastosTrimestre);
	}
}
