package com.fsd.springbootmvc.controller;

import java.util.ArrayList;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.fsd.springbootmvc.entity.Book;
import com.fsd.springbootmvc.service.BookService;

@Controller
@RequestMapping("/bookstore")
public class BookController {
	
	@Autowired
	private BookService bookService;
	
	
	@RequestMapping(value = "/show", method = RequestMethod.GET)
	public ModelAndView showStorePage(ModelMap model) {
		List<Book> books =  bookService.getAllBooks();
		model.addAttribute("books", books);
		System.out.println(" Fetching all the books : " + books);
		ModelAndView mv = new ModelAndView();
		mv.setViewName("bookStore");
		mv.addObject("messaage", "welcome to mvc");
		return mv;
		
	}
	
	@RequestMapping(value = "/books", method = RequestMethod.GET)
	public ModelAndView getBooks(ModelMap model) {
		List<Book> books =  bookService.getAllBooks();
		model.addAttribute("books", books);
		System.out.println(" Fetching all the books : " + books);
		ModelAndView mv = new ModelAndView();
		mv.setViewName("displayBooks");
		mv.addObject("messaage", "welcome to mvc");
		return mv;
		
	}
	
	@ModelAttribute
	public void addBookTomModel(Model addModel){
		addModel.addAttribute("book",new Book());
	}
	
	@RequestMapping(value="/addBook", method = RequestMethod.POST)
	public ModelAndView addBook(@ModelAttribute("book") Book book, ModelMap addModel) {
		System.out.println("Add book Details : " + book.getTitle() + " Midel : " + addModel.toString());
		String result = bookService.addBook(book);
		List<Book> books =  bookService.getAllBooks();
		addModel.addAttribute("books", books);
		ModelAndView mv = new ModelAndView();
		mv.setViewName("showBooks");
		return mv;
	}
	
	@RequestMapping(value="/searchBookById", method = RequestMethod.POST)
	public ModelAndView searchBook(@RequestParam int id,ModelMap searchModel) {
		
		Book search_book = bookService.searchBookByID(id);
		List<Book> searchList = new ArrayList<Book>();
		searchList.add(search_book);
		searchModel.addAttribute("books", searchList);
		ModelAndView mv = new ModelAndView();
		mv.setViewName("showBooks");
		return mv;
	}
	
	@RequestMapping(value="/searchBookByTitle", method = RequestMethod.POST)
	public ModelAndView searchBook(@RequestParam String title,ModelMap searchModel) {
		
		List<Book> search_books = bookService.searchBookByTitle(title);
		searchModel.addAttribute("books", search_books);
		ModelAndView mv = new ModelAndView();
		mv.setViewName("showBooks");
		return mv;
	}

	
	@RequestMapping(value="/deleteBook", method = RequestMethod.POST)
	public ModelAndView deleteBook(@RequestParam int id,ModelMap deleteModel) {
		
		String deleteMessage = bookService.deleteBook(id);
		List<Book> books =  bookService.getAllBooks();
		deleteModel.addAttribute("books", books);
		ModelAndView mv = new ModelAndView();
		mv.setViewName("showBooks");
		return mv;
	}
}
