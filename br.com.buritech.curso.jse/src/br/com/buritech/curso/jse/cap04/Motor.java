package br.com.buritech.curso.jse.cap04;

public class Motor {
	private int potencia;
	private String tipo;
	
	public Motor(int potencia, String tipo) {
		this.potencia = potencia;
		this.tipo = tipo;
	}

	public int getPotencia() {
		return potencia;
	}
	
	public void setPotencia(int potencia) {
		this.potencia = potencia;
	}
	
	public String getTipo() {
		return tipo;
	}
	
	public void setTipo(String tipo) {
		this.tipo = tipo;
	}
}
