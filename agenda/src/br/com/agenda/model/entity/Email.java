package br.com.agenda.model.entity;

public class Email {
	private int id;
	private String address;
	private String type;
	
	private Person contact;

	public Email(int id, String address, String type, Person contact) {
		super();
		this.id = id;
		this.address = address;
		this.type = type;
		this.contact = contact;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
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
