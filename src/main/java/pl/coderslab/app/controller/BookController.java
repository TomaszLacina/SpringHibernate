package pl.coderslab.app.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import pl.coderslab.app.dao.BookDao;
import pl.coderslab.app.entity.Book;

@Controller
public class BookController {

	@Autowired
	BookDao bookDao;
	
	@RequestMapping(value = "/createBook", produces = "application/json",  consumes = "application/json" )
	@ResponseBody
	public Book create() {
		return bookDao.createBook(new Book());
	}
	
	@RequestMapping(method = RequestMethod.POST, value = "/createBookJson", produces = "application/json",  consumes = "application/json" )
	@ResponseBody
	public Book createJson(@RequestBody Book book) {
		return bookDao.createBook(book);
	}
	
	
	@RequestMapping("/updateBook")
	@ResponseBody
	public Book update() {
		Book book = new Book();
		book.setAuthor("Autor");
		bookDao.createBook(book);
		book.setAuthor("Inny autor");
		return bookDao.updateBook(book);
	}
	
	@RequestMapping("/readBook")
	@ResponseBody
	public Book findById() {
		return bookDao.findById(1L);
	}
	
	@RequestMapping("/deleteBook")
	@ResponseBody
	public void deleteById() {
		bookDao.deleteById(1L);
	}
	
}
