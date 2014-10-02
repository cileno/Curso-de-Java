package br.com.bolsadevalores.xml.reader;
import java.util.Calendar;

import com.thoughtworks.xstream.XStream;
import com.thoughtworks.xstream.io.xml.DomDriver;

import br.com.bolsadevalores.model.entidade.Negocio;


public class XMLWriter {
	public static void main(String[] args) {
		//definição do objeto de negocio
		Negocio negocio = new Negocio(45.50, 50, Calendar.getInstance());
		
		//definição do objeto de escrita
		XStream stream = new XStream(new DomDriver());
		
		stream.alias("negocio", Negocio.class);
		
		//Execução do método toXML()
		System.out.println(stream.toXML(negocio));
	}
}
