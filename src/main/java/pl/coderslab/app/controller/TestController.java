package pl.coderslab.app.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import pl.coderslab.app.dao.BookDao;
import pl.coderslab.app.dao.PublisherDao;
import pl.coderslab.app.entity.Author;
import pl.coderslab.app.entity.Book;
import pl.coderslab.app.entity.Publisher;

@Controller
public class TestController {

	@Autowired
	PublisherDao publisherDao;
	
	@Autowired
	BookDao bookDao;
	
	@RequestMapping("/test")
	@ResponseBody
	public String testRelation() {
		Publisher publisher = new Publisher();
		publisher.setName("Publisher");		
		publisher = publisherDao.createPublisher(publisher);
		
		Book book = new Book();

		book.setDescription("Description");
		book.setPublisher(publisher);
		
		bookDao.createBook(book);
			
//		Publisher publisher2 = new Publisher();
//		publisher2.setName("Publisher2");
//		Book book2 = new Book();
//		book2.setTitle("Tytul drugiej ksiazki");
//		publisher2.getBooks().add(book2);
//		
//		publisherDao.createPublisher(publisher2);
//		
//		Publisher publisher3 = new Publisher();
//		publisher3.setName("Publisher3");
//		Book book3 = new Book();
//		book3.setTitle("Tytul tzreciej ksiazki");
//		
//		bookDao.createBook(book3);
		
		Publisher fromDB = publisherDao.findById(publisher.getId());
		Integer books1Size = fromDB.getBooks().size();
			
		
		return "dziekuje " + books1Size;
	}
	
	@RequestMapping("/read")
	@ResponseBody
	public String testRead() {
		Book book = bookDao.findById(1L);
		
		Publisher publisher = publisherDao.findById(book.getPublisher().getId());
		return book.getPublisher().getName() + publisher.getName() + publisher.getBooks().size();
	}
	
	
	@RequestMapping("/testBook")
	@ResponseBody
	public String testBook() {
		Book book = bookDao.findById(1L);
		Author author = new Author();
		author.setName("Januszex");
		book.getAuthors().add(author);
		
		book = bookDao.updateBook(book);
		
		Publisher publisher = publisherDao.findById(book.getPublisher().getId());
		
		return book.getPublisher().getName() 
				+ publisher.getName() 
				+ publisher.getBooks().size() 
				+ book.getAuthors().size();
	}
}
