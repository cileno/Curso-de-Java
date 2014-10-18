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
import javax.swing.JTextField;
import javax.swing.text.AbstractDocument.Content;

import br.com.agenda.model.dao.PhoneDAO;
import br.com.agenda.model.entity.Person;
import br.com.agenda.model.entity.Phone;

@SuppressWarnings("serial")
public class FormPhone extends JFrame implements ActionListener {
	private List<Phone> phonesOfThePerson;
	private PhoneDAO phoneDAO;
	private Person person;
	
	private int recordNumber;
	
	private Container cPanel;
	
	private JLabel jlType, jlDdi, jlDdd, jlNumber;
	private JTextField jtfType, jtfDdi, jtfDdd, jtfNumber;
	private JButton jbNew, jbSave, jbEdit, jbDelete, jbFirst, jbPrevious, jbNext, jbLast, jbExit;
	
	public FormPhone(Person person) {
		super("Número Telefônico");
		
		recordNumber = -1;
		
		createGui();
		
		phonesOfThePerson = new ArrayList<Phone>();
		phoneDAO = PhoneDAO.getPhoneDAO();
		
		this.person = person;
	}
	
	public void createGui() {
		cPanel = getContentPane();
		cPanel.setLayout(new GridBagLayout());
		
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		
		// colocando os compontes no painel
		arrangeComponents();
		
		setSize(540, 300);
		setResizable(false);
		setVisible(true);
		
	}

	private void arrangeComponents() {
		createComponents();
		localizeComponents();
		
	}

	private void createComponents() {
		/* JLabels */
		jlType = new JLabel("Tipo");
		//jlPais = new JLabel("Pais");
		jlDdi = new JLabel("DDI");
		//jlEstado = new JLabel("Estado");
		//jlCidade = new JLabel("Cidade");
		jlDdd = new JLabel("DDD");
		jlNumber = new JLabel("Número");
		
		/* Text Fields */
		jtfType = new JTextField(30);
		//jtfPais = new JTextField(20);
		jtfDdi = new JTextField(5);
		jtfDdd = new JTextField(5);
		jtfNumber = new JTextField(10);
		
		/* JButtons */
		jbNew = new JButton("Novo");
		jbSave = new JButton("Salvar");
		jbEdit = new JButton("Editar");
		jbDelete = new JButton("Excluir");
		jbFirst = new JButton("|<");
		jbPrevious = new JButton("<<");
		jbNext = new JButton(">>");
		jbLast = new JButton(">|");
		jbExit = new JButton("Sair");
		
	}

	private void localizeComponents() {
		GridBagConstraints gbcLabelType = new GridBagConstraints();
		gbcLabelType.gridx = 0;
		gbcLabelType.gridy = 0;
		gbcLabelType.insets = new Insets(5, 5, 5, 5);
		cPanel.add(jlType, gbcLabelType);
		
		GridBagConstraints gbcTextFieldType = new GridBagConstraints();
		gbcTextFieldType.gridx = 1;
		gbcTextFieldType.gridy = 0;
		gbcTextFieldType.insets = new Insets(5, 5, 5, 5);
		gbcTextFieldType.gridwidth = 2;
		gbcTextFieldType.fill = GridBagConstraints.BOTH;
		cPanel.add(jtfType, gbcTextFieldType);
		
		GridBagConstraints gbcLabelDdi = new GridBagConstraints();
		gbcLabelDdi.gridx = 0;
		gbcLabelDdi.gridy = 1;
		gbcLabelDdi.insets = new Insets(5, 5, 5, 5);
		cPanel.add(jlDdi, gbcLabelDdi);
		
		GridBagConstraints gbcTextFieldDdi = new GridBagConstraints();
		gbcTextFieldDdi.gridx = 1;
		gbcTextFieldDdi.gridy = 1;
		gbcTextFieldDdi.insets = new Insets(5, 5, 5, 5);
		gbcTextFieldDdi.gridwidth = 2;
		gbcTextFieldDdi.fill = GridBagConstraints.BOTH;
		cPanel.add(jtfDdi, gbcTextFieldDdi);

		GridBagConstraints gbcLabelDdd = new GridBagConstraints();
		gbcLabelDdd.gridx = 2;
		gbcLabelDdd.gridy = 1;
		gbcLabelDdd.insets = new Insets(5, 5, 5, 5);
		cPanel.add(jlDdd, gbcLabelDdd);
		
		GridBagConstraints gbcTextFieldDdd = new GridBagConstraints();
		gbcTextFieldDdd.gridx = 3;
		gbcTextFieldDdd.gridy = 1;
		gbcTextFieldDdd.insets = new Insets(5, 5, 5, 5);
		gbcTextFieldDdd.gridwidth = 2;
		gbcTextFieldDdd.fill = GridBagConstraints.BOTH;
		cPanel.add(jtfDdd, gbcTextFieldDdd);
		
		GridBagConstraints gbcLabelNumber = new GridBagConstraints();
		gbcLabelNumber.gridx = 0;
		gbcLabelNumber.gridy = 2;
		gbcLabelNumber.insets = new Insets(5, 5, 5, 5);
		cPanel.add(jlNumber, gbcLabelNumber);
		
		GridBagConstraints gbcTextFieldNumber = new GridBagConstraints();
		gbcTextFieldNumber.gridx = 1;
		gbcTextFieldNumber.gridy = 2;
		gbcTextFieldNumber.insets = new Insets(5, 5, 5, 5);
		gbcTextFieldNumber.gridwidth = 2;
		gbcTextFieldNumber.fill = GridBagConstraints.BOTH;
		cPanel.add(jtfNumber, gbcTextFieldNumber);

	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		
	}
	
	public static void main(String[] args) {
		new FormPhone(null);
	}

}
