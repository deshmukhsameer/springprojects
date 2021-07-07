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

@Entity
@Getter
@Setter
@NoArgsConstructor
//@EqualsAndHashCode(exclude = "bookPublishers")
@Table(name="bookpublishers")
public class Publisher {  
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "publisher_id")
    private Long id;

    private String name;

    @OneToMany(mappedBy = "publisher", cascade = CascadeType.ALL, orphanRemoval = true)
    //@JsonIgnoreProperties("publisher")
    private Set<BookPublisher> bookPublishers = new HashSet<>();
    
    public Publisher(String name) {
    	this.setName(name);
    }
}
