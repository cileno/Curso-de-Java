package cap08;

public class ControleSessao {
	private static int qtdeSessao;
	
	public void autenticar(int senha, Autenticavel usuario){
		if(usuario.autenticar(senha)){
			qtdeSessao++;
		}
	}
	
	public int getQtdeSessao() {
		return qtdeSessao;
	}
}
