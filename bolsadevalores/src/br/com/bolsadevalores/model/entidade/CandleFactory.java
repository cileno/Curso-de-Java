package br.com.bolsadevalores.model.entidade;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

public class CandleFactory {
	public Candle constroiCandlePorData(Calendar data, List<Negocio> negocios) {
		/*
		 * Utilizado para introdução do assunto - cap01 de TDD double maximo =
		 * negocios.get(0).getPreco(); double minimo =
		 * negocios.get(0).getPreco(); double volume = 0; double abertura =
		 * negocios.get(0).getPreco(); double fechamento =
		 * negocios.get(negocios.size() - 1).getPreco();
		 */

		// Definição de um valor muito pequeno
		double maximo = Double.MIN_VALUE;
		// minimo com um valor muito grande
		double minimo = Double.MAX_VALUE;
		// Verificando o valor inicial de abertura e fechamento
		double abertura = negocios.isEmpty() ? 0 : negocios.get(0).getPreco();
		double fechamento = negocios.isEmpty() ? 0 : negocios.get(
				negocios.size() - 1).getPreco();
		double volume = 0;

		// digigite foreach
		for (Negocio negocio : negocios) {
			volume += negocio.getVolume();

			if (negocio.getPreco() > maximo) {
				maximo = negocio.getPreco();
			}

			if (negocio.getPreco() < minimo) {
				minimo = negocio.getPreco();
			}
		}

		return new Candle(abertura, fechamento, minimo, maximo, volume, data);
	}

	public boolean isMesmoDia(Calendar data1, Calendar data2) {
		// return data1.equals(data2);
		return data1.get(Calendar.DAY_OF_MONTH) == data2
				.get(Calendar.DAY_OF_MONTH)
				&& data1.get(Calendar.MONTH) == data2.get(Calendar.MONTH)
				&& data1.get(Calendar.YEAR) == data2.get(Calendar.YEAR);
	}

	public List<Candle> constroiCandles(List<Negocio> negocios) {
		List<Candle> candles = new ArrayList<Candle>();

		// lista de negocios com a mesma data
		List<Negocio> negociosMesmoDia = new ArrayList<Negocio>();

		// obtendo a data do primeiro negocio da lista passada por parametro
		Calendar dataPrimeiro = negocios.get(0).getData();

		for (Negocio negocio : negocios) {
			// se nao for no mesmo dia, fecha a candle e reinicia as variáveis
			if (!isMesmoDia(dataPrimeiro, negocio.getData())) {
				candles.add(constroiCandlePorData(dataPrimeiro, negociosMesmoDia));
				
				//nova coleção de negocios
				negociosMesmoDia = new ArrayList<Negocio>();
				
				//nova data
				dataPrimeiro = negocio.getData();
			}
			
			//Adiciona um negocio a lista de negocios do mesmo dia
			negociosMesmoDia.add(negocio);
		}
		
		//adiciona ultimo candle
		candles.add(constroiCandlePorData(dataPrimeiro, negociosMesmoDia));
		
		return candles;
	}
}
