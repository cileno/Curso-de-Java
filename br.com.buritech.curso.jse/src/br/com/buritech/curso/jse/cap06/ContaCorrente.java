package br.com.buritech.curso.jse.cap06;

public class ContaCorrente extends Conta {

	public ContaCorrente(double saldo) {
		super(saldo);
	}

	public ContaCorrente(String numero, double saldo) {
		super(numero, saldo);
	}

	@Override
	public void depositar(double valor) {
		super.depositar(valor - this.cobrarTransacao(valor)); 
	}

	@Override
	public boolean sacar(double valor) {
		double valorDeTransacao = valor + this.cobrarTransacao(valor);
		
		if (valorDeTransacao <= this.getSaldo()) {
			super.sacar(valorDeTransacao);
			
			return true;
		}
		
		return false;
	}

	private double cobrarTransacao(double valor) {
		double taxa = this.getSaldo() * 0.01;
		
		return taxa;
	}
}
