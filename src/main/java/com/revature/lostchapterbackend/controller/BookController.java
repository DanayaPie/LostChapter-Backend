package com.revature.lostchapterbackend.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.revature.lostchapterbackend.model.Book;
import com.revature.lostchapterbackend.service.BookService;

@RestController
public class BookController {
	
	@Autowired
	private BookService bs;

	@GetMapping(path = "/books")
	public List<Book> getAllBooks() {
		List <Book> bookList = bs.getAllBooks();
	
		return bookList;

	}
	
	@GetMapping(path = "/books/{id}")
	public Book getBookById(@PathVariable(value="id") String id) {
		return bs.getBookById(id);
		
	}
	
	@GetMapping(path = "/books/genre/{genreId}")
	public List<Book> getBookByGenreId(@PathVariable(value="genreId") String genreId) {
		
		
		return bs.getBooksByGenreId(genreId);
		
	}
	
	@GetMapping(path = "/books/search/{keyword}")
	public List<Book> getBookByKeyword(@PathVariable(value="keyword") String keyword) {
		
		return bs.getBooksByKeyword(keyword);
		
	}

}