package br.com.buritech.curso.jse.cap07.app;

import java.util.ArrayList;
import java.util.List;

import javax.swing.JOptionPane;

import br.com.buritech.curso.jse.cap07.PoligonoGenerico;
import br.com.buritech.curso.jse.cap07.Quadrado;
import br.com.buritech.curso.jse.cap07.Retangulo;
import br.com.buritech.curso.jse.cap07.Triangulo;

public class AppTestaPoligonos {
	private List<PoligonoGenerico> listaDePoligonos = new ArrayList<PoligonoGenerico>();

	public List<PoligonoGenerico> getListaDePoligonos() {
		return listaDePoligonos;
	}
	
	public static void main(String[] args) {
		int sai = JOptionPane.YES_OPTION;
		
		String nome = "";
		
		PoligonoGenerico poligono = null;
		
		String menu = "Menu\n"
				+ "1 - Adicionar Pol�gonos\n"
				+ "2 - Listar Pol�gonos\n"
				+ "3 - Excluir Pol�gonos\n"
				+ "4 - Consultar Pol�gono\n"
				+ "0 - sair";
				
		AppTestaPoligonos tela = new AppTestaPoligonos();
		
		System.out.println("In�cio do Programa");
		
		while(sai == JOptionPane.YES_OPTION){
			int opcao = Integer.parseInt(JOptionPane.showInputDialog(menu));
			
			switch (opcao) {
			case 1:
				System.out.println("opcao " + opcao);
				
				tela.adicionarPoligno();
				
				break;
			case 2:
				System.out.println("opcao " + opcao);
				
				tela.listarPoligonos();
				
				break;
			case 3:
				System.out.println("opcao " + opcao);
				
				nome = JOptionPane.showInputDialog("Informe o nome do Pol�gono:");
				
				if (tela.excluirPoligono(nome))
					JOptionPane.showMessageDialog(null, "Pol�gono excluido com sucesso");
				else
					JOptionPane.showMessageDialog(null, "Pol�gono n�o encontrado");
				
				break;
			case 4:
				System.out.println("opcao " + opcao);

				nome = JOptionPane.showInputDialog("Informe o nome do Pol�gono:");
				
				poligono = tela.consultarPoligono(nome);
				
				if(poligono != null)
					JOptionPane.showMessageDialog(null, poligono.toString());
				else
					JOptionPane.showMessageDialog(null, "Pol�gono n�o encontrado");
				
				break;
			case 5:
			default:
				sai = JOptionPane.NO_OPTION;
				break;
			}			
		}
		
		System.out.println("Fim do programa");
	}

	private PoligonoGenerico consultarPoligono(String nome) {
		for(PoligonoGenerico poligono : listaDePoligonos){
			if(poligono.getNome().equals(nome))
				return poligono;
		}
		return null;
	}

	private boolean excluirPoligono(String nome) {
		for(PoligonoGenerico poligono : listaDePoligonos){
			if(poligono.getNome().equals(nome)){
				listaDePoligonos.remove(poligono);
				return true;
			}
		}
		return false;
	}

	private void listarPoligonos() {
		String resultado = "";
		for(PoligonoGenerico poligono: listaDePoligonos){
			resultado += poligono.toString() + "\n";
		}
		
		JOptionPane.showMessageDialog(null, resultado);
		
	}

	private void adicionarPoligno() {
		int continuaAdiconando = JOptionPane.YES_OPTION;
		
		PoligonoGenerico pg = null;

		String subMenu = "Tipos de Pol�gonos\n"
				+ "1 - Quadrado\n"
				+ "2 - Ret�ngulo\n"
				+ "3 - Tri�ngulo\n\n"
				+ "0 - Ferchar";
		
		String nome = "";
		
		while(continuaAdiconando == JOptionPane.YES_OPTION){

			int opcao = Integer.parseInt(JOptionPane.showInputDialog(subMenu));

			int numeroDeLados = 0;
			
			switch (opcao) {
			case 1:
				nome = JOptionPane.showInputDialog("Informe o Nome do Pol�gono Quadrado");
				
				numeroDeLados = 4;
				
				int lado = Integer.parseInt(JOptionPane.showInputDialog("Informe a medida do lado do Quadrado")); 

				pg = new Quadrado(nome, numeroDeLados, lado);
				
				System.out.println("Add "+ nome);

				break;
			case 2:
				nome = JOptionPane.showInputDialog("Informe o Nome do Pol�gono Ret�ngulo");
				
				numeroDeLados = 4;				
				
				int base = Integer.parseInt(JOptionPane.showInputDialog("Informe a medida da base do ret�ngulo"));
				
				int altura = Integer.parseInt(JOptionPane.showInputDialog("Informe a medida da altura do ret�ngulo"));
				
				pg = new Retangulo(nome, numeroDeLados, base, altura);
				
				System.out.println("Add "+ nome);
				break;
			case 3:
				nome = JOptionPane.showInputDialog("Informe o Nome do Pol�gono Tri�ngulo");
				numeroDeLados = 3;				
				int[] lados = new int[numeroDeLados];
				
				for(int x = 0, cont = 1; x < numeroDeLados; x++){
					lados[x] = Integer.parseInt(JOptionPane.showInputDialog("Informe a medida do "
							+ (cont++) +"� lado do Tri�ngulo"));
				}
				
				pg = new Triangulo(nome, numeroDeLados, lados);
				
				System.out.println("Add "+ nome);
				break;
			case 0:
			default:
				continuaAdiconando = JOptionPane.NO_OPTION;
				System.out.println("Fechando a adi��o de pol�gonos");
				break;
			}
			
			listaDePoligonos.add(pg);	
		}
	}

}
