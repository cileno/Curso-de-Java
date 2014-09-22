package cap09;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class PrimeiroFormulario {
	private JLabel label;
	private JTextField textField;
	private JPanel panel;
	private JFrame frame;
	
	public static void main(String[] args) {
		PrimeiroFormulario form = new PrimeiroFormulario();
		
		form.montarFormulario();
	}

	private void montarFormulario() {
		//criando os campos
		label = new JLabel("Seu nome:");
		textField = new JTextField(20);
		//associando os campos a um painel
		panel = new JPanel();
		panel.add(label);
		panel.add(textField);
		//colocando o painel a um frame
		frame = new JFrame("Meu primeiro formulário");
		frame.add(panel);
		//preparando o frame para exibição
		frame.pack(); //redimensiona
		frame.setVisible(true);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
}
