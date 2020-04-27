package br.com.erudio.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.erudio.data.model.Person;

//Definindo interface como repository
@Repository
public interface PersonRepository extends JpaRepository<Person, Long>{
	//Esta construção já provê o CRUD
}
