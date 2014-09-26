package br.com.bolsadevalores.model.entidade;

import java.util.Calendar;

import org.junit.Assert;
import org.junit.Test;

public class NegocioTest {

	@Test
	public void testDataDoNegocioEhImutavel() {
		Calendar data = Calendar.getInstance();
		
		data.set(Calendar.DAY_OF_MONTH, 15);
		
		Negocio business = new Negocio(10, 5, data);
		
		business.getData().set(Calendar.DAY_OF_MONTH, 20);
		
		Assert.assertEquals(15, business.getData().get(Calendar.DAY_OF_MONTH));
	}
	
	

}
