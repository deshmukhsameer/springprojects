package com.example.demo.models;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

//@Entity
//@Getter
//@Setter
////@NoArgsConstructor
////@AllArgsConstructor
//@EqualsAndHashCode
//@Table(name="bestbuybook_bookauthor")
//public class BookAuthor implements Serializable {
	
//	@Id
//	@ManyToOne
////	@Column(name="books_bestbuybook_id")
////    @JsonIgnoreProperties("bookauthors")
//	private BestBuyBook book;
//
//	@Id
//	@ManyToOne
////	@Column(name="authors_bookauthor_id")
////  @JsonIgnoreProperties("authorbook")
//	private Author author;
//
////	@Override
////	public boolean equals(Object o) {
////		if ( this == o ) {
////			return true;
////		}
////		if ( o == null || getClass() != o.getClass() ) {
////			return false;
////		}
////		BookAuthor that = (BookAuthor) o;
////		return Objects.equals( book, that.book ) &&
////				Objects.equals( author, that.author );
////	}
////
////	@Override
////	public int hashCode() {
////		return Objects.hash( book, author );
////	}
	
//}
