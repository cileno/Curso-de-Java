package br.com.bolsadevalores.xml.test;

import java.io.StringReader;
import java.util.List;

import org.junit.Assert;
import org.junit.Test;

import br.com.bolsadevalores.model.entidade.Negocio;
import br.com.bolsadevalores.xml.reader.XMLReader;

public class XMLReaderTest {

	@Test
	public void testLeitorXML() {
		String xml = "<list>"
				+ "	<negocio>"
				+ "		<preco>43.5</preco>"
				+ "		<quantidade>1000</quantidade>"
				+ "		<data>"
				+ "			<time>555454646</time>"
				+ "		</data>"
				+ "	</negocio>"
				+ "</list>";
		XMLReader reader = new XMLReader();
		
		List<Negocio> lista = reader.carregar(new StringReader(xml));
		
		Assert.assertEquals(1, lista.size());
		Assert.assertEquals(43.5, lista.get(0).getPreco(), 0.00001);
		Assert.assertEquals(1000, lista.get(0).getQuantidade());
	}

}
