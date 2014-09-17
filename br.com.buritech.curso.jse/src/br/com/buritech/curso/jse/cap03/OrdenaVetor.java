package br.com.buritech.curso.jse.cap03;

import javax.swing.JOptionPane;

public class OrdenaVetor {
	private int[] vetor = new int[10];
	
	public int[] getVetor() {
		return vetor;
	}
	
	public static void main(String[] args) {
		
		OrdenaVetor tela = new OrdenaVetor();
		
		int[] vet = tela.getVetor();
		
		//inserindo valores no vetor
		for (int ind = 0, mostraInd = 1; ind < vet.length; ind++) {
			vet[ind] = Integer.parseInt(JOptionPane.showInputDialog("Valor do "
					+ (mostraInd++) + "� elemento"));
		}
		
		boolean ordena = false;
		do {
			tela.mostrarValoresDoVetor();		

			int posAtual = 0;
			int auxiliar = 0;
			ordena = false;

			for(int proxPos = 1; proxPos < vet.length; proxPos++){
				System.out.println(vet[0]+" "+vet[1]+" "+vet[2]+" "+vet[3]+" "+vet[4]+" "+vet[5]+" "+vet[6]+" "+vet[7]+" "+vet[8]+" "+vet[9]);
				if(vet[posAtual] > vet[proxPos]){
					auxiliar = vet[posAtual];
					vet[posAtual] = vet[proxPos];
					vet[proxPos] = auxiliar;
					ordena = true;
					System.out.println("true");
				}else{
					System.out.println("false");
				}
				posAtual = proxPos;
			}
		} while(ordena);
	}

	private void mostrarValoresDoVetor() {
		String resultado = "";
		for(int x : vetor){
			resultado += (x + " ");
		}
		
		JOptionPane.showMessageDialog(null, resultado);
		
	}

}
