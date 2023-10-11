package com.practice.quizapp.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.practice.quizapp.model.Question;
import com.practice.quizapp.model.Quiz;
import com.practice.quizapp.repo.QuizRepo;

@Service
public class QuizService {

	@Autowired
	QuestionService questionservice;
	@Autowired
	QuizRepo repo;
	
	public String createQuiz(String title,String lang,int num) {
		List<Question> questions = questionservice.getRandomQuestionByLangWithLimit(lang,num);
//		Store it in quiz table
		Quiz q = new Quiz();
		q.setTitle(title);
		q.setQuestions(questions);
		repo.save(q);
		return "Success";
	}
}
