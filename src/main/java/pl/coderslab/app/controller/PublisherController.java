package pl.coderslab.app.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import pl.coderslab.app.dao.PublisherDao;
import pl.coderslab.app.entity.Book;
import pl.coderslab.app.entity.Publisher;

@Controller
public class PublisherController {

	@Autowired
	PublisherDao publisherDao;

	@RequestMapping(value = "/createPublisher", produces = "application/json", consumes = "application/json")
	@ResponseBody
	public Publisher create() {
		return publisherDao.createPublisher(new Publisher());
	}

	@RequestMapping("/updatePublisher")
	@ResponseBody
	public Publisher update() {
		Publisher publisher = new Publisher();
		publisher.setName("Publiszer");
		publisherDao.createPublisher(publisher);
		publisher.setName("Inny autor");
		return publisherDao.updatePublisher(publisher);
	}

	@RequestMapping("/readPublisher")
	@ResponseBody
	public Publisher findById() {
		return publisherDao.findById(1L);
	}

	@RequestMapping("/deletePublisher")
	@ResponseBody
	public void deleteById() {
		publisherDao.deleteById(1L);
	}

}



//git clone https://github.com/TomaszLacina/SpringHibernate.git




