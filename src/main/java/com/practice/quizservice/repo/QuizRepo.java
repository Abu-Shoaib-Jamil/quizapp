package com.practice.quizservice.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.practice.quizservice.model.Quiz;

public interface QuizRepo extends JpaRepository<Quiz, Integer>{

}
