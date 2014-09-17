package br.com.buritech.curso.jse.cap13;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class TesteAnimalComparable {

	public static void main(String[] args) {
		List<Animal> listaDeAnimais = new ArrayList<Animal>();
		
		listaDeAnimais.add(new Animal(3,"Cavalo"));
		listaDeAnimais.add(new Animal(1,"Peixe"));
		listaDeAnimais.add(new Animal(2,"Leao"));
		
		System.out.println("Lista inicial");
		System.out.println(listaDeAnimais);
		//Collections.sort(listaDeAnimais);
		Collections.sort(listaDeAnimais, new NomeAnimalCaparator());
		System.out.println("Lista ordenada\n"+listaDeAnimais);
	}

}
