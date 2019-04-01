package com.fsd.springbootmvc.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.fsd.springbootmvc.entity.Book;

@Service
public interface BookService {
	public List<Book> getAllBooks();
	public String addBook(Book book);
	public Book searchBookByID(int id);
	public List<Book> searchBookByTitle(String title);
	public String deleteBook(int id);
}
