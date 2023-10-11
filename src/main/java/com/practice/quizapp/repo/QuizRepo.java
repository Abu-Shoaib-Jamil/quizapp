package com.practice.quizapp.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.practice.quizapp.model.Quiz;

public interface QuizRepo extends JpaRepository<Quiz, Integer>{
	
}
