package br.com.buritech.curso.jse.cap04;


public class Carro {
	private String cor;
	private String modelo;
	private double velocidadeAtual;
	private double velocidadeMaxima;
	private Motor motor;
	
	public Carro(String cor, String modelo, double velocidadeMaxima) {
		this.cor = cor;
		this.modelo = modelo;
		this.velocidadeMaxima = velocidadeMaxima;
	}

	public String getCor() {
		return cor;
	}
	
	public void setCor(String cor) {
		this.cor = cor;
	}
	
	public String getModelo() {
		return modelo;
	}
	
	public void setModelo(String modelo) {
		this.modelo = modelo;
	}
	
	public double getVelocidadeAtual() {
		return velocidadeAtual;
	}
	
	public void setVelocidadeAtual(double velocidadeAtual) {
		this.velocidadeAtual = velocidadeAtual;
	}
	
	public double getVelocidadeMaxima() {
		return velocidadeMaxima;
	}
	
	public void setVelocidadeMaxima(double velocidadeMaxima) {
		this.velocidadeMaxima = velocidadeMaxima;
	}
	
	public Motor getMotor() {
		return motor;
	}
	
	public void setMotor(Motor motor) {
		this.motor = motor;
	}

	public void ligar(){
		System.out.println("O carro está ligado");
	}
	
	public void acelerar(double quantidade){
		this.velocidadeAtual += quantidade;
	}
	
	public void freiar(){
		System.out.println("O carro está freiando");
	}
}
