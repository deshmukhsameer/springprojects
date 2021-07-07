package com.example.demo.models;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import lombok.Data;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties; 
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Entity(name="Author")
@Table(name="Author")
public class Author implements Serializable {  
	
	private static final long serialVersionUID = 12345L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", unique = true, nullable = false)
    private Long id;

    private String name;

    @ManyToMany(mappedBy = "author", cascade = CascadeType.ALL)
    //@JsonIgnoreProperties("authors")
    private List<BestBuyBook> book = new ArrayList<>();

    public Long getId() {
		return id;
	}

    public Author() {
        super();
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

	public List<BestBuyBook> getBooks() {
		return book;
	}

	public void setBooks(List<BestBuyBook> books) {
		this.book = books;
	}
    
    public Author(String name) {
    	this.setName(name);
    }
}
