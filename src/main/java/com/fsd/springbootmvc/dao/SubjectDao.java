package com.fsd.springbootmvc.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.fsd.springbootmvc.entity.Book;
import com.fsd.springbootmvc.entity.Subject;

@Repository
public interface SubjectDao extends JpaRepository<Subject, Integer>{
	
	   @Query("SELECT s FROM Subject s WHERE LOWER(s.duration_in_hours) = LOWER(:duration)")
	    public List<Subject> findByDuration(@Param("duration") int duration);

}
