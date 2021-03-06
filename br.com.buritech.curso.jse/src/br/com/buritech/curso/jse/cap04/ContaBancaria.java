package br.com.buritech.curso.jse.cap04;

public class ContaBancaria {
	private String numeroConta;
	private String nomeCliente;
	private double saldo;
	private double limite;

	public ContaBancaria() {

	}

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

	public boolean sacar(double valor) {
		if (this.saldo >= valor) {
			this.saldo -= valor;
			return true;
		}

		return false;
	}

	public void depositar(double valor) {
		if (valor > 0)
			this.saldo += valor;
	}

	public boolean transferir(ContaBancaria destino, double valor) {
		if(sacar(valor)){
			destino.depositar(valor);
			return true;
		}
		return false;
	}
}
