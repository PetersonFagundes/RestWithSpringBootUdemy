package br.com.erudio.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.erudio.converter.DozerConverter;
import br.com.erudio.converter.custom.PersonConverter;
import br.com.erudio.data.model.Person;
import br.com.erudio.data.vo.PersonVO;
import br.com.erudio.data.vo.v2.PersonVOV2;
import br.com.erudio.exception.ResourceNotFoundException;
import br.com.erudio.repository.PersonRepository;

//Criando Classe de serviços criando inserção 

@Service
public class PersonService {
	
	@Autowired
	PersonRepository repository;
	
	@Autowired
	PersonConverter converter;
	
//-----------------------------POST----------------------------//
	public PersonVO create(PersonVO person) {
		Person entity = DozerConverter.parseObject(person, Person.class);
		PersonVO vo = DozerConverter.parseObject(repository.save(entity), PersonVO.class);
		return vo;
	}
	
	public PersonVOV2 createV2(PersonVOV2 person) {
		Person entity = converter.convertVOToEntity(person);
		PersonVOV2 vo = converter.convertEntityToVO(repository.save(entity));
		return vo;
	}
//-------------------------------------------------------------//
	
//-----------------------------PUT-----------------------------//
public PersonVO update(PersonVO person) {
	
	Person entity = repository.findById(person.getId())
			.orElseThrow(() -> new ResourceNotFoundException("Not records found for this ID"));
	
	entity.setFirstName(person.getFirstName());
	entity.setLastName(person.getLastName());
	entity.setAddress(person.getAddress());
	entity.setGender(person.getGender());
	
	PersonVO vo = DozerConverter.parseObject(repository.save(entity), PersonVO.class);
	
	return vo;
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
	public PersonVO findById(Long id) {
		Person entity = repository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Not records found for this ID"));
		return DozerConverter.parseObject(repository.save(entity), PersonVO.class); 
	}
	
	public List<PersonVO> findAll() {
		
		return DozerConverter.parseListObjects(repository.findAll(), PersonVO.class);	
	}
//------------------------------------------------------------------//	
}
