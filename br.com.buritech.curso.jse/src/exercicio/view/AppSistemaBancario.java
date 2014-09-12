package exercicio.view;

import java.util.ArrayList;
import java.util.List;

import javax.swing.JOptionPane;

import exercicio.model.Cliente;
import exercicio.model.Conta;

public class AppSistemaBancario {
	private List<Cliente> listaDeClientes = new ArrayList<Cliente>();
	private List<Conta> listaDeContas = new ArrayList<Conta>();

	public List<Cliente> getListaDeClientes() {
		return listaDeClientes;
	}

	public List<Conta> getListaDeContas() {
		return listaDeContas;
	}

	public static void main(String[] args) {
		int sai = JOptionPane.YES_OPTION;

		AppSistemaBancario tela = new AppSistemaBancario();

		String menu = "Sistema Bancário\n" + "1 - Cadastrar Cliente\n"
				+ "2 - Cadastrar Contas\n" + "3 - Listar Clientes\n"
				+ "4 - Listar Contas\n" + "5 - Excluir Clientes\n"
				+ "6 - Excluir Contas\n" + "7 - Saques\n" + "8 - Depósitos\n"
				+ "9 - Histórico \n" + "0 - SAIR";

		System.out.println("Inicio do Programa");

		while (sai == JOptionPane.YES_OPTION) {
			int opcao = Integer.parseInt(JOptionPane.showInputDialog(menu));

			switch (opcao) {
			case 1:
				System.out.println("opção " + opcao);

				tela.adicionarCliente();

				break;

			case 2:
				System.out.println("opção " + opcao);
				
				tela.adicionarConta(solicitarCPF());

				break;
			case 3:
				System.out.println("opção " + opcao);

				tela.listarClientes();

				break;
			case 4:
				System.out.println("opção " + opcao);
				
				tela.listarContas();
				
				break;
			case 5:
				System.out.println("opção " + opcao);
				
				tela.excluirCliente(solicitarCPF());
				break;
			case 6:
				System.out.println("opção " + opcao);
				
				tela.excluirConta(solicitarCPF());
				
				break;
			case 7:
				System.out.println("opção " + opcao);
				// sacar(solicitarCPF(), double valor)
				break;
			case 8:
				System.out.println("opção " + opcao);
				// depositar(solicitarCPF(), double valor)
				break;
			case 9:
				System.out.println("opção " + opcao);
				// listarHistorico();
				break;
			case 0:
				System.out.println("opção " + opcao);
				sai = JOptionPane.NO_OPTION;
				break;
			default:
				System.out.println("opção " + opcao);
				JOptionPane.showMessageDialog(null, "Opção Inválida");
				break;
			}
		}
		System.out.println("Fim de Programa");
	}

	private void excluirConta(String cpf) {
		Cliente cliente = buscarCliente(cpf);
		
		Conta conta = buscarConta(cliente);
		
		if(conta != null){
			listaDeContas.remove(conta);
			
			listaDeClientes.remove(cliente);
		} else
			JOptionPane.showMessageDialog(null, "CPF não encontrato");
	}

	private void excluirCliente(String cpf) {
		Cliente cliente = buscarCliente(cpf);
		
		if(cliente != null){
			Conta conta = buscarConta(cliente);
			
			if(conta == null)
				listaDeClientes.remove(cliente);
			else
				JOptionPane.showMessageDialog(null, "Cliente possui uma conta ativa");
		}else
			JOptionPane.showMessageDialog(null, "CPF não encontrato");
		
	}
	
	private Conta buscarConta(Cliente cliente){
		for (Conta conta : listaDeContas) {
			if(conta.getCliente().equals(cliente))
				return conta;
		}
		
		return null;
	}

	private static String solicitarCPF() {
		return JOptionPane.showInputDialog("Informe o CPF do Cliente");
	}

	private void listarContas() {
		String resultado = "";
		
		for (Conta conta : listaDeContas) {
			resultado += conta + "\n";
		}
		
		JOptionPane.showMessageDialog(null, resultado);
	}

	private void listarClientes() {
		String resultado = "";

		for (Cliente cliente : listaDeClientes) {
			resultado += cliente + "\n";
		}

		JOptionPane.showMessageDialog(null, resultado);
	}

	private void adicionarConta(String cpf) {
		Cliente cliente = buscarCliente(cpf);

		if (cliente == null)
			JOptionPane.showMessageDialog(null, "CPF não encontrado");
		else {
			String agencia = JOptionPane.showInputDialog("Agência:");
			String numero = JOptionPane.showInputDialog("Número da Conta:");
			double saldoInicial = Double.parseDouble(JOptionPane.showInputDialog("Saldo Inicial:"));

			listaDeContas.add(new Conta(agencia, numero, cliente, saldoInicial));
		}
	}

	private Cliente buscarCliente(String cpf) {
		for (Cliente cliente : listaDeClientes) {
			if (cliente.getCpf().equals(cpf)) {
				return cliente;
			}
		}

		return null;
	}

	private void adicionarCliente() {
		String nome = JOptionPane.showInputDialog("Nome:");
		String cpf = JOptionPane.showInputDialog("CPF do(a) sr(a)." + nome);

		listaDeClientes.add(new Cliente(cpf, nome));
	}

}
