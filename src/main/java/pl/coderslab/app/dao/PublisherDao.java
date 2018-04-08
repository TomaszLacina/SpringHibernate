package pl.coderslab.app.dao;

import java.util.Collection;

import javax.management.Query;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

import org.springframework.stereotype.Component;

import pl.coderslab.app.entity.Publisher;

@Component
@Transactional
public class PublisherDao {
	
	@PersistenceContext
	EntityManager entityManager;
	
	public Publisher createPublisher(Publisher entity) {
		entityManager.persist(entity);
		
		return entity;
	}
	
	public Publisher updatePublisher(Publisher entity) {
		Publisher publisher = entityManager.merge(entity);
		
		return publisher;
	}
	
	public Publisher findById(Long id) {
		return entityManager.find(Publisher.class, id);
	}
	
	public void deleteById(Long id) {
		Publisher entity = entityManager.find(Publisher.class, id);
		entityManager.remove(entity);
	}

	public Collection<Publisher> findPublishers() {
		return entityManager
				.createQuery("SELECT p FROM Publisher p")
				.getResultList();
	}
}
