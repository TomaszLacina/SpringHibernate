package pl.coderslab.app.entity;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.hibernate.validator.constraints.pl.NIP;
import org.hibernate.validator.constraints.pl.REGON;


@Entity
@Table(name = "publishers")
public class Publisher {
	
	public Publisher() {
		
	}
	
	@OneToMany(mappedBy = "publisher", 
			cascade = CascadeType.ALL,
			fetch = FetchType.EAGER)
	List<Book> books = new ArrayList<Book>();
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	Long id;
	String name;
	
	@NIP
	String nip;
	
	@REGON
	String regon;
	
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public List<Book> getBooks() {
		return books;
	}
	public void setBooks(List<Book> books) {
		this.books = books;
	}
	public String getNip() {
		return nip;
	}
	public void setNip(String nip) {
		this.nip = nip;
	}
	public String getRegon() {
		return regon;
	}
	public void setRegon(String regon) {
		this.regon = regon;
	}
	
	
	
	
}
