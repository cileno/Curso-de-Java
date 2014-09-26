package br.com.bolsadevalores.model.entidade;

import java.util.Calendar;

public final class Candle {
	private final double abertura;
	private final double fechamento;
	private final double minimo;
	private final double maximo;
	private final double volume;
	private final Calendar date;
	
	//para gerar o construtor: crtl+3 + gcuf
	public Candle(double abertura, double fechamento, double minimo,
			double maximo, double volume, Calendar date) {
		this.abertura = abertura;
		this.fechamento = fechamento;
		this.minimo = minimo;
		this.maximo = maximo;
		this.volume = volume;
		this.date = date;
	}

	//para gerar os gets e sets: ctrl + 3 + ggas
	public double getAbertura() {
		return abertura;
	}

	public double getFechamento() {
		return fechamento;
	}

	public double getMinimo() {
		return minimo;
	}

	public double getMaximo() {
		return maximo;
	}

	public double getVolume() {
		return volume;
	}

	public Calendar getDate() {
		return date;
	}


}
