package pl.coderslab.app.dao;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

import org.springframework.stereotype.Component;

import pl.coderslab.app.entity.Book;
import pl.coderslab.app.entity.Person;

@Component
@Transactional
public class PersonDao {
	
	@PersistenceContext
	EntityManager entityManager;
	
	public Person createPerson(Person entity) {
		entityManager.persist(entity);
		
		return entity;
	}
	
	public Person updatePerson(Person entity) {
		Person person = entityManager.merge(entity);
		
		return person;
	}
	
	public Person findById(Long id) {
		return entityManager.find(Person.class, id);
	}
	
	public void deleteById(Long id) {
		Person person = entityManager.find(Person.class, id);
		entityManager.remove(person);
	}
}
