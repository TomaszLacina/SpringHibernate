package pl.coderslab.app.controller;

import java.util.Arrays;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import pl.coderslab.app.entity.Person;

@Controller
public class PersonController {

	@RequestMapping(method = RequestMethod.GET, value = "/personForm")
	public String getPersonForm(Model model) {
		model.addAttribute("person", new Person());
		return "form/registerSimple";
	}

	@RequestMapping(value = "/personForm", method = RequestMethod.POST)
	public String processSimple(@RequestParam String login, 
			@RequestParam String password, 
			@RequestParam String email,
			Model model) {
		Person person = new Person(login, password, email);
		model.addAttribute("person", person);
		System.out.println(login + "," + password + "," + email);
//		System.out.println(model.att + "," + password + "," + email);
		return "form/success";
	}
	
	
	@RequestMapping(method = RequestMethod.GET, value = "/personForm2")
	public String getPersonForm2(Model model) {
		model.addAttribute("person", new Person());
		return "form/registerSimple";
	}

	@RequestMapping(value = "/personForm2", method = RequestMethod.POST)
	public String processSimple2(@ModelAttribute Person person) {
		
		System.out.println(person.getLogin() + "," + person.getPassword() + "," + person.getEmail());
//		System.out.println(model.att + "," + password + "," + email);
		return "form/success";
	}
	
	@ModelAttribute("languages")
	public List<String> checkOptions() {
	    String a[] = new String[] {"java", "php", "ruby", "python"};
	    return Arrays.asList(a);
	}
}
