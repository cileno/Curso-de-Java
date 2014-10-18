package br.com.agenda.model.dao;

import java.util.ArrayList;
import java.util.List;

import br.com.agenda.model.entity.Phone;

public class PhoneDAO {
	private static List<Phone> phonesListDAO;

	private static PhoneDAO instance;
	private static int constID = 0;

	// metodo construtor privado: só há acesso pelo método getPhoneDAO
	private PhoneDAO() {
		phonesListDAO = new ArrayList<Phone>();
	}

	// retorna a instância corrente
	public static PhoneDAO getPhoneDAO() {
		if (instance == null) {
			instance = new PhoneDAO();
		}
		return instance;
	}

	// adicionando um telefone na lista
	public void savePhone(Phone phone) {
		if (phonesListDAO == null) {
			System.out.println("lista vazia");

			phonesListDAO = new ArrayList<Phone>();
		}

		phone.setId(new Integer(++constID));

		phonesListDAO.add(phone);

		System.out.println("Adicionou o telefone de ID No.: " + phone.getId());
	}

	// retornando toda lista de telefones
	public List<Phone> searchingAllPhone() {
		System.out
				.println("Retornando " + phonesListDAO.size() + " telefones.");

		return phonesListDAO;
	}

	// encontrando telefone de acordo com um numero fornecido
	public List<Phone> searchPhone(String personName) {
		List<Phone> phonesTheOfPerson = new ArrayList<Phone>();

		if (phonesListDAO != null) {
			for (Phone phone : phonesListDAO) {
				if (phone.getContact().getName().contains(personName)) {
					System.out.println("Encontrou o telefone de : "
							+ phone.getContact().getName());

					phonesTheOfPerson.add(phone);
				}
			}
		}

		return phonesTheOfPerson;
	}

	// atualizando um telefone
	public void updatePhone(Phone phone) {
		if (phonesListDAO != null) {
			for (Phone telefone : phonesListDAO) {
				if (telefone.getId() == phone.getId()) {
					telefone.setDdd(phone.getDdd());
					telefone.setNumber(phone.getNumber());
					telefone.setType(phone.getType());
					telefone.setContact(phone.getContact());

					break;
				}
			}
		}

	}

	// removendo um telefone da lista
	public int removePhone(int phoneNumber) {
		if (phonesListDAO != null) {
			for (Phone phone : phonesListDAO) {
				System.out.println("Phone <" + phoneNumber + "> for phone <"
						+ phone.getNumber() + ">");

				if (phone.getNumber() == phoneNumber) {
					phonesListDAO.remove(phone);

					return 1;
				}
			}
		}

		return 0;
	}
}
