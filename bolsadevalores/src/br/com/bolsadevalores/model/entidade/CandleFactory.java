package br.com.bolsadevalores.model.entidade;

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
}
