package br.com.agenda.view;

import java.awt.Container;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

import br.com.agenda.model.dao.PersonDAO;
import br.com.agenda.model.entity.Person;

@SuppressWarnings("serial")
public class AgendaControllFrame extends JFrame implements ActionListener {
	/*
	 * definindo os componentes/propriedades da tela
	 */
	private List<Person> peopleList; // lista de pessoas
	private PersonDAO personDAO; // DAO de Pessoas
	//private PhoneDAO phoneDAO; //DAO de telefones
	//private AddressDAO addressDAO; //DAO de endereços
	//private EmailDAO emailDAO; //DAO de emails

	//painel
	private Container cPainel;
	
	// indice que será usado para nagevar entre os registros
	private int recordNumber;
	
	//labels
	private JLabel jlName, jlAddress, jlPhone, jlEmail;
	//textfields
	private JTextField jtfName, jtfAddress, jtfPhone, jtfEmail;
	//botões
	private JButton jbAdd, jbDelete, jbUpdate, jbExit, jbCleanUp, jbSearch,
			jbNext, jbPrevious, jbPrint;

	// Construtor
	public AgendaControllFrame() {
		super("Agenda");

		//set Indice de navegação de registros
		recordNumber = -1;
		
		// criando o form
		createGui();
		
		// instaciando a lista de pessoas
		peopleList = new ArrayList<Person>();
		
		// instancia da pessoaDAO atual
		personDAO = PersonDAO.getPersonDAO();
		//phoneDAO = PhoneDAO.getPhoneDAO();
	}

	// criando a tela
	public void createGui() {
		cPainel = getContentPane();
		cPainel.setLayout(new GridBagLayout());

		// fecha a tela como um todo
		setDefaultCloseOperation(EXIT_ON_CLOSE);

		// colocando os compontes no painel
		arrangeComponents();

		// definindo tamanho: largura e altura
		setSize(340, 300);

		// não redimensiona atela
		setResizable(false);

		// deixa a tela visível
		setVisible(true);
	}

	public void arrangeComponents() {
		// set labels
		jlName = new JLabel("Nome");
		jlAddress = new JLabel("Endereço");
		jlPhone = new JLabel("Telefone");
		jlEmail = new JLabel("Email");

		// set textfields
		jtfName = new JTextField(20);
		jtfAddress = new JTextField(20);
		jtfPhone = new JTextField(20);
		jtfEmail = new JTextField(20);

		// set buttons
		jbAdd = new JButton("Incluir");
		jbDelete = new JButton("Excluir");
		jbCleanUp = new JButton("Limpar");
		jbUpdate = new JButton("Alterar");
		jbSearch = new JButton("Pesquisar");
		jbNext = new JButton(">>");
		jbPrevious = new JButton("<<");
		jbExit = new JButton("Fechar");		
		jbPrint = new JButton("Print");

		/*
		 * adiciona todos os componentes ao container
		 */
		// posicionando a label nome
		GridBagConstraints gridBagConstraintsX01 = new GridBagConstraints();
		gridBagConstraintsX01.gridx = 0;
		gridBagConstraintsX01.gridy = 0;
		gridBagConstraintsX01.insets = new Insets(5, 5, 5, 5);
		cPainel.add(jlName, gridBagConstraintsX01);

		// posicionando o textfield nome
		GridBagConstraints gridBagConstraintsX02 = new GridBagConstraints();
		gridBagConstraintsX02.gridx = 1;
		gridBagConstraintsX02.gridy = 0;
		gridBagConstraintsX02.insets = new Insets(5, 5, 5, 5);
		gridBagConstraintsX02.gridwidth = 2;
		gridBagConstraintsX02.fill = GridBagConstraints.BOTH;
		cPainel.add(jtfName, gridBagConstraintsX02);

		// posicionando a label endereço
		GridBagConstraints gridBagConstraintsX03 = new GridBagConstraints();
		gridBagConstraintsX03.gridx = 0;
		gridBagConstraintsX03.gridy = 1;
		gridBagConstraintsX03.insets = new Insets(5, 5, 5, 5);
		cPainel.add(jlAddress, gridBagConstraintsX03);

		// posicionando o textfield endereço
		GridBagConstraints gridBagConstraintsX04 = new GridBagConstraints();
		gridBagConstraintsX04.gridx = 1;
		gridBagConstraintsX04.gridy = 1;
		gridBagConstraintsX04.insets = new Insets(5, 5, 5, 5);
		gridBagConstraintsX04.gridwidth = 2;
		gridBagConstraintsX04.fill = GridBagConstraints.BOTH;
		cPainel.add(jtfAddress, gridBagConstraintsX04);

		// posicionando a label telefone
		GridBagConstraints gridBagConstraintsX05 = new GridBagConstraints();
		gridBagConstraintsX05.gridx = 0;
		gridBagConstraintsX05.gridy = 2;
		gridBagConstraintsX05.insets = new Insets(5, 5, 5, 5);
		cPainel.add(jlPhone, gridBagConstraintsX05);

		// posicionando o textfield telefone
		GridBagConstraints gridBagConstraintsX06 = new GridBagConstraints();
		gridBagConstraintsX06.gridx = 1;
		gridBagConstraintsX06.gridy = 2;
		gridBagConstraintsX06.insets = new Insets(5, 5, 5, 5);
		gridBagConstraintsX06.gridwidth = 2;
		gridBagConstraintsX06.fill = GridBagConstraints.BOTH;
		cPainel.add(jtfPhone, gridBagConstraintsX06);

		// posicionando a label email
		GridBagConstraints gridBagConstraintsX07 = new GridBagConstraints();
		gridBagConstraintsX07.gridx = 0;
		gridBagConstraintsX07.gridy = 3;
		gridBagConstraintsX07.insets = new Insets(5, 5, 5, 5);
		cPainel.add(jlEmail, gridBagConstraintsX07);

		// posicionando o textfield email
		GridBagConstraints gridBagConstraintsX08 = new GridBagConstraints();
		gridBagConstraintsX08.gridx = 1;
		gridBagConstraintsX08.gridy = 3;
		gridBagConstraintsX08.insets = new Insets(5, 5, 5, 5);
		gridBagConstraintsX08.gridwidth = 2;
		gridBagConstraintsX08.fill = GridBagConstraints.BOTH;
		cPainel.add(jtfEmail, gridBagConstraintsX08);

		// posicionando o botao Incluir
		GridBagConstraints gridBagConstraintsX09 = new GridBagConstraints();
		gridBagConstraintsX09.gridx = 0;
		gridBagConstraintsX09.gridy = 4;
		gridBagConstraintsX09.insets = new Insets(5, 5, 5, 5);
		cPainel.add(jbAdd, gridBagConstraintsX09);

		// posicionando o botao Alterar
		GridBagConstraints gridBagConstraintsX10 = new GridBagConstraints();
		gridBagConstraintsX10.gridx = 1;
		gridBagConstraintsX10.gridy = 4;
		gridBagConstraintsX10.insets = new Insets(5, 5, 5, 5);
		cPainel.add(jbUpdate, gridBagConstraintsX10);

		// posicionando o botao Excluir
		GridBagConstraints gridBagConstraintsX11 = new GridBagConstraints();
		gridBagConstraintsX11.gridx = 2;
		gridBagConstraintsX11.gridy = 4;
		gridBagConstraintsX11.insets = new Insets(5, 5, 5, 5);
		cPainel.add(jbDelete, gridBagConstraintsX11);

		// posicionando o botao Limpar
		GridBagConstraints gridBagConstraintsX12 = new GridBagConstraints();
		gridBagConstraintsX12.gridx = 0;
		gridBagConstraintsX12.gridy = 5;
		gridBagConstraintsX12.insets = new Insets(5, 5, 5, 5);
		cPainel.add(jbCleanUp, gridBagConstraintsX12);

		// posicionando o botao Pesquisar
		GridBagConstraints gridBagConstraintsX13 = new GridBagConstraints();
		gridBagConstraintsX13.gridx = 1;
		gridBagConstraintsX13.gridy = 5;
		gridBagConstraintsX13.insets = new Insets(5, 5, 5, 5);
		cPainel.add(jbSearch, gridBagConstraintsX13);

		// posicionando o botao Print
		GridBagConstraints gridBagConstraintsX14 = new GridBagConstraints();
		gridBagConstraintsX14.gridx = 2;
		gridBagConstraintsX14.gridy = 5;
		gridBagConstraintsX14.insets = new Insets(5, 5, 5, 5);
		cPainel.add(jbPrint, gridBagConstraintsX14);

		// posicionando o botao anterior
		GridBagConstraints gridBagConstraintsX15 = new GridBagConstraints();
		gridBagConstraintsX15.gridx = 0;
		gridBagConstraintsX15.gridy = 6;
		gridBagConstraintsX15.insets = new Insets(5, 5, 5, 5);
		cPainel.add(jbPrevious, gridBagConstraintsX15);
		
		// posicionando o botao Próximo
		GridBagConstraints gridBagConstraintsX16 = new GridBagConstraints();
		gridBagConstraintsX16.gridx = 1;
		gridBagConstraintsX16.gridy = 6;
		gridBagConstraintsX16.insets = new Insets(5, 5, 5, 5);
		cPainel.add(jbNext, gridBagConstraintsX16);
		
		// posicionando o botao Fechar
		GridBagConstraints gridBagConstraintsX17 = new GridBagConstraints();
		gridBagConstraintsX17.gridx = 2;
		gridBagConstraintsX17.gridy = 6;
		gridBagConstraintsX17.insets = new Insets(5, 5, 5, 5);
		cPainel.add(jbExit, gridBagConstraintsX17);
		
		jbAdd.addActionListener(this);
		jbUpdate.addActionListener(this);
		jbDelete.addActionListener(this);
		jbCleanUp.addActionListener(this);
		jbSearch.addActionListener(this);
		jbPrint.addActionListener(this);
		jbPrevious.addActionListener(this);
		jbNext.addActionListener(this);
		jbExit.addActionListener(this);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == jbAdd) {
			addPerson();
			clearScreen();
			
		} else if(e.getSource() == jbUpdate){
			updatePerson();
			clearScreen();
			
		} else if(e.getSource() == jbDelete){
			removePerson();
			clearScreen();
			
		} else if(e.getSource() == jbCleanUp){
			clearScreen();
			
		} else if (e.getSource() == jbSearch){
			searchPerson();
		} else if(e.getSource() == jbPrint){
			ContactOfListFrame contatosFrame = new ContactOfListFrame(this);
			contatosFrame.setVisible(true);
		} else if(e.getSource() == jbPrevious){
			showsThePreviousRecord();
		} else if(e.getSource() == jbNext){
			showsTheNextRecord();
		} else if(e.getSource() == jbExit){
			System.exit(0);
		}

	}

	private void searchPerson() {
		String name = jtfName.getText().toUpperCase().trim();
		
		//limpando a lista de contatos para realizar a pesquisa sem dados anteriores
		peopleList.clear();
		recordNumber = 0;
		
		if(name.equals("")){
			JOptionPane.showMessageDialog(null, "Informe um nome para realizar a pesquisa.");
		} else{
			//procurando contatos baseado no nome
			peopleList = personDAO.searchPerson(name);
			
			//verificando se encontrou alguma ocorrência com o nome fornecido
			if(peopleList.size() == 0){
				JOptionPane.showMessageDialog(null, "Não há contatos com o nome "+name+".");
				
				clearScreen();
			} else{
				//set o primeiro contato nos campos da tela
				Person pessoa = peopleList.get(recordNumber);
				
				jtfName.setText(pessoa.getName());
				jtfAddress.setText(pessoa.getAddress());
				jtfPhone.setText(pessoa.getPhone());
				jtfEmail.setText(pessoa.getEmail());
			}
		}
		
	}

	private void removePerson() {
		String name = jtfName.getText();
		name = name.toUpperCase().trim();
		
		if(name.equals("")){
			JOptionPane.showMessageDialog(null, "Informe um nome para realizar a exclusao.");
		} else{
			int numberToBeDeleted = personDAO.removePerson(name);
			JOptionPane.showMessageDialog(null, numberToBeDeleted + "Item excluído");
		}
		
	}

	public void showsThePreviousRecord() {
		//decrements to go to the previous record in the list
		recordNumber--;
		
		//if arrived at the beginning of the list 
		if(recordNumber < 0){
			JOptionPane.showMessageDialog(null, "Início da lista");
			
			jbNext.setEnabled(true); //disable the Next button
			jbPrevious.setEnabled(false); // enable the Previous button
			
			//decrements to stay in last record
			recordNumber++;
		} else {
			//enable the buttons of the navegation
			jbNext.setEnabled(true);
			//jbPrevious.setEnabled(true);
			
			//get the person
			Person person = peopleList.get(recordNumber);
			
			//showing the record in text field
			jtfName.setText(person.getName());
			jtfAddress.setText(person.getAddress());
			jtfPhone.setText(person.getPhone());
			jtfEmail.setText(person.getEmail());
		}
	}

	public void showsTheNextRecord() {
		//increments to go to the next record in the list
		recordNumber++;
		
		//if arrived at the end of the list 
		if(recordNumber >= peopleList.size()){
			JOptionPane.showMessageDialog(null, "Fim da lista");
			
			jbNext.setEnabled(false); //disable the Next button
			jbPrevious.setEnabled(true); // enable the Previous button
			
			//decrements to stay in last record
			recordNumber--;
			
		} else {
			//enable the buttons of the navegation
			//jbNext.setEnabled(true);
			jbPrevious.setEnabled(true);
			
			//get the person
			Person person = peopleList.get(recordNumber);
			
			//showing the record in text field
			jtfName.setText(person.getName());
			jtfAddress.setText(person.getAddress());
			jtfPhone.setText(person.getPhone());
			jtfEmail.setText(person.getEmail());
		}		
	}

	public void updatePerson() {
		if(recordNumber >= 0 && recordNumber < peopleList.size()){
			//finding person in the list
			Person person = peopleList.get(recordNumber);
			int idPerson = person.getId();
			
			//get values from the textfields
			String name = jtfName.getText().toUpperCase().trim();
			String address = jtfAddress.getText().trim();
			String phone = jtfPhone.getText().trim();
			String email = jtfEmail.getText().trim();
			
			// updating data of the given person
			person = new Person(idPerson, name, phone, email, address);
			personDAO.updatePerson(person);
			
			JOptionPane.showMessageDialog(null, "Atualização realizada com sucesso.");
		} else
			JOptionPane.showMessageDialog(null, "Não há registro para alteração");
		
	}

	public void clearScreen() {
		jtfName.setText("");
		jtfAddress.setText("");
		jtfPhone.setText("");
		jtfEmail.setText("");
		
		/* Erasing the contents of the ArrayList */
		recordNumber = -1;
		//peopleList.clear();
		jbNext.setEnabled(true);
		jbPrevious.setEnabled(true);
	}

	//Person adds a in the list
	public void addPerson() {
		String namePerson = jtfName.getText().trim();
		namePerson = namePerson.toUpperCase();

		final String address = jtfAddress.getText().trim();
		/*
		 * se o telefone fosse INT 
		 * int phone = -1; 
		 * try { phone =
		 * 		Integer.parseInt("" + jtfPhone.getText().trim()); 
		 * } catch (Exception e) { 
		 * 		System.out.println("Erro save -->"+e.getMessage());
		 * 		System.out.print(e); 
		 * }
		 */
		String phone = jtfPhone.getText().trim();
		String email = jtfEmail.getText().trim();

		// o nome é obrigatorio no preechumento
		if (namePerson.trim().length() == 0) {
			JOptionPane.showMessageDialog(null,
					"Informe um nome para realizar a inclusão.");
		} else {
			//cria a pessoa com as informações passadas no form
			Person person = new Person(0, namePerson, phone, email, address);
			//chama a DAO para adicionar no Banco
			personDAO.addPerson(person);
			
			JOptionPane.showMessageDialog(null, "Registro incluído com sucesso");
		}

	}

	/*public static void main(String[] args) {
		new AgendaFrame();
	}*/

}
