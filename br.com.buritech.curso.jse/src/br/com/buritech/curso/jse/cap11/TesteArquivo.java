package br.com.buritech.curso.jse.cap11;

import exercicio.model.Conta;

public class TesteArquivo {

	public static void main(String[] args) {
		Conta conta = new Conta(1000);
		
		Arquivo arq = new Arquivo();
		
		arq.add(conta);
		
		arq.add(new Conta(500));
		
		//Object o = arq.getObjetos(0);		
		//o.sacar(100);

		//Conta o = arq.getObjetos(0);		
		//o.sacar(200);

		//Conta o = (Conta) arq.getObjetos(0);		
		//o.sacar(300);
		
		//for(int i = 0; i < arq)
		
		Object o = arq.getObjetos(0);
		if(o instanceof Conta){
			Conta contaDoida = (Conta) o;
			contaDoida.sacar(400);
			System.out.println(contaDoida.getSaldo());
		} //else
			//throw new 
	}

}
