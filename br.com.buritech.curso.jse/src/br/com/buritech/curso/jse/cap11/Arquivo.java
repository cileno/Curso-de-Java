package br.com.buritech.curso.jse.cap11;

public class Arquivo {
	private Object[] objetos = new Object[10];
	
	private int pos;
	
	public void add(Object o){
		objetos[pos++] = 0;
	}
	
	public Object getObjetos(int i) {
		return objetos[i];
	}
}
