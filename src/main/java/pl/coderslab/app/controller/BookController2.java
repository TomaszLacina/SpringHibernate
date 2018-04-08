package pl.coderslab.app.controller;

import java.util.Collection;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import pl.coderslab.app.dao.AuthorDao;
import pl.coderslab.app.dao.BookDao;
import pl.coderslab.app.dao.PublisherDao;
import pl.coderslab.app.entity.Author;
import pl.coderslab.app.entity.Book;
import pl.coderslab.app.entity.Publisher;

@Controller
public class BookController2 {

	@Autowired
	BookDao bookDao;
	
	@Autowired
	PublisherDao publisherDao;
	
	@Autowired 
	AuthorDao authorDao;
	
	@RequestMapping(value = "/getBookForm", 
			method = RequestMethod.GET)
	public String getBookForm(Model model) {
		model.addAttribute("book", new Book());
		
		return "form/bookForm2";
	}
	
	
	@RequestMapping(value = "/getBookList", 
			method = RequestMethod.GET)
	public String getBookList(Model model) {
		return "form/bookList";
	}
	@RequestMapping(value = "/getBookForm", 
			method = RequestMethod.POST)
	public String processBookForm(@ModelAttribute Book book) {
		System.out.println(book.getAuthors().size());
		System.out.println(book.getAuthors().get(0).getName());
		
		bookDao.createBook(book);
		return "redirect:/getBookList";
	}
	
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
}
