package pl.coderslab.app.controller;

import java.util.Collection;
import java.util.List;
import java.util.Set;

import javax.validation.ConstraintViolation;
import javax.validation.Valid;
import javax.validation.Validator;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import pl.coderslab.app.dao.AuthorDao;
import pl.coderslab.app.dao.BookDao;
import pl.coderslab.app.dao.PublisherDao;
import pl.coderslab.app.entity.Author;
import pl.coderslab.app.entity.Book;
import pl.coderslab.app.entity.Publisher;

@Controller
@RequestMapping("/dzien3")
public class Dzien3Zadania {
	@Autowired
	Validator validator;
	
	@Autowired
	BookDao bookDao;
	
	@Autowired
	PublisherDao publisherDao;
	
	@Autowired 
	AuthorDao authorDao;
	
	@RequestMapping("/zad2")
	@ResponseBody
	public String validateBook() {
		 Book book = new Book();
		 book.setRating(-10.0);
		    Set<ConstraintViolation<Book>> violations = 
		    		validator.validate(book);
		    
		    StringBuilder builder = new StringBuilder();
		    
		    if (!violations.isEmpty()) {
		        for (ConstraintViolation<Book> constraintViolation 
		        		: violations) {
		            builder.append(constraintViolation.getPropertyPath() 
		            		+ " : " + constraintViolation.getMessage());
		            builder.append("\n");
		            
		            }
		    } else {
		        return "poszlo";
		    }
		    
		    return builder.toString();
	}
	
	
	
	
	
	
	
	@RequestMapping("/zad3")
	public String validateBook3(Model model) {
		 Book book = new Book();
		    Set<ConstraintViolation<Book>> violations = validator.validate(book);
		    model.addAttribute("errors", violations);
		    return "form/errorList";
	}
	
	
	
	
	
	
	
	@RequestMapping("/zad4")
	public String validateAuthor3(Model model) {
		 Author author = new Author();
		 author.setEmail("elo");
		 author.setPesel("88101715777");
		    Set<ConstraintViolation<Author>> violations = validator.validate(author);
		    model.addAttribute("errors", violations);
		    return "form/errorList";
	}
	
	@RequestMapping("/zad5")
	public String validatePublisher3(Model model) {
		Publisher publisher = new Publisher();
	    publisher.setNip("123");
	    publisher.setRegon("123");
		Set<ConstraintViolation<Publisher>> violations = validator.validate(publisher);
	    model.addAttribute("errors", violations);
	    return "form/errorList";
	}
	
	
	
	
	
	
	
	@RequestMapping("/zad21")
	public String getForm(Model model) {
	    model.addAttribute("book",new Book());
	    return "form/bookForm2";
	}
	
	
	@RequestMapping(value = "/zad21", 
			method = RequestMethod.POST)
	public String processBookForm(@Valid Book book,
			BindingResult result) {
		if(!result.hasErrors()) {
			bookDao.createBook(book);
		}
		return "form/bookForm2";
	}
	
	
	
	
	
	
	
	
	@RequestMapping(value = "/zad22")
	public String getAuthorForm(Model model) {
	    model.addAttribute("author",new Author());
	    return "form/authorForm";
	}
	
	@RequestMapping(value = "/zad22", 
			method = RequestMethod.POST)
	public String processAuthorForm(@Valid Author author,
			BindingResult result) {
		if(!result.hasErrors()) {
			authorDao.create(author);
		}
		return "form/authorForm";
	}
	
	
	
	
	
	
	
	
	
	
	// POMOCNICZE RZECZY
	
	@ModelAttribute("publisherItems")
	public List<Publisher> getPublisherItems(){
		return (List<Publisher>) publisherDao.findPublishers();		
	}
	
	@ModelAttribute("bookItems")
	public Collection<Book> getBookItems(){
		return bookDao.findAll();		
	}
	
	@ModelAttribute("authorItems")
	public Collection<Author> getAuthorItems(){
		return authorDao.findAll();		
	}
	
	/// koniec  pomocniczych
	
}
