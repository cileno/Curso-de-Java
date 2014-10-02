package br.com.bolsadevalores.xml.reader;
import java.io.Reader;
import java.util.List;

import com.thoughtworks.xstream.XStream;
import com.thoughtworks.xstream.io.xml.DomDriver;

import br.com.bolsadevalores.model.entidade.Negocio;

@SuppressWarnings("unchecked")
public class XMLReader {
	
	public List<Negocio> carregar(Reader fonte){
		//Definicao do objeto XStream
		XStream stream = new XStream(new DomDriver());
		//Atribuindo apelido a tag Negocio
		stream.alias("negocio", Negocio.class);
		//execucao do parse do XML
		return (List<Negocio>) stream.fromXML(fonte);
	}
}
