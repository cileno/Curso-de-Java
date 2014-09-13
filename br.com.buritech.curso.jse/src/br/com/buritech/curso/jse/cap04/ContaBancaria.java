package br.com.buritech.curso.jse.cap04;

public class ContaBancaria {
	private String numeroConta;
	private String nomeCliente;
	private double saldo;
	private double limite;
	
	public ContaBancaria(double saldo) {
		this.saldo = saldo;
	}
	
	public String getNumeroConta() {
		return numeroConta;
	}
	
	public void setNumeroConta(String numeroConta) {
		this.numeroConta = numeroConta;
	}
	
	public String getNomeCliente() {
		return nomeCliente;
	}
	
	public void setNomeCliente(String nomeCliente) {
		this.nomeCliente = nomeCliente;
	}
	
	public double getLimite() {
		return limite;
	}
	
	public void setLimite(double limite) {
		this.limite = limite;
	}

	public double getSaldo() {
		return saldo;
	}
	
	public void sacar(double valorDeSaque){
		if(this.saldo >= valorDeSaque)
			this.saldo -= valorDeSaque;
	}
	
	public void depositar(double valorDeDeposito){
		if(valorDeDeposito > 0)
			this.saldo += valorDeDeposito;
	}
}
