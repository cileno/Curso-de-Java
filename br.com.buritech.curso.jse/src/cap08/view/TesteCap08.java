package cap08.view;

import java.util.ArrayList;
import java.util.List;

import cap08.ControleSessao;
import exercicio.model.Cliente;
import br.com.buritech.curso.jse.cap07.Diretor;
import br.com.buritech.curso.jse.cap07.Funcionario;
import br.com.buritech.curso.jse.cap07.Gerente;
import br.com.buritech.curso.jse.utils.ShowIO;

public class TesteCap08 {
	public static void main(String[] args) {
		List<Funcionario> funcionarios = new ArrayList<Funcionario>();
		List<Cliente> clientes = new ArrayList<Cliente>();
		
		TesteCap08 tela = new TesteCap08();
		
		int sai = ShowIO.YES_OPTION;
		
		int totalConexaoDiretor = 0;
		int totalConexaoGerente = 0;
		int totalConexaoCliente = 0;
		
		ControleSessao ctrlSection = new ControleSessao();
		
		String menu = "Menu de Cadastro\n"
				+ "1 - Cliente\n"
				+ "2 - Gerente\n"
				+ "3 - Diretor\n"
				+ "4 - SAIR";
		
		do{
			int opcao = ShowIO.strToInt(menu);
			Funcionario funcionario = null;
			
			switch (opcao) {
			case 1:
				clientes.add(tela.inserirClientes());
				break;
			case 2:
				funcionario = new Gerente();
				funcionarios.add(tela.inserirFuncionario(funcionario));
				break;
			case 3:
				funcionario = new Diretor();
				funcionarios.add(tela.inserirFuncionario(funcionario));
				break;
			case 4:
			default:
				sai = ShowIO.NO_OPTION;
				break;
			}
		} while(sai == ShowIO.YES_OPTION);
		
		for(int x = 0; x < funcionarios.size(); x++){
			if(funcionarios.get(x) instanceof Gerente){
				int senha = ShowIO.strToInt("Senha do(a) "+((Gerente) funcionarios.get(x)).getNome());
				ctrlSection.autenticar(senha, ((Gerente) funcionarios.get(x)));
				if (((Gerente) funcionarios.get(x)).autenticar(senha))
					totalConexaoGerente++;
			}
			
			if(funcionarios.get(x) instanceof Diretor){
				int senha = ShowIO.strToInt("Senha do(a) "+((Diretor) funcionarios.get(x)).getNome());
				ctrlSection.autenticar(senha, ((Diretor) funcionarios.get(x)));
				if(((Diretor) funcionarios.get(x)).autenticar(senha))
					totalConexaoDiretor++;
			}
		}
		
		for(Cliente c : clientes){
			int senha = ShowIO.strToInt("senha do(a) "+c.getNome());
			
			ctrlSection.autenticar(senha, c);
			if(c.autenticar(senha))
				totalConexaoCliente++;
		}
		
		ShowIO.showMensage("Total de Conexões: "+ ctrlSection.getQtdeSessao()+"\n"
				+ "Total de Conexões de Clientes: "+totalConexaoCliente+"\n"
				+ "Total de Conexões de Clientes: "+totalConexaoGerente+"\n"
				+ "Total de Conexões de Clientes: "+totalConexaoDiretor);
	}

	private Funcionario inserirFuncionario(Funcionario funcionario) {
		Funcionario f = funcionario;
		String nome = ShowIO.input("Nome funcionário");
		int senha = ShowIO.strToInt("Senha");
		
		if(f instanceof Gerente){
			f.setNome(nome);
			((Gerente) f).setSenha(senha);
		}
		
		if(f instanceof Diretor){
			f.setNome(nome);
			((Diretor) f).setSenha(senha);
		}
		
		return f;
	}

	private Cliente inserirClientes() {
		String nome = ShowIO.input("Nome cliente");
		int senha = ShowIO.strToInt("Senha");
		
		return (new Cliente(nome, senha));
	}
}
