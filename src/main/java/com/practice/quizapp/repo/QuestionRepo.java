package com.practice.quizapp.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.practice.quizapp.model.Question;

@Repository
public interface QuestionRepo extends JpaRepository<Question, Integer>{
	public List<Question> findByLang(String lang);
}
