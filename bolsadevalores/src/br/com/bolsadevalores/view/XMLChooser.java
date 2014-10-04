package br.com.bolsadevalores.view;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.Collections;
import java.util.List;

import javax.swing.JFileChooser;
import javax.swing.filechooser.FileNameExtensionFilter;

import br.com.bolsadevalores.model.entidade.Negocio;
import br.com.bolsadevalores.xml.reader.XMLReader;

public class XMLChooser {
	//public void escolher() {
	
	//retorna uma coleção de negócios
	public List<Negocio> escolher() {
		try {
			//seleciona a pasta do projeto
			JFileChooser fileChooser = new JFileChooser(".");
			
			//selecionando um tipo de arquivo especifico
			fileChooser.setFileFilter(new FileNameExtensionFilter("Apenas XML", "xml"));

			int retorno = fileChooser.showOpenDialog(null);

			if (retorno == JFileChooser.APPROVE_OPTION) {
				// escolhendo o arquivo XML
				FileReader reader = new FileReader(fileChooser.getSelectedFile());

				// carregando a lista de negocios do arquivo XML lido
				List<Negocio> negocios = new XMLReader().carregar(reader);

				//retorna a lista processada
				return negocios;
				/*
					// carregando o primeiro negocio da lista
					Negocio primeiroNegocio = negocios.get(0);
	
					// enviando uma mensagem com o primeiro negocio da lista
					String msg = "Primeiro negócio do dia: "
							+ primeiroNegocio.getPreco();
					JOptionPane.showMessageDialog(null, msg);
				*/
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		
		//retorna uma lista genérica - é melhor do null
		return Collections.emptyList();
	}
	
	/*
	public static void main(String[] args) {
		new XMLChooser().escolher();
	}
	*/
}
