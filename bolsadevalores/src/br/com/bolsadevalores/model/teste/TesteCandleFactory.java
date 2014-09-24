package br.com.bolsadevalores.model.teste;

import java.text.DateFormat;
import java.util.Arrays;
import java.util.Calendar;
import java.util.List;

import br.com.bolsadevalores.model.entidade.Candle;
import br.com.bolsadevalores.model.entidade.CandleFactory;
import br.com.bolsadevalores.model.entidade.Negocio;

public class TesteCandleFactory {

	public static void main(String[] args) {
		Calendar hoje = Calendar.getInstance();
		
		DateFormat dtHoje = DateFormat.getDateInstance(DateFormat.MEDIUM);
		
		//definição dos objetos de negócio
		Negocio negocio1 = new Negocio(40.5, 100, hoje);
		Negocio negocio2 = new Negocio(45.0, 100, hoje);
		Negocio negocio3 = new Negocio(39.8, 100, hoje);
		Negocio negocio4 = new Negocio(42.3, 100, hoje);
		
		//Montagem da lista de negócios
		List<Negocio> lista = Arrays.asList(negocio1, negocio2, negocio3, negocio4);
		
		//definição da fabrica de candles
		CandleFactory fabrica = new CandleFactory();
		
		//Criação do objeto Candle
		Candle candle = fabrica.constroiCandlePorData(hoje, lista);
		
		System.out.println("Data da Negocição: "+dtHoje.format(candle.getDate().getTime()));
		System.out.println("Abertura: "+candle.getAbertura());
		System.out.println("Fechamento: "+candle.getFechamento());
		System.out.println("Minimo: "+candle.getMinimo());
		System.out.println("Máximo: "+candle.getMaximo());
		System.out.println("Volume: "+candle.getVolume());
	}

}
