package br.com.erudio.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.erudio.exception.ResourceNotFoundException;
import br.com.erudio.model.Person;
import br.com.erudio.repository.PersonRepository;

//Criando Classe de serviços criando inserção 

@Service
public class PersonService {
	
	@Autowired
	PersonRepository repository;
	
//-----------------------------POST----------------------------//
	public Person create(Person person) {
		//Spring Data provê chamdas simples para CRUD
		return repository.save(person);
	}
//-------------------------------------------------------------//
	
//-----------------------------PUT-----------------------------//
public Person update(Person person) {
	
	Person entity = repository.findById(person.getId())
			.orElseThrow(() -> new ResourceNotFoundException("Not records found for this ID"));
	
	entity.setFirstName(person.getFirstName());
	entity.setLastName(person.getLastName());
	entity.setAddress(person.getAddress());
	entity.setGender(person.getGender());
	
	return repository.save(entity);
}
//-------------------------------------------------------------//
	
//----------------------------DELETE--------------------------//
public void delete(Long id) {
	Person entity = repository.findById(id)
			.orElseThrow(() -> new ResourceNotFoundException("Not records found for this ID"));
	
	repository.delete(entity);
}
//------------------------------------------------------------//
	
//-------------------------------GET---------------------------//
	//Mock Busca pelo Id
	public Person findById(Long id) {
		return repository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Not records found for this ID"));
	}
	
	public List<Person> findAll() {
		return repository.findAll();	
	}
//------------------------------------------------------------------//	
}
