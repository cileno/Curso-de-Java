package br.com.agenda.model.dao;

import java.util.ArrayList;
import java.util.List;

import br.com.agenda.model.entity.Person;

public class PersonDAO {
	private static List<Person> people;
	
	private static PersonDAO instance;
	private static int constID = 0;
	
	private PersonDAO() {
		people = new ArrayList<Person>();
	}
	
	public static PersonDAO getPersonDAO(){
		if (instance == null){
			instance = new PersonDAO();
		}	
		return instance;
	}
	
	//adicionando uma pessoa na lista
	public void addPerson(Person person){
		if(people == null){
			System.out.println("lista vazia");
			
			people = new ArrayList<Person>();
		}
		
		person.setId(new Integer(++constID));
		
		people.add(person);
		
		System.out.println("Adicionou: "+person.getId());
	}
	
	//retornando toda lista de contatos
	public List<Person> searchingAllPeople(){
		return people;
	}
	
	//encontrando pessoa que contenham um nome fornecido
	public List<Person> searchPerson(String name){
		List<Person> listPersons = new ArrayList<Person>();
		
		if(people != null){
			for (Person person : people) {
				if(person.getName().contains(name)){
					System.out.println("Encontrou: "+ person.getName());
					
					listPersons.add(person);
				}
			}
		}
		
		return listPersons;
	}

	//atualizando uma pessoa
	public void updatePerson(Person person) {
		if(people != null){
			for (Person pessoa : people) {
				if(pessoa.getId() == person.getId()){
					pessoa.setName(person.getName());
					pessoa.setPhone(person.getPhone());
					pessoa.setEmail(person.getEmail());
					pessoa.setAddress(person.getAddress());
					
					break;
				}
			}
		}
		
	}
	
	//removendo uma pessoa da lista
	public int removePerson(String name){
		if(people != null){
			for (Person person : people) {
				System.out.println("nome <" + name + "> for nome <"+ person.getName() + ">");
				
				if(person.getName().equals(name)){
					people.remove(person);
					
					return 1;
				}
			}
		}
		
		return 0;
	}
}
