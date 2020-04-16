package br.com.erudio.services;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicLong;

import org.springframework.stereotype.Service;

import br.com.erudio.model.Person;

//Criando Classe de serviços criando inserção 

@Service
public class PersonService {
	
	//Simulando Id do BD
	private final AtomicLong counter = new AtomicLong();
	
//-----------------------------POST----------------------------//
	public Person create(Person person) {
		//Aqui vai a lógica do BD para persistir o valor no banco
		return person;
	}
//-------------------------------------------------------------//
	
//-----------------------------PUT-----------------------------//
public Person update(Person person) {
	//Aqui vai a lógica do BD para atualizar o valor no banco
	return person;
}
//-------------------------------------------------------------//
	
//----------------------------DELETE--------------------------//
public void delete(String id) {
	
}
//------------------------------------------------------------//
	
//-------------------------------GET---------------------------//
	//Mock Busca pelo Id
	public Person findById(String id) {
		
		Person person = new Person();
		person.setId(counter.incrementAndGet());
		person.setFirstName("Péterson");
		person.setLastName("Fagundes");
		person.setAddress("Itajubá - MG - Brasil");
		person.setGender("Male");
		return person;
	}
	
	public List<Person> findAll() {
		
		List<Person> persons = new ArrayList<Person>();
		
		for (int i = 0; i < 8; i++) {
			Person person = mockPerson(i);
			persons.add(person);
		}
		
		return persons ;
	}
//------------------------------------------------------------------//
	private Person mockPerson(int i) {
		
		Person person = new Person();
		person.setId(counter.incrementAndGet());
		person.setFirstName("Person name " + i);
		person.setLastName("Last Name "+i);
		person.setAddress("Some address in Brazil "+i);
		person.setGender("Male");
		return person;
	}
	
}
