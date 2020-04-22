package br.com.erudio.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.erudio.model.Person;
import br.com.erudio.services.PersonService;

@RestController
@RequestMapping("/person")
public class PersonController {
	
	//Usando o service no PersonService permite que não tenha necessidade
	//de instanciar a classe
	@Autowired //Equivalente a PersonService service = new PersonService()
	private PersonService services;
	
	//@RequestMapping(method=RequestMethod.GET) = @GetMapping
	@GetMapping
	public List<Person> findAll()  {
		
		return services.findAll();
	}	
	
	//Especificando o método get com path variable para obrigar vir com valor
	@GetMapping(value = "/{id}")
	public Person findById(@PathVariable("id") Long id)  {
						
		return services.findById(id);
	}
	
	//@RequestMapping(method = RequestMethod.POST) = @PostMapping
	@PostMapping
	public Person createPerson(@RequestBody Person person){
		return services.create(person);
	}
	
	//@RequestMapping(method = RequestMethod.PUT) = @PutMapping
	@PutMapping
	public Person updatePerson(@RequestBody Person person){
		return services.update(person);
	}
	
	//@RequestMapping(value="/{id}", method=RequestMethod.DELETE) = @DeleteMapping
	@DeleteMapping(value = "/{id}")
	public ResponseEntity<?> delete(@PathVariable("id") Long id)  {
						
		services.delete(id);
		return ResponseEntity.ok().build();
	}
}
