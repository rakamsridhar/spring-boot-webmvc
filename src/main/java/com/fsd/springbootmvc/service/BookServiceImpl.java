package com.fsd.springbootmvc.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fsd.springbootmvc.dao.BookDao;
import com.fsd.springbootmvc.entity.Book;

@Service
public class BookServiceImpl implements BookService{
	
	@Autowired
	private BookDao bookDao;
	
	@Override
	public List<Book> getAllBooks() {
		return bookDao.findAll();
		
	}

	@Override
	public String addBook(Book book) {
		Book book_saved = bookDao.save(book);
		if(book_saved != null) {
			return "book saved sucessfully";
		}
		return "could not save book";
	}

	@Override
	public Book searchBookByID(int id) {
		Optional<Book> book = bookDao.findById(id);
		return book.get();
	}

	@Override
	public String deleteBook(int id) {
		bookDao.deleteById(id);
		return "book deleted sucessfully";
	}

	@Override
	public List<Book> searchBookByTitle(String title) {
		List<Book> books = bookDao.findByTitle(title);
		return books;
	}

}
