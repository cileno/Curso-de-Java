package br.com.buritech.curso.jee.view;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import javax.swing.JOptionPane;

import br.com.buritech.curso.jee.model.bean.Empresa;
import br.com.buritech.curso.jee.model.dao.EmpresaDAO;

public class TesteEmpresaDAO {

	public static void main(String[] args) {
		TesteEmpresaDAO teste = new TesteEmpresaDAO();

		System.out.println("INICIO");

		Empresa emp1 = teste.informDados(1);

		// Empresa emp2 = new Empresa();
		//
		// Empresa emp3 = new Empresa();
		//
		// Empresa emp4 = new Empresa();

		System.out.println("Pesquisando um único registro");
		long id = 1;

		EmpresaDAO empresaDao = new EmpresaDAO();

		Empresa emp = empresaDao.searchCompany(id);

		System.out.println(emp.toString());

		System.out.println("\nINSERINDO REGISTROS");
		// inserindo empresa no banco
		empresaDao.insertCompany(emp1);
		// empresaDao.insertCompany(emp2);
		// empresaDao.insertCompany(emp3);
		// empresaDao.insertCompany(emp4);

		System.out.println("\nListando todas as empresas cadastradas:");
		// listando todas as empresas
		List<Empresa> showEmpresas = new ArrayList<Empresa>();
		showEmpresas = empresaDao.listAllCompany();
		for (Empresa empresa : showEmpresas) {
			System.out.println(empresa.toString());
		}

		// excluindo registros
		emp = teste.findEmpresa(
				teste.inputMessage("Informe o CNPJ da Empresa"), showEmpresas);
		if (emp != null) {
			empresaDao.deleteCompany(emp);
			System.out.println("Empresa excluída com sucesso");
		} else {
			System.out.println("Empresa não encontrada");
		}

		// alterando os dados de uma empresa
		emp = teste.findEmpresa(
				teste.inputMessage("Informe o CNPJ da Empresa"), showEmpresas);
		if (emp != null) {
			emp1 = teste.informDados(2);
			emp.setRazaoSocial(emp1.getRazaoSocial());
			emp.setEndereco(emp1.getEndereco());
			emp.setTelefone(emp1.getTelefone());
			emp.setSite(emp1.getSite());
			emp.setEmail(emp1.getEmail());
			
			empresaDao.updateCompany(emp);
			
			System.out.println("Dados da empresa " + emp.toString() + " alterada com sucesso.");
			
		} else {
			System.out.println("Empresa não encontrada");
		}

	}

	private Empresa informDados(int tipo) {
		Empresa empresa = new Empresa();
		
		if(tipo == 1){
			empresa.setCnpj(inputMessage("CNPJ:"));
			empresa.setDataCriacao(Calendar.getInstance());
		}
		
		empresa.setRazaoSocial(inputMessage("Razão Social:"));
		empresa.setEndereco(inputMessage("Endereço:"));
		empresa.setTelefone(inputMessage("Telefone:"));
		empresa.setSite(inputMessage("Site:"));
		empresa.setEmail(inputMessage("E-mail:"));

		return empresa;
	}

	private Empresa findEmpresa(String cnpj, List<Empresa> showEmpresas) {
		for (Empresa empresa : showEmpresas) {
			if (empresa.getCnpj().equals(cnpj))
				return empresa;
		}
		return null;
	}

	private String inputMessage(String atributo) {
		return JOptionPane.showInputDialog(atributo);
	}

}
