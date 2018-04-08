package pl.coderslab.app.entity;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

import pl.coderslab.app.dao.PublisherDao;

@Component
public class PublisherConverter implements Converter<Long, Publisher> {

	@Autowired
	PublisherDao publisherDao;
	
	public Publisher convert(Long id) {
		return publisherDao.findById(id);
	}

}
