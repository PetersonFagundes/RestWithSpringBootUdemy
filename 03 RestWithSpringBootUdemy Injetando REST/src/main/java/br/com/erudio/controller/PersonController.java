package br.com.erudio.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import br.com.erudio.exception.UnsuportedMathOperationException;
import br.com.erudio.math.SimpleMath;
import br.com.erudio.model.Person;
import br.com.erudio.request.converters.NumberConverter;
import br.com.erudio.services.PersonService;

@RestController
@RequestMapping("/person")
public class PersonController {
	
	//Usando o service no PersonService permite que não tenha necessidade
	//de instanciar a classe
	@Autowired //Equivalente a PersonService service = new PersonService()
	private PersonService services;
	
	@RequestMapping(method=RequestMethod.GET, 
			produces = MediaType.APPLICATION_JSON_VALUE)
	public List<Person> findAll()  {
		
		return services.findAll();
	}	
	
	//Especificando o método get com path variable para obrigar vir com valor
	@RequestMapping(value="/{id}", 
			method=RequestMethod.GET, 
			produces = MediaType.APPLICATION_JSON_VALUE)
	public Person findById(@PathVariable("id") String id)  {
						
		return services.findById(id);
	}
	
	@RequestMapping(method = RequestMethod.POST, 
			produces = MediaType.APPLICATION_JSON_VALUE,
			consumes = MediaType.APPLICATION_JSON_VALUE)
	public Person createPerson(@RequestBody Person person){
		return services.create(person);
	}
	
	@RequestMapping(method = RequestMethod.PUT, 
			produces = MediaType.APPLICATION_JSON_VALUE,
			consumes = MediaType.APPLICATION_JSON_VALUE)
	public Person updatePerson(@RequestBody Person person){
		return services.update(person);
	}
	
	@RequestMapping(value="/{id}", 
			method=RequestMethod.DELETE) 
	public void delete(@PathVariable("id") String id)  {
						
		services.delete(id);
	}
}
