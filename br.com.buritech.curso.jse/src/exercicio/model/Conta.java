package exercicio.model;

import exercicio.rn.SaldoInsuficienteException;
import exercicio.rn.ValorInvalidoException;

public class Conta {
	private String agencia;
	private String numero;
	private double saldo;
	private Cliente cliente;

	public Conta(){
		super();
	}
	
	public Conta(String agencia, String numero, Cliente cliente, double saldo) {
		super();
		
		this.agencia = agencia;
		this.numero = numero;
		this.cliente = cliente;
		
		this.depositar(saldo);
	}

	public Conta(double saldo) {
		super();
		
		this.depositar(saldo);
	}
	
	@Override
	public String toString() {
		/*
		return "[Agência: " + this.agencia + " - Número da Conta: " + this.numero + "] Saldo: " +
				this.saldo + " - " + this.cliente.toString();
		*/
		
		return "Saldo: " + this.saldo;
	}

	
	@Override
	public boolean equals(Object obj) {
		if(!(obj instanceof Conta)){
			return false;
		}
		
		Conta contaParametro = (Conta) obj;
		
		return this.saldo == contaParametro.saldo;
	}

	// Ctrl + 3, ggas
	public String getAgencia() {
		return agencia;
	}

	public void setAgencia(String agencia) {
		this.agencia = agencia;
	}

	public String getNumero() {
		return numero;
	}

	public void setNumero(String numero) {
		this.numero = numero;
	}

	public double getSaldo() {
		return saldo;
	}

	public Cliente getCliente() {
		return cliente;
	}

	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}

	public void depositar(double valor) {
		if (valor < 0)
			throw new ValorInvalidoException("Valor Inválido para Depósito");
		else
			this.saldo += valor;
	}

	public void sacar(double valor) {
		if (valor <= 0)
			throw new ValorInvalidoException("Valor Inválido para Saque");
		else if (valor > this.saldo)
			throw new SaldoInsuficienteException("Saldo Insuficiente");
		else
			this.saldo -= valor;
	}

	public void valorSobreTransacao(double taxa) {
		this.saldo -= (getSaldo() * taxa);
	}
}
