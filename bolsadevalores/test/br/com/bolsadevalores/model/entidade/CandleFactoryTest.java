package br.com.bolsadevalores.model.entidade;

import java.util.Arrays;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.List;

import org.junit.Assert;
import org.junit.Test;

public class CandleFactoryTest {

	@Test
	public void deveRetornarCandle() {
		//fail("Not yet implemented");
		CandleFactory factory = new CandleFactory();
		Calendar data = Calendar.getInstance();
		Negocio negocio1 = new Negocio(40.5, 100, data);
		Negocio negocio2 = new Negocio(45.0, 100, data);
		Negocio negocio3 = new Negocio(39.8, 100, data);
		Negocio negocio4 = new Negocio(42.3, 100, data);
		
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
	
	@Test
	public void testComparaMesmoDiaCalendar(){
		CandleFactory factory = new CandleFactory();
		
		Calendar data1 = Calendar.getInstance();
		Calendar data2 = Calendar.getInstance();
		
		Calendar data3 = new GregorianCalendar(2012, 12, 25, 8, 30);
		Calendar data4 = new GregorianCalendar(2012, 12, 25, 10, 30);
		
		Assert.assertTrue(factory.isMesmoDia(data1,data2));
		Assert.assertTrue(factory.isMesmoDia(data3,data4));
	}
	
	@Test
	public void testConstruirCandlesDeMuitosNegocios(){
		//Definicao de objetos
		Calendar hoje = Calendar.getInstance();
		Negocio negocio1 = new Negocio(40.5, 100, hoje);
		Negocio negocio2 = new Negocio(45.0, 100, hoje);
		
		Calendar amanha = (Calendar) hoje.clone();
		amanha.add(Calendar.DAY_OF_MONTH, 1);
		Negocio negocio3 = new Negocio(48.8, 100, amanha);
		Negocio negocio4 = new Negocio(49.3, 100, amanha);
		
		Calendar depoisDeAmanha = (Calendar) amanha.clone();
		depoisDeAmanha.add(Calendar.DAY_OF_MONTH, 1);
		Negocio negocio5 = new Negocio(51.8, 100, depoisDeAmanha);
		Negocio negocio6 = new Negocio(52.3, 100, depoisDeAmanha);
		
		//Colocando os negocios realizados em uma lista
		List<Negocio> negocios = Arrays.asList(negocio1, negocio2, negocio3, negocio4, negocio5, negocio6);
		
		//criando a factory
		CandleFactory fabrica = new CandleFactory();
		
		//Criando a lista de negocios de Candles
		List<Candle> candles = fabrica.constroiCandles(negocios);
		
		//realizando os tests
		Assert.assertEquals(3, candles.size());
		Assert.assertEquals(40.5, candles.get(0).getAbertura(), 0.00001);
		Assert.assertEquals(45.0, candles.get(0).getFechamento(), 0.00001);
		Assert.assertEquals(48.8, candles.get(1).getAbertura(), 0.00001);
		Assert.assertEquals(49.3, candles.get(1).getFechamento(), 0.00001);
		Assert.assertEquals(51.8, candles.get(2).getAbertura(), 0.00001);
		Assert.assertEquals(52.3, candles.get(2).getFechamento(), 0.00001);
	}
}
