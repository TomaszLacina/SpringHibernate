package pl.coderslab.app.controller;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import pl.coderslab.app.dao.BookDao;
import pl.coderslab.app.dao.PublisherDao;
import pl.coderslab.app.entity.Book;
import pl.coderslab.app.entity.Publisher;

@Controller
public class BookController2 {

	@Autowired
	BookDao bookDao;
	
	@Autowired
	PublisherDao publisherDao;
	
	@RequestMapping(value = "/getBookForm", 
			method = RequestMethod.GET)
	public String getBookForm(Model model) {
		model.addAttribute("book", new Book());
		
		return "form/bookForm2";
	}
	
	@RequestMapping(value = "/getBookForm", 
			method = RequestMethod.POST)
	public String processBookForm(@ModelAttribute Book book) {
		bookDao.createBook(book);
		return "form/bookForm2";
	}
	
	@ModelAttribute("publisherItems")
	public Collection<Publisher> getPublisherItems(){
		return publisherDao.findPublishers();		
	}
}
