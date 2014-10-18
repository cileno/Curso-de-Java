package br.com.agenda.model.entity;

public class Phone {
	private int id;
	private int ddd;
	private int number;
	private String type;
	
	private Person contact;
	
	public Phone(int id, int ddd, int number, String type, Person contact) {
		super();
		this.id = id;
		this.ddd = ddd;
		this.number = number;
		this.type = type;
		
		this.contact = contact;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getDdd() {
		return ddd;
	}

	public void setDdd(int ddd) {
		this.ddd = ddd;
	}

	public int getNumber() {
		return number;
	}

	public void setNumber(int number) {
		this.number = number;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}
	
	public Person getContact() {
		return contact;
	}
	
	public void setContact(Person contact) {
		this.contact = contact;
	}
}
