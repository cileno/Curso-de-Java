package br.com.buritech.curso.jse.cap07.app;

import java.util.ArrayList;
import java.util.List;

import br.com.buritech.curso.jse.cap07.PoligonoGenerico;
import br.com.buritech.curso.jse.cap07.Quadrado;
import br.com.buritech.curso.jse.cap07.Retangulo;
import br.com.buritech.curso.jse.cap07.Triangulo;
import br.com.buritech.curso.jse.utils.ShowIO;

public class AppTestaPoligonos {
	private List<PoligonoGenerico> listaDePoligonos = new ArrayList<PoligonoGenerico>();

	public List<PoligonoGenerico> getListaDePoligonos() {
		return listaDePoligonos;
	}

	public static void main(String[] args) {
		System.out.println("Inicio do Programa");

		int sai = ShowIO.YES_OPTION;

		String nome = "";

		PoligonoGenerico poligono = null;

		String menu = "Menu\n" + "1 - Adicionar Poligonos\n"
				+ "2 - Listar Poligonos\n" + "3 - Excluir Poligonos\n"
				+ "4 - Consultar Poligono\n" + "0 - sair";

		AppTestaPoligonos tela = new AppTestaPoligonos();

		while (sai == ShowIO.YES_OPTION) {
			int opcao = ShowIO.strToInt(menu);

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
				nome = ShowIO.input("Informe o nome do Poligono");

				if (tela.excluirPoligono(nome))
					ShowIO.showMensage("Poligono excluido com sucesso");
				else
					ShowIO.showMensage("Poligono nao encontrado");

				break;
			case 4:
				System.out.println("opcao " + opcao);

				nome = ShowIO.input("Informe o nome do Poligono:");
				poligono = tela.consultarPoligono(nome);

				if (poligono != null)
					ShowIO.showMensage(poligono.toString());
				else
					ShowIO.showMensage("Poligono nao encontrado");

				break;
			case 5:
			default:
				sai = ShowIO.NO_OPTION;
				break;
			}
		}

		System.out.println("Fim do programa");
	}

	private PoligonoGenerico consultarPoligono(String nome) {
		for (PoligonoGenerico poligono : listaDePoligonos) {
			if (poligono.getNome().equals(nome))
				return poligono;
		}
		return null;
	}

	private boolean excluirPoligono(String nome) {
		for (PoligonoGenerico poligono : listaDePoligonos) {
			if (poligono.getNome().equals(nome)) {
				listaDePoligonos.remove(poligono);
				return true;
			}
		}
		return false;
	}

	private void listarPoligonos() {
		String resultado = "";
		for (PoligonoGenerico poligono : listaDePoligonos) {
			resultado += poligono.toString() + "\n";
		}

		ShowIO.showMensage(resultado);

	}

	private void adicionarPoligno() {
		System.out.println("espendo a escolha do tipo de Poligono");

		int continuaAdiconando = ShowIO.YES_OPTION;

		PoligonoGenerico pg = null;

		String subMenu = "Tipos de Poligonos\n" + "1 - Quadrado\n"
				+ "2 - Retangulo\n" + "3 - Triangulo\n\n" + "0 - Ferchar";

		while (continuaAdiconando == ShowIO.YES_OPTION) {

			int opcao = ShowIO.strToInt(subMenu);

			switch (opcao) {
			case 1:
				int lado = ShowIO.strToInt("Informe a medida do lado do Quadrado");
				pg = new Quadrado(lado);
				listaDePoligonos.add(pg);

				System.out.println("Add " + pg.getNome());

				break;
			case 2:
				int base = ShowIO.strToInt("Informe a medida da base do Retangulo");
				int altura = ShowIO.strToInt("Informe a medida da altura do Retangulo");
				pg = new Retangulo(base, altura);
				
				listaDePoligonos.add(pg);

				System.out.println("Add " + pg.getNome());
				
				break;
			case 3:
				int a = ShowIO.strToInt("Informe o tamanho do lado A do Triangulo");
				int b = ShowIO.strToInt("Informe o tamanho do lado B do Triangulo");
				int c = ShowIO.strToInt("Informe o tamanho do lado C do Triangulo");

				pg = new Triangulo(a, b, c);
				
				listaDePoligonos.add(pg);

				System.out.println("Add " + pg.getNome());
				break;
			case 0:
			default:
				continuaAdiconando = ShowIO.NO_OPTION;
				System.out.println("Fechando a adicao de poligonos");
				break;
			}
		}
	}

}
