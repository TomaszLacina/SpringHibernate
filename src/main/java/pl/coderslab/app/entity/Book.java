package pl.coderslab.app.entity;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.validation.groups.Default;

import org.hibernate.validator.constraints.NotEmpty;

@Entity
@Table(name = "books")
public class Book {
	
	public Book() {
		
	}
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id; 
	
	@NotNull
	@Size(min = 5, groups = {Default.class, BookPropositionGroup.class})
	private String title;
	
	@NotEmpty(groups = {Default.class})
	@ManyToMany(fetch = FetchType.EAGER)
    private List<Author> authors = new ArrayList<Author>();
	
	@NotNull(groups = {Default.class})
	@Min(value = 1, message = "{tutaj.wpisujemy.swoj.tekst}")
	@Max(value = 10)
	private Double rating;
	
	@NotNull(groups = {Default.class})
	@ManyToOne
	private Publisher publisher;
	
	@Size(max = 600, groups = {Default.class, BookPropositionGroup.class})
	private String description;
	
	@Min(value = 1, groups = {Default.class})
	private Integer pages;
	
	private Boolean proposition;
	

	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	
	public List<Author> getAuthors() {
		return authors;
	}
	public void setAuthors(List<Author> authors) {
		this.authors = authors;
	}
	public Double getRating() {
		return rating;
	}
	public void setRating(Double rating) {
		this.rating = rating;
	}
	public Publisher getPublisher() {
		return publisher;
	}
	public void setPublisher(Publisher publisher) {
		this.publisher = publisher;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public Integer getPages() {
		return pages;
	}
	public void setPages(Integer pages) {
		this.pages = pages;
	}
	public Boolean getProposition() {
		return proposition;
	}
	public void setProposition(Boolean proposition) {
		this.proposition = proposition;
	}
	
	
	
}
