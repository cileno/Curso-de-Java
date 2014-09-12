package br.com.buritech.curso.jse.cap06;

import java.util.Calendar;

public class Amigo extends Pessoa {
	private Calendar dataAniversario;

	public Amigo() {
		super();
		
		this.dataAniversario = Calendar.getInstance() ;
	}

	public Calendar getDataAniversario() {
		return dataAniversario;
	}

	public void setDataAniversario(Calendar dataAniversario) {
		this.dataAniversario = dataAniversario;
	}
	
	
}
