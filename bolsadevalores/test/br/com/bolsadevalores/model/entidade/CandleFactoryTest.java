package br.com.bolsadevalores.model.entidade;

import java.util.Arrays;
import java.util.Calendar;
import java.util.List;

import org.junit.Assert;
import org.junit.Test;

public class CandleFactoryTest {

	@Test
	public void deveRetornarCandle() {
		//fail("Not yet implemented");
		CandleFactory factory = new CandleFactory();
		Calendar data = Calendar.getInstance();
		Negocio negocio1 = new Negocio(40.5, 100,data);
		Negocio negocio2 = new Negocio(45.0, 100,data);
		Negocio negocio3 = new Negocio(39.8, 100,data);
		Negocio negocio4 = new Negocio(42.3, 100,data);
		
		List<Negocio> negocios = Arrays.asList(negocio1, negocio2, negocio3, negocio4);

		Candle candle = factory.constroiCandlePorData(data, negocios);
		
		Assert.assertEquals(40.5, candle.getAbertura(), 0.00001);
		Assert.assertEquals(42.3, candle.getFechamento(), 0.00001);
		Assert.assertEquals(39.8, candle.getMinimo(), 0.00001);
		Assert.assertEquals(45.0, candle.getMaximo(), 0.00001);
		Assert.assertEquals(16760.0, candle.getVolume(), 0.00001);
	}

	@Test
	public void deveRetornarCandleVaziaQuandoNaoHaNegocio(){
		CandleFactory factory = new CandleFactory();
		Calendar data = Calendar.getInstance();
		
		List<Negocio> negocios = Arrays.asList();

		Candle candle = factory.constroiCandlePorData(data, negocios);
		
		Assert.assertEquals(0.0, candle.getVolume(), 0.00001);
		
	}

	@Test
	public void deveRetornarCandleComApenasUmNegocio() {
		//fail("Not yet implemented");
		CandleFactory factory = new CandleFactory();
		Calendar data = Calendar.getInstance();
		Negocio negocio1 = new Negocio(40.5, 100, data);
		
		List<Negocio> negocios = Arrays.asList(negocio1);

		Candle candle = factory.constroiCandlePorData(data, negocios);
		
		Assert.assertEquals(40.5, candle.getAbertura(), 0.00001);
		Assert.assertEquals(40.5, candle.getFechamento(), 0.00001);
		Assert.assertEquals(40.5, candle.getMinimo(), 0.00001);
		Assert.assertEquals(40.5, candle.getMaximo(), 0.00001);
		Assert.assertEquals(4050.0, candle.getVolume(), 0.00001);
	}
}
