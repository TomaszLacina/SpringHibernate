package pl.coderslab.app.controller;

import java.util.Collection;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
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
	
	
	@RequestMapping("/createTestDeleteBook")
	@ResponseBody
	public String deleteBook() {
		Book book = new Book ();
		book.setDescription("Deskrypszyn");
		book.setPages(11);
		book.setRating(1.1);
		book.setTitle("Tytul");
		book.setProposition(false);
		
		Collection<Author> authors = authorDao.findAll();
		Publisher publisher = new Publisher();
		publisher.setName("Super nejm");
		
		publisher = publisherDao.createPublisher(publisher);
		
		book.setPublisher(publisher);
		book.getAuthors().addAll(authors);
		
		
		bookDao.createBook(book);
		return "stworzono udalo sie, id ksiazki " + book.getId();		
	}
	
	@RequestMapping("/createTestDeleteBook/{id}")
	@ResponseBody
	public String deleteBook(@PathVariable Integer id) {
		bookDao.deleteById(Integer.toUnsignedLong(id));
		
		return "ok";
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
