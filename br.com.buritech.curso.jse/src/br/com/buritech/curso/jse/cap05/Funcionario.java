package br.com.buritech.curso.jse.cap05;

public class Funcionario {
	private String nome;
	private int matricula;
	private String departamento;
	
	private static int identificador;
	
	public Funcionario(int matricula, String departamento) {
		this.matricula = matricula;
		this.departamento = departamento;
		
		Funcionario.identificador++;
	}
	
	public static int getIdentificador() {
		return identificador;
	}

	public String getNome() {
		return nome;
	}
	
	public void setNome(String nome) {
		this.nome = nome;
	}
	
	public int getMatricula() {
		return matricula;
	}
	
	public void setMatricula(int matricula) {
		this.matricula = matricula;
	}
	
	public String getDepartamento() {
		return departamento;
	}
	
	public void setDepartamento(String departamento) {
		this.departamento = departamento;
	}
}
