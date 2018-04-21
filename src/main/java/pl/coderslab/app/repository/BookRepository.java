package pl.coderslab.app.repository;

import java.util.List;
import java.util.Set;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import pl.coderslab.app.entity.Author;
import pl.coderslab.app.entity.Book;
import pl.coderslab.app.entity.Publisher;

public interface BookRepository extends JpaRepository<Book, Long>{

	List<Book> findByTitleIgnoreCase(String title);
	List<Book> findByPublisher(Publisher publisher);
	List<Book> findByPublisherId(Long publisherId);
	List<Book> findDistinctByAuthorsIn(Set<Author> authors);
	
	
	
	
	
	
	
	
	
	

	@Query("select b from Book b where b.title = :title")
	List<Book> szukajDziadu(@Param("title")String title);
	
	@Query("select b from Book b where b.publisher.id = :publisherId")
	List<Book> szukajPoPublisherze(@Param("publisherId")Long publisherId);
	
	@Query("select b from Book b where b.publisher = :publisher")
	List<Book> szukajPoPublisherze2(@Param("publisher")Publisher publisher);

}
