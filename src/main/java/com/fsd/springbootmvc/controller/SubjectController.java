package com.fsd.springbootmvc.controller;

import java.util.ArrayList;
import java.util.List;

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
import com.fsd.springbootmvc.entity.Subject;
import com.fsd.springbootmvc.service.BookService;
import com.fsd.springbootmvc.service.SubjectService;

@Controller
@RequestMapping("/bookstore")
public class SubjectController {

	@Autowired
	private SubjectService subjectService;
	
	@Autowired
	private BookService bookService;
	
	@RequestMapping(value = "/subjects", method = RequestMethod.GET)
	public ModelAndView getSubjects(ModelMap model) {
		List<Subject> subjects =  subjectService.getAllSubjects();
		List<Book> books =  bookService.getAllBooks();
		System.out.println("fecth Subjects: " + subjects);
		model.addAttribute("subjects", subjects);
		model.addAttribute("books", books);
		System.out.println(" Fetching all the subjects : " + subjects);
		ModelAndView mv = new ModelAndView();
		mv.setViewName("displaySubjects");
		mv.addObject("messaage", "welcome to mvc");
		return mv;
		
	}
	
	@ModelAttribute
	public void addSubjectTomModel(Model addModel){
		addModel.addAttribute("subject",new Subject());
	}
	
	@RequestMapping(value="/addSubject", method = RequestMethod.POST)
	public ModelAndView addSubject(@ModelAttribute("subject") Subject subject, ModelMap addModel) {
		System.out.println("Add subjects Details : " + subject.getSubtitle() + " book ID : " + subject.getBook_id() + " Midel : " + addModel.toString());
		String result = subjectService.addSubject(subject);
		List<Subject> subjects =  subjectService.getAllSubjects();
		addModel.addAttribute("subjects", subjects);
		ModelAndView mv = new ModelAndView();
		mv.setViewName("showSubjects");
		return mv;
	}
	
	@RequestMapping(value="/searchSubjectById", method = RequestMethod.POST)
	public ModelAndView searchSubjectById(@RequestParam int id,ModelMap searchModel) {
		
		Subject search_subject = subjectService.searchSubjectByID(id);
		List<Subject> searchList = new ArrayList<Subject>();
		searchList.add(search_subject);
		searchModel.addAttribute("subjects", searchList);
		ModelAndView mv = new ModelAndView();
		mv.setViewName("showSubjects");
		return mv;
	}
	
	@RequestMapping(value="/searchSubjectByDuration", method = RequestMethod.POST)
	public ModelAndView searchSubjectByDuration(@RequestParam int duration,ModelMap searchModel) {
		
		List<Subject> search_subjects = subjectService.searchSubjectByDuration(duration);
		searchModel.addAttribute("subjects", search_subjects);
		ModelAndView mv = new ModelAndView();
		mv.setViewName("showSubjects");
		return mv;
	}

	
	@RequestMapping(value="/deleteSubject", method = RequestMethod.POST)
	public ModelAndView deleteSubject(@RequestParam int id,ModelMap deleteModel) {
		
		String deleteMessage = subjectService.deleteSubject(id);
		List<Subject> subjects =  subjectService.getAllSubjects();
		deleteModel.addAttribute("subjects", subjects);
		ModelAndView mv = new ModelAndView();
		mv.setViewName("showSubjects");
		return mv;
	}

	
}
