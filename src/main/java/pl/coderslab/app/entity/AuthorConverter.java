package pl.coderslab.app.entity;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

import pl.coderslab.app.dao.AuthorDao;

@Component
public class AuthorConverter implements Converter<String, Author> {

	@Autowired
	AuthorDao authorDao;
	
	public Author convert(String id) {	
		System.out.println("bylem tu");
		return  authorDao.findById(Long.parseLong(id));
	}

}
