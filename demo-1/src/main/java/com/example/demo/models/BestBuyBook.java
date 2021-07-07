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
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import lombok.Data;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties; 
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Entity(name="BestBuyBook")
@Table(name="bestbuybook")
public class BestBuyBook implements Serializable {  
	
	private static final long serialVersionUID = 1L;
	
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", unique = true, nullable = false)
    private Long id;

	private String title;

    private String description;

    @ManyToOne(cascade = {CascadeType.ALL})
    //@JoinColumn(name = "bookcategory_id")
    //@JsonIgnoreProperties("books")
    private BookCategory category;

    @ManyToMany(cascade = CascadeType.ALL)
    @JoinTable(name="bestbuybook_bookauthor", joinColumns={@JoinColumn(referencedColumnName="id")}
    	, inverseJoinColumns={@JoinColumn(referencedColumnName="id")})  
    //    @JsonIgnoreProperties("books")
    private List<Author> author = new ArrayList<>();

//    @OneToMany(mappedBy = "book", cascade = {CascadeType.ALL}, orphanRemoval = true)
//    //@JsonIgnoreProperties("book")
//    private Set<BookPublisher> bookPublishers = new HashSet<>();
        
    public BestBuyBook() {
        super();
    }

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

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public BookCategory getCategory() {
		return category;
	}

	public void setCategory(BookCategory category) {
		this.category = category;
	}

	public List<Author> getAuthors() {
		return author;
	}

	public void setAuthors(List<Author> authors) {
		this.author = authors;
	}
    
    public BestBuyBook(String title, String description) {
    	this.setTitle(title);
    	this.setDescription(description);    	
    }
    
}