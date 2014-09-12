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
				+ "1 - Adicionar Polígonos\n"
				+ "2 - Listar Polígonos\n"
				+ "3 - Excluir Polígonos\n"
				+ "4 - Consultar Polígono\n"
				+ "0 - sair";
				
		AppTestaPoligonos tela = new AppTestaPoligonos();
		
		System.out.println("Início do Programa");
		
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
				
				nome = JOptionPane.showInputDialog("Informe o nome do Polígono:");
				
				if (tela.excluirPoligono(nome))
					JOptionPane.showMessageDialog(null, "Polígono excluido com sucesso");
				else
					JOptionPane.showMessageDialog(null, "Polígono não encontrado");
				
				break;
			case 4:
				System.out.println("opcao " + opcao);

				nome = JOptionPane.showInputDialog("Informe o nome do Polígono:");
				
				poligono = tela.consultarPoligono(nome);
				
				if(poligono != null)
					JOptionPane.showMessageDialog(null, poligono.toString());
				else
					JOptionPane.showMessageDialog(null, "Polígono não encontrado");
				
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

		String subMenu = "Tipos de Polígonos\n"
				+ "1 - Quadrado\n"
				+ "2 - Retângulo\n"
				+ "3 - Triângulo\n\n"
				+ "0 - Ferchar";
		
		String nome = "";
		
		while(continuaAdiconando == JOptionPane.YES_OPTION){

			int opcao = Integer.parseInt(JOptionPane.showInputDialog(subMenu));

			int numeroDeLados = 0;
			
			switch (opcao) {
			case 1:
				nome = JOptionPane.showInputDialog("Informe o Nome do Polígono Quadrado");
				
				numeroDeLados = 4;
				
				int lado = Integer.parseInt(JOptionPane.showInputDialog("Informe a medida do lado do Quadrado")); 

				pg = new Quadrado(nome, numeroDeLados, lado);
				
				System.out.println("Add "+ nome);

				break;
			case 2:
				nome = JOptionPane.showInputDialog("Informe o Nome do Polígono Retângulo");
				
				numeroDeLados = 4;				
				
				int base = Integer.parseInt(JOptionPane.showInputDialog("Informe a medida da base do retângulo"));
				
				int altura = Integer.parseInt(JOptionPane.showInputDialog("Informe a medida da altura do retângulo"));
				
				pg = new Retangulo(nome, numeroDeLados, base, altura);
				
				System.out.println("Add "+ nome);
				break;
			case 3:
				nome = JOptionPane.showInputDialog("Informe o Nome do Polígono Triângulo");
				numeroDeLados = 3;				
				int[] lados = new int[numeroDeLados];
				
				for(int x = 0, cont = 1; x < numeroDeLados; x++){
					lados[x] = Integer.parseInt(JOptionPane.showInputDialog("Informe a medida do "
							+ (cont++) +"º lado do Triângulo"));
				}
				
				pg = new Triangulo(nome, numeroDeLados, lados);
				
				System.out.println("Add "+ nome);
				break;
			case 0:
			default:
				continuaAdiconando = JOptionPane.NO_OPTION;
				System.out.println("Fechando a adição de polígonos");
				break;
			}
			
			listaDePoligonos.add(pg);	
		}
	}

}
