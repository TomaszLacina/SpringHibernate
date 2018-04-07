package pl.coderslab.app.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import pl.coderslab.app.dao.BookDao;
import pl.coderslab.app.dao.PublisherDao;
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
		book.setAuthor("Autor");
		book.setDescription("Description");
		book.setPublisher(publisher);
		
		bookDao.createBook(book);
		
		
		Publisher publisher2 = new Publisher();
		publisher2.setName("Publisher2");
		Book book2 = new Book();
		book2.setTitle("Tytul drugiej ksiazki");
		publisher2.getBooks().add(book2);
		
		publisherDao.createPublisher(publisher2);
		
		Publisher publisher3 = new Publisher();
		publisher3.setName("Publisher3");
		Book book3 = new Book();
		book3.setTitle("Tytul tzreciej ksiazki");
		publisher3.getBooks().add(book3);
		
		bookDao.createBook(book3);
		
		
		
		return "dziekuje";
	}
}
