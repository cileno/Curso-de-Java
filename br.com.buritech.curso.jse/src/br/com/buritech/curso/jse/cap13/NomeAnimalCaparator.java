package br.com.buritech.curso.jse.cap13;

import java.util.Comparator;

public class NomeAnimalCaparator implements Comparator<Animal> {

	@Override
	public int compare(Animal animal1, Animal animal2) {
		//Delegando atividade para String.comparatorTo()
		return animal1.getNome().compareTo(animal2.getNome());
	}

}
