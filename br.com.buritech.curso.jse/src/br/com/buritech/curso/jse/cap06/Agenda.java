package br.com.buritech.curso.jse.cap06;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

import javax.swing.JOptionPane;

public class Agenda {
	private ArrayList<Pessoa> contatos;

	private int totalAmigos;
	private int totalConhecidos;

	// constructor
	public Agenda(int limiteAgenda) {
		contatos = new ArrayList<Pessoa>();

		Pessoa p = null;
		this.totalAmigos = 0;
		this.totalConhecidos = 0;

		for (int x = 0; x < limiteAgenda; x++) {
			int sorteio = 1 + (int) (Math.random() * 2);

			if (sorteio == 1) {
				p = new Amigo();
				this.totalAmigos++;
			} else {
				p = new Conhecido();
				this.totalConhecidos++;
			}

			contatos.add(p);
		}
	}

	public ArrayList<Pessoa> getContatos() {
		return contatos;
	}

	public void setContatos(ArrayList<Pessoa> contatos) {
		this.contatos = contatos;
	}

	public int getTotalAmigos() {
		return totalAmigos;
	}

	public void setTotalAmigos(int totalAmigos) {
		this.totalAmigos = totalAmigos;
	}

	public int getTotalConhecidos() {
		return totalConhecidos;
	}

	public void setTotalConhecidos(int totalConhecidos) {
		this.totalConhecidos = totalConhecidos;
	}

	public void addInformacoes() {
		for (int indice = 0; indice < getContatos().size(); indice++) {
			Amigo amigo = null;
			Conhecido conhecido = null;

			String nome = JOptionPane
					.showInputDialog("Informe o nome do Contato");

			if (contatos.get(indice) instanceof Amigo) {
				amigo = (Amigo) contatos.get(indice);

				String strDataNascimento = JOptionPane
						.showInputDialog("Informe a data de nascimento do Contato");

				amigo.setDataAniversario(converterDataStringToDataCalendar(strDataNascimento));
				amigo.setIdade(calcularIdade(amigo.getDataAniversario()));
				amigo.setNome(nome);

				contatos.set(indice, amigo);
			}

			if (contatos.get(indice) instanceof Conhecido) {
				conhecido = (Conhecido) contatos.get(indice);

				int idade = Integer.parseInt(JOptionPane
						.showInputDialog("Informe a idade do Contato"));

				String email = JOptionPane
						.showInputDialog("Informe o e-mail do Contato");

				conhecido.setNome(nome);
				conhecido.setIdade(idade);
				conhecido.setEmail(email);
			}
		}
	}

	private Calendar converterDataStringToDataCalendar(String strDataNascimento) {
		SimpleDateFormat sdfDataNascimento = new SimpleDateFormat("dd/MM/yyyy");

		Date dtDataNascimento = null;

		Calendar calDataNascimento = new GregorianCalendar();

		try {
			dtDataNascimento = sdfDataNascimento.parse(strDataNascimento);
		} catch (ParseException e) {
			e.printStackTrace();
		}

		calDataNascimento.setTime(dtDataNascimento);

		return calDataNascimento;
	}

	private int calcularIdade(Calendar calDataNascimento) {
		Calendar dataAtual = Calendar.getInstance();

		// calculando a idade pelo ano
		int idade = dataAtual.get(Calendar.YEAR)
				- calDataNascimento.get(Calendar.YEAR);

		if (dataAtual.before(calDataNascimento))
			idade--;

		return idade;
	}

	public void imprimeAniversarios() {
		for (int indice = 0; indice < contatos.size(); indice++) {
			if (contatos.get(indice) instanceof Amigo) {
				Amigo amigo = (Amigo) contatos.get(indice);
				
				Date aniversario = mostrarAniversario(amigo.getDataAniversario()).getTime();
				
				System.out.println(amigo.getNome() + " Aniverário: " + aniversario);
			}
		}
	}

	public Calendar mostrarAniversario(Calendar dataNascimento) {
		Calendar dataAtual = Calendar.getInstance();

		if (dataAtual.get(Calendar.DAY_OF_MONTH) != dataNascimento
				.get(Calendar.DAY_OF_MONTH)) {
			dataAtual.set(dataAtual.get(Calendar.YEAR),
					dataNascimento.get(Calendar.DAY_OF_MONTH),
					dataNascimento.get(Calendar.DATE));
		}

		return dataAtual;
	}

	public void imprimeEmail() {
		for (int indice = 0; indice < contatos.size(); indice++) {
			if (contatos.get(indice) instanceof Conhecido) {
				Conhecido conhecido = (Conhecido) contatos.get(indice);
				System.out.println(conhecido.getNome() + " E-mail: "
						+ conhecido.getEmail());
			}
		}
	}
}
