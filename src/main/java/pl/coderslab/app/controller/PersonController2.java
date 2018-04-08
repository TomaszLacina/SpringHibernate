package pl.coderslab.app.controller;

import java.util.Arrays;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import pl.coderslab.app.entity.PersonDetails;

@Controller
public class PersonController2 {
	
	@RequestMapping(value = "/personForm3", 
			method = RequestMethod.GET)
	public String getPerson3Form(Model model) {
		model.addAttribute("person", new PersonDetails());
		return "form/personForm";
	}
	
	
	@ModelAttribute("genders")
	public List<String> getGenders(){
		return Arrays.asList("Male", "Female");
	}
	
	@ModelAttribute("countryItems")
	public List<String> getCountryItems(){
		return Arrays.asList("Polsa", "Czechy", "Slowacja");
	}
	
	@ModelAttribute("skillItems")
	public List<String> getSkillItems(){
		return Arrays.asList("Java", "Ruby", "PHP", "JS");
	}
	
	@ModelAttribute("hobbyItems")
	public List<String> getHobbyItems(){
		return Arrays.asList("Bieganie", "Plywanie", "Spanie");
	}
	
	
	@RequestMapping(value = "/personForm3", 
			method = RequestMethod.POST)
	public String processPerson3Form(@ModelAttribute PersonDetails person) {
		
		System.out.println(person.getLogin() + " " 
				+ person.getPassword() + " " 
				+ person.getEmail());
		
		return "form/success";
	}
	
	
	/*@RequestMapping(value = "/personForm3", 
			method = RequestMethod.POST)
	public String processPerson3Form(
			@RequestParam String login,
			@RequestParam String password,
			@RequestParam String email) {
		
		System.out.println(login + " " + password + " " + email);
		
		return "form/success";
	}*/
	
}
