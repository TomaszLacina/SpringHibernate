package pl.coderslab.app.dao;

import java.util.Collection;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

import org.springframework.stereotype.Component;

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
	
	
	/**
	 * w tym podejsciu do kasowania musimy sami sobie zadbać o to
	 * żeby relacje były usunięte "jak trzeba"
	 * 
	 * wazny jest tutuaj flush i clear
	 * 
	 * flush -> powoduje wykonianie zapytania do bazy daanych
	 * clear -> powoduje ze wszystkie obiekty pobrane z bazy danych
	 * 		które mamy juz pod reka, staje sie nie poprawne,
	 * 		co zapewnie nam ze pobranie z bazy danych zwroci nam
	 * 		nowy obiekt, a nie 
	 * 		
	 * 
	 * 
	 */
	public void deleteById(Long id) {
		Book book = entityManager.find(Book.class, id);
		book.getAuthors().clear();
		book.setPublisher(null); /*tutaj prosze o rozwagę gdyż mamy niby not-null
		 adnotacje na obiekcie, ale wczesniej w konfiguracji wylaczlismy walidacje,
		  temu tak mozemy sobie zrobić ;-) jak nie, to trzeba kombinować z 
		  grupami dostępu (nigdzie nie miec adnotacji walidacji z pustą grupa, 
		  wszedzie ustawic jakąś, inną niż default, i na kontrolerach walidowac
		   wedlug tej grupy, a na default zostawic zeby nic nie bylo wymagane);
		*/
		entityManager.merge(book);
		
		entityManager.flush();
		entityManager.clear();
		book = findById(id);
		System.out.println(book.getPublisher());
		System.out.println(book.getAuthors().size());
		entityManager.remove(book);
	}
	
	public Collection<Book> findAll(){
		return entityManager.createQuery("SELECT b FROM Book b").getResultList();
	}
}
