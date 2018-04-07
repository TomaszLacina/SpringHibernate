package pl.coderslab.app.dao;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import pl.coderslab.app.entity.Book;

@Component
@Transactional
public class BookDao {
	
	@PersistenceContext
	EntityManager entityManager;
	
	public Book createBook(Book entity) {
		entityManager.persist(entity);
		
		return entity;
	}
	
	public Book updateBook(Book entity) {
		Book book = entityManager.merge(entity);
		
		return book;
	}
	
	public Book findById(Long id) {
		return entityManager.find(Book.class, id);
	}
	
	public void deleteById(Long id) {
		Book entity = entityManager.find(Book.class, id);
		entityManager.remove(entity);
	}
}
