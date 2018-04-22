package pl.coderslab.app.controller;

import java.awt.print.Pageable;
import java.util.Collection;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.validation.ConstraintViolation;
import javax.validation.Valid;
import javax.validation.Validator;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import pl.coderslab.app.dao.AuthorDao;
import pl.coderslab.app.dao.PublisherDao;
import pl.coderslab.app.entity.Author;
import pl.coderslab.app.entity.Book;
import pl.coderslab.app.entity.Publisher;
import pl.coderslab.app.repository.BookRepository;

@Controller
@RequestMapping("/dzien4")
public class Dzien4Zadania {
	@Autowired
	Validator validator;
	
	@Autowired
	BookRepository bookRepository;
	
	@Autowired
	PublisherDao publisherDao;
	
	@Autowired 
	AuthorDao authorDao;
	
	@RequestMapping("/zad1")
	public String getForm(Model model) {
	    model.addAttribute("book",new Book());
	    return "form/bookForm2";
	}
	
	
	@RequestMapping(value = "/zad1", 
			method = RequestMethod.POST)
	public String processBookForm(@Valid Book book,
			BindingResult result) {
		if(!result.hasErrors()) {
			bookRepository.save(book);
		}
		return "form/bookForm2";
	}
	
	@RequestMapping(value = "/zad2", 
			method = RequestMethod.GET)
	@ResponseBody
	public String queryBooks() {
		StringBuilder sb = new StringBuilder();
		
		Book book = bookRepository.findByTitleIgnoreCase("Elementarz").get(0);
		sb.append("Po tytule znalazlem " + book.getId() + " tytul pierwszej " + book.getTitle());
		
		
		book = bookRepository.findByPublisher(book.getPublisher()).get(0);
		sb.append(" Po pubsliher znalazlem " + book.getId() + " tytul pierwszej " + book.getTitle());
	
		book = bookRepository.findByPublisherId(book.getPublisher().getId()).get(0);
		sb.append(" Po pubsliher znalazlem " + book.getId() + " tytul pierwszej " + book.getTitle());
	
		
		sb.append("<br/> Po tytule znalazlem " + bookRepository.findByTitleIgnoreCase("Elementarz").size());		
		sb.append("<br/> Po autorach znalazlem " + bookRepository.findDistinctByAuthorsIn(new HashSet<>(book.getAuthors())).size());
		sb.append("<br/> Po pubsliher znalazlem " + bookRepository.findByPublisherId(book.getPublisher().getId()).size());
	
		
		
		
		
		
		book = bookRepository.findDistinctByAuthorsIn(new HashSet<>(book.getAuthors())).get(0);
		sb.append(" Po autorach znalazlem " + book.getId() + " tytul pierwszej " + book.getTitle());
		
		return sb.toString();
	}
	
	
	@RequestMapping(value = "/zad21", 
			method = RequestMethod.GET)
	@ResponseBody
	public String queryBooks2() {
		StringBuilder sb = new StringBuilder();
		Book book = bookRepository.findByTitleIgnoreCase("Elementarz").get(0);
		
		sb.append("<br/> Po tytule znalazlem " + bookRepository.szukajPoTytule("Elementarz").size());		
		sb.append("<br/> Po tytule znalazlem " + bookRepository.findByTitleOrderByDescriptionAsc("Elementarz").size());		
		
		sb.append("<br/> Po pubsliher znalazlem " + bookRepository.szukajPoPublisherze(book.getPublisher().getId()).size());
		sb.append("<br/> Po pubsliher znalazlem " + bookRepository.szukajPoPublisherze2(book.getPublisher()).size());
		sb.append("<br/> Po pubsliher authorze " + bookRepository.szukajPoAuthorze(book.getAuthors().get(0), 
											new PageRequest(0,1)).size()
				);
		
		
		bookRepository.doStuff(1000);
		return sb.toString();
	}
	// POMOCNICZE RZECZY
	
		@ModelAttribute("publisherItems")
		public List<Publisher> getPublisherItems(){
			return (List<Publisher>) publisherDao.findPublishers();		
		}
		
		@ModelAttribute("bookItems")
		public Collection<Book> getBookItems(){
			return bookRepository.findAll();		
		}
		
		@ModelAttribute("authorItems")
		public Collection<Author> getAuthorItems(){
			return authorDao.findAll();		
		}
		
		/// koniec  pomocniczych
	
}
