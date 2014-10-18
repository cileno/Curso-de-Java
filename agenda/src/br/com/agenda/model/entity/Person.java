package br.com.agenda.model.entity;


public class Person{
	private int id;
	private String name;
	//private List<Phone> phones;
	private String phone;
	//private List<Email> emails;
	private String email;
	//private Address address;
	private String address;
	
	//public Person(int id, String name, List<Phone> phones, List<Email> emails, Address address) {
	public Person(int id, String name, String phone, String email, String address) {
		super();
		this.id = id;
		this.name = name;
//		this.phones = phones;
//		this.emails = emails;
//		this.address = address;
		this.address = address;
		this.phone = phone;
		this.email = email;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

//	public List<Phone> getPhones() {
//		return phones;
//	}
	public String getPhone() {
		return phone;
	}

//	public void setPhones(List<Phone> phones) {
//		this.phones = phones;
//	}
	public void setPhone(String phone) {
		this.phone = phone;
	}

//	public List<Email> getEmails() {
//		return emails;
//	}
//
//	public void setEmails(List<Email> emails) {
//		this.emails = emails;
//	}
	public String getEmail() {
		return email;
	}
	
	public void setEmail(String email) {
		this.email = email;
	}

//	public Address getAddress() {
//		return address;
//	}
//
//	public void setAddress(Address address) {
//		this.address = address;
//	}
	public String getAddress() {
		return address;
	}
	
	public void setAddress(String address) {
		this.address = address;
	}
}
