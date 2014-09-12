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
					+ (mostraInd++) + "º elemento"));
		}
		
		tela.mostrarValoresDoVetor();		

		for(int posAtual = 0; posAtual < vet.length; posAtual++){
			int posMenor = posAtual;
			
			int[] vetorAuxiliar = vet;
			for(int indAtual = 0; indAtual < vetorAuxiliar.length; indAtual++){
				if()
			}
			
			System.out.println("Menor:"+vet[posMenor]+" EleAtual"+vet[posAtual]+ "ProxEle:"+vet[proxPos]);
			/*
			if(vet[posAtual] > vet[proxPos]){
				
			}
			
			if(vet[indAuxiliar] > vet[posAtual]){
				vet[posAtual] = elementoAtual;
				elementoAtual = indAuxiliar;
				
				
				//System.out.println(menorElemento+" "+indAuxiliar+" "+vet[ind]);

				tela.mostrarValoresDoVetor();				
			}
			
			indAuxiliar = posAtual;
			//JOptionPane.showMessageDialog(null, "menor:"+menorElemento+" aux:"+indAuxiliar+" vet:"+vet[ind]);
			 * 
			 */
		}
	}

	private void mostrarValoresDoVetor() {
		String resultado = "";
		for(int x : vetor){
			resultado += (x + " ");
		}
		
		JOptionPane.showMessageDialog(null, resultado);
		
	}

}
