package cap09;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class Formulario2 implements ActionListener {
	private JLabel jlbNome;
	private JTextField jtfNome;
	private JButton jbtExibir;
	private JPanel painel;
	private JFrame frame;
	
	public static void main(String[] args) {
		Formulario2 form = new Formulario2();
		
		form.montarFormulario();
	}

	private void montarFormulario() {
		jlbNome = new JLabel("Nome:");
		jtfNome = new JTextField(30);
		
		jbtExibir = new JButton("Exibir");
		jbtExibir.addActionListener(this);
		
		painel = new JPanel();
		painel.add(jlbNome);
		painel.add(jtfNome);
		painel.add(jbtExibir);
		
		frame = new JFrame("Novo Formulário");
		frame.add(painel);
		frame.pack();
		frame.setVisible(true);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
	
	public void actionPerformed(ActionEvent e){
		String texto = jtfNome.getText();
		JOptionPane.showMessageDialog(frame, texto);
	}
}
