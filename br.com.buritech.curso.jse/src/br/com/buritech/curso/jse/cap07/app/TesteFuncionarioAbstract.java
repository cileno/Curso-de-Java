package br.com.buritech.curso.jse.cap07.app;

import java.util.ArrayList;

import javax.swing.JOptionPane;

import br.com.buritech.curso.jse.cap07.ControleBonus;
import br.com.buritech.curso.jse.cap07.Diretor;
import br.com.buritech.curso.jse.cap07.Funcionario;
import br.com.buritech.curso.jse.cap07.Gerente;
import br.com.buritech.curso.jse.cap07.Operario;

public class TesteFuncionarioAbstract {

	public static void main(String[] args) {
		ArrayList<Funcionario> funcionarios = new ArrayList<Funcionario>();

		Funcionario f = null;

		int confirma = JOptionPane.YES_OPTION;

		while (confirma == JOptionPane.YES_OPTION) {

			int cargo = Integer.parseInt(JOptionPane
					.showInputDialog("Informe o cargo do Funcion�rio:\n"
							+ "1 - Para Oper�rio\n" + "2 - Para Gerente\n"
							+ "3 - Para Diretor"));

			switch (cargo) {
			case 2:
				f = new Gerente(5000.00);
				break;
			case 3:
				f = new Diretor(6000.00);
				break;
			case 1:
			default:
				f = new Operario(1000.00);
			}
			
			funcionarios.add(f);
			
			confirma = JOptionPane.showConfirmDialog(null, "Adicionar Funcion�rio?", "Confirmar", JOptionPane.YES_NO_OPTION);
		}
		
		ControleBonus controleBonusDiretor = new ControleBonus();
		ControleBonus controleBonusGerente = new ControleBonus();
		ControleBonus controleBonusOperario = new ControleBonus();
		ControleBonus controleBonusTotal = new ControleBonus();
		
		f = null;
		
		for(int indice = 0; indice < funcionarios.size(); indice++){
			f = funcionarios.get(indice);
			
			controleBonusTotal.registrarBonus(f);
			
			if(f instanceof Diretor)
				controleBonusDiretor.registrarBonus(f);
			
			if(f instanceof Gerente)
				controleBonusGerente.registrarBonus(f);
			
			if(f instanceof Operario)
				controleBonusOperario.registrarBonus(f);
		}
		
		System.out.println("Foram pagos R$" + controleBonusTotal.getTotalDeBonus() + ", sendo:");
		System.out.println("B�nus para Diretor(es): R$" + controleBonusDiretor.getTotalDeBonus());
		System.out.println("B�nus para Gerente(s): R$" + controleBonusGerente.getTotalDeBonus());
		System.out.println("B�nus para Oper�rio(s): R$" + controleBonusOperario.getTotalDeBonus());

	}
}
