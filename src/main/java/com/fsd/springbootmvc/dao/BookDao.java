package com.fsd.springbootmvc.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.fsd.springbootmvc.entity.Book;

@Repository
public interface BookDao extends JpaRepository<Book, Integer>{	
	
	   @Query("SELECT b FROM Book b WHERE LOWER(b.title) = LOWER(:title)")
	    public List<Book> findByTitle(@Param("title") String title);

}
