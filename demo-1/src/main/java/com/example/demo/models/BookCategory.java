package com.example.demo.models;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import lombok.Data;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties; 
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity(name="BookCategory")
@Table(name="bookcategory")
public class BookCategory implements Serializable {  
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", unique = true, nullable = false)
    private Long id;

    private String name;

    @OneToMany(mappedBy = "category", cascade = CascadeType.ALL)
    //@JsonIgnoreProperties("category")
    private Set<BestBuyBook> books = new HashSet<>();
    
    public BookCategory() {
        super();
    }
    
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

	public Set<BestBuyBook> getBooks() {
		return books;
	}

	public void setBooks(Set<BestBuyBook> books) {
		this.books = books;
	}
    
    public BookCategory(String name) {
    	this.setName(name);
    }
}
