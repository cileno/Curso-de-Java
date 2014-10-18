package br.com.agenda.view;


import java.awt.BorderLayout;
import java.awt.HeadlessException;
import java.util.List;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import br.com.agenda.model.dao.PersonDAO;
import br.com.agenda.model.entity.Person;

public class ContactOfListFrame extends JFrame{
	
	private static final long serialVersionUID = -1461323450157685501L;
	
	private AgendaControllFrame agendaFrame;
	private JPanel painelDeFundo;
	private JTable tabela;
	private JScrollPane barraRolagem;
	private DefaultTableModel modelo = new DefaultTableModel();
	
	private PersonDAO personDAO;

	public ContactOfListFrame(AgendaControllFrame agendaFrame)
			throws HeadlessException {
		super("Contatos");
		this.agendaFrame = agendaFrame;
		this.personDAO = personDAO.getPersonDAO();
		
		createTable();
		createWindow();
	}

	private void createTable() {
		System.out.println("criando tabela");

		tabela = new JTable(modelo);

		modelo.addColumn("Id");
		modelo.addColumn("Nome");
		modelo.addColumn("Telefone");
		modelo.addColumn("Email");

		tabela.getColumnModel().getColumn(0).setPreferredWidth(10);
		tabela.getColumnModel().getColumn(1).setPreferredWidth(120);
		tabela.getColumnModel().getColumn(1).setPreferredWidth(80);
		tabela.getColumnModel().getColumn(1).setPreferredWidth(120);
		
		
		final List<Person> peopleList = personDAO.searchingAllPeople();
		modelo.setNumRows(0);
		
		for (Person contato : peopleList) {
			modelo.addRow(new Object[] { contato.getId(), contato.getName(),
					contato.getPhone(), contato.getEmail() });
		}

	}

	private void createWindow() {
		barraRolagem = new JScrollPane(tabela);
		
		painelDeFundo = new JPanel();
		painelDeFundo.setLayout(new BorderLayout());
		painelDeFundo.add(BorderLayout.CENTER, barraRolagem);
		
		getContentPane().add(painelDeFundo);
		
		setSize(500, 120);
		setVisible(true);
	}
	
	
}
