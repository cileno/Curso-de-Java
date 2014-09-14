package br.com.buritech.curso.jse.cap06.view;

import java.util.ArrayList;

import javax.swing.JOptionPane;

import br.com.buritech.curso.jse.cap06.*;

public class TestaTotalBonusFuncionarios {

	public static void main(String[] args) {
		ArrayList<Funcionario> funcionarios = new ArrayList<Funcionario>();

		ControleBonus controle = new ControleBonus();

		int continua = JOptionPane.NO_OPTION;
		
		do {
			Funcionario f = null;
			int eGerente = JOptionPane.showConfirmDialog(null, "O Funcionário é "
					+ "Gerente?","Confirmar",JOptionPane.YES_NO_OPTION);
			
			double salario = Double.parseDouble(JOptionPane.showInputDialog("Informe o salário do Funcionario"));
			
			if(eGerente == JOptionPane.YES_OPTION)
				f = new Gerente(salario);
			else
				f = new Funcionario(salario);
			
			funcionarios.add(f);
			
			continua = JOptionPane.showConfirmDialog(null, "Continua?", "Confirmar",JOptionPane.YES_NO_OPTION);
		} while(continua == JOptionPane.YES_OPTION);
		
		for(Funcionario f : funcionarios) {
			controle.soma(f);
		}
		
		System.out.println("Total de Bonificação dos funcionários: " + controle.getTotal());

	}

}
