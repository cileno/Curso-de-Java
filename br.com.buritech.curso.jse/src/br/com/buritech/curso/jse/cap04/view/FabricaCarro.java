package br.com.buritech.curso.jse.cap04.view;

import java.util.ArrayList;
import java.util.List;

import br.com.buritech.curso.jse.cap04.Carro;
import br.com.buritech.curso.jse.cap04.Motor;
import br.com.buritech.curso.jse.utils.ShowIO;

public class FabricaCarro {
	public static void main(String[] args) {
		FabricaCarro fabrica = new FabricaCarro();
		
		List<Carro> carros = new ArrayList<Carro>();

		int producao = ShowIO.strToInt("Informe a quantidade de carros a ser produzida");
		
		for (int ind = 0; ind < producao; ind++) {
			Carro car;

			car = fabrica.construirCarro();
			car.setMotor(fabrica.construirMotor());
			
			carros.add(car);
		}
		
		String resultado = "";
		for(Carro car : carros){
			resultado += ("Modelo:"+car.getModelo()+"\nCor:"+car.getCor()+"\n"
					+"Motor:"+car.getMotor().getTipo()+"\nPotencia:"
					+car.getMotor().getPotencia()+"\nVelociadade Maxima:"
					+car.getVelocidadeMaxima()+"\n\n");
		}
		ShowIO.showMensage(resultado);
	}

	private Motor construirMotor() {
		int potencia = ShowIO.strToInt("Informe a Potencia do Motor");
		String tipoMotor = ShowIO.input("Informe o Tipo do Motor");
		
		return (new Motor(potencia, tipoMotor));
	}

	private Carro construirCarro() {
		String cor = ShowIO.input("Informe a Cor do Carro");
		String modelo = ShowIO.input("Informe o Modelo do Carro");
		double velocidadeMaxima = ShowIO.strToDouble("Informe a Velocidade Maxima do Carro");
		
		return (new Carro(cor, modelo, velocidadeMaxima));
	}
}
