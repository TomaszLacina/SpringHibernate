package pl.coderslab.app.dao;

import java.util.Collection;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Component;

import pl.coderslab.app.entity.Author;

@Component
public class AuthorDao {

	@PersistenceContext
	EntityManager entityManager;
	
	public Author create(Author author) {
		 entityManager.persist(author);
		 return author;
	}
	
	public Collection<Author> findAll(){
		return entityManager
				.createQuery("SELECT p FROM Author p")
				.getResultList();
	}

	public Author findById(long id) {
		
		return entityManager.find(Author.class, id);
	}
}
