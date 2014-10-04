package br.com.bolsadevalores.view;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.SwingConstants;
import javax.swing.border.LineBorder;

import br.com.bolsadevalores.model.entidade.Negocio;

public class TelaPrincipal {
	//definindo os atributos da janela
	private JFrame jfJanela;
	private JPanel jpPainel;
	private JLabel jlTitulo;
	private JTable jtTabela;
	private JScrollPane jspScroll;
	private JButton jbBotaoCarregar;
	private JButton jbBotaoSair;
	
	public static void main(String[] args) {
		TelaPrincipal tela = new TelaPrincipal();
		
		tela.criarTela();
	}

	private void criarTela() {
		criarJanela();
		criarPainel();
		
		criarTitulo();
		
		criarTabelaComScroll();
		
		montarBotaoCarregar();
		montarBotaoSair();
		
		mostrarJanela();
	}

	private void criarTitulo() {
		jlTitulo = new JLabel("Lista de Negócios");
		
		jlTitulo.setFont(new Font("Verdana", Font.BOLD, 25));
		jlTitulo.setForeground(new Color(50, 50, 100));
		jlTitulo.setHorizontalAlignment(SwingConstants.CENTER);
		
		jpPainel.add(jlTitulo);
		
	}

	public void mostrarJanela() {
		//Ajustando o tamanho do form aos componentes
		jfJanela.pack();
		
		//definindo o tamanho do form
		jfJanela.setSize(540, 540);
		
		//exibindo o form
		jfJanela.setVisible(true);
	}

	private void criarJanela() {
		//titulo da janela
		jfJanela = new JFrame("Bolsa de Valores");
		
		//padrão de saída da janela
		jfJanela.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);		
	}

	private void criarPainel() {
		jpPainel = new JPanel();
		
		//Adicionando a tabela ao painel
		//jpPainel.add(montarTabelaComScroll());
				
		//adicionando os botões ao painel
		//jpPainel.add(montarBotaoCarregar());
		//jpPainel.add(montarBotaoSair());
		//adicionando o painel à janela
		jfJanela.add(jpPainel);
	}

	private void criarTabelaComScroll() {
		//configurando a tabela
		jtTabela = new JTable();
		
		jtTabela.setBorder(new LineBorder(Color.black));
		jtTabela.setGridColor(Color.black);
		jtTabela.setShowGrid(true);
		
		//configurando a barra de rolagem
		jspScroll = new JScrollPane();
		jspScroll.getViewport().setBorder(null);
		jspScroll.getViewport().add(jtTabela);
		jspScroll.setSize(500, 500);
		
		//adicionando o scroll ao painel
		jpPainel.add(jspScroll);
		
		//return jtTabela;
	}

	private void montarBotaoCarregar() {
		jbBotaoCarregar = new JButton("Carregar XML");
		
		//definindo o evento 
		jbBotaoCarregar.addActionListener(new ActionListener() {			
			@Override
			public void actionPerformed(ActionEvent e) {
				List<Negocio> negocios = new XMLChooser().escolher();
				
				NegociosTableModel model = new NegociosTableModel(negocios);
				
				jtTabela.setModel(model);
			}
		});
		
		jpPainel.add(jbBotaoCarregar);
	}

	private void montarBotaoSair() {
		jbBotaoSair = new JButton("Sair");
		
		jbBotaoSair.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				System.exit(0);
				
			}
		});
		
		jpPainel.add(jbBotaoSair);
	}
}
