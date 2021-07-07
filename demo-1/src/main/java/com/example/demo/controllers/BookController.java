package com.example.demo.controllers;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashSet;
import java.util.Set;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;

import com.example.demo.models.Author;
import com.example.demo.models.BestBuyBook;
import com.example.demo.models.BookCategory;
import com.example.demo.models.BookPublisher;
import com.example.demo.models.Publisher;
import com.example.demo.models.RequestBook;

@RestController
@RequestMapping(value = "/book")
public class BookController {
	
    @Autowired
    private SessionFactory sessionFactory;
	
	@RequestMapping(value = "/savebook",method = RequestMethod.POST)
	@ResponseBody
    public String saveBook(@RequestBody RequestBook reqBook) {
        Session session = sessionFactory.getCurrentSession();
        session.beginTransaction();
        System.out.println("saving book: " + reqBook.getCategory().getName());
        BestBuyBook book = new BestBuyBook(reqBook.getTitle(), reqBook.getDescription());
        BookCategory reqCategory = new BookCategory(reqBook.getCategory().getName());
        Set<Author> reqAuthors = new HashSet<Author>();

        reqBook.getAuthors().forEach(bookauthor -> {
			Author author = new Author(bookauthor.getName());
	        author.getBooks().add(book);
	    	book.getAuthors().add(author);
        });
        session.save(book);
        
		book.setCategory(reqCategory);
    	reqCategory.getBooks().add(book);
    	session.saveOrUpdate(book);
    	session.getTransaction().commit();
    	
        return "Success";
    }
	
	@RequestMapping(value = "/{bookId}",method = RequestMethod.GET)
    @ResponseBody
    public BestBuyBook getBookDetails(@PathVariable Long bookId) {
		Session session = sessionFactory.getCurrentSession();
		return session.find(BestBuyBook.class, bookId);
	}
	
}
