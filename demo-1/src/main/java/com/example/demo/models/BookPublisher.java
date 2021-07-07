package com.example.demo.models;

import java.io.Serializable;
import java.util.Date;
import java.util.Set;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import lombok.Data;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties; 
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@NoArgsConstructor
@Table(name="bookpublisher")
public class BookPublisher {  
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "bookpublisher_id")
    private Long id;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "bestbuybook_id")
    //@JsonIgnoreProperties("bookPublishers")
    private BestBuyBook book;

    @ManyToOne
    @JoinColumn(name = "publisher_id")
    //@JsonIgnoreProperties("bookPublishers")
    private Publisher publisher;

    private Date publishedDate;
    
    public BookPublisher (Date publishedDate) {
    	this.setPublishedDate(publishedDate);
    }
}
