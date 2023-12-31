package com.practice.quizapp.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.practice.quizapp.model.QuestionWrapper;
import com.practice.quizapp.service.QuizService;

@RestController
@RequestMapping("quiz")
public class QuizController {
	
	@Autowired
	QuizService quizservice;
	
	@PostMapping("create")
	public String createQuiz(@RequestParam("title") String title,@RequestParam("lang") String lang,@RequestParam("num") int num){
		quizservice.createQuiz(title,lang,num);
		return "success";
	}
	
	@GetMapping("{id}")
	public List<QuestionWrapper> getQuizQuestions(@PathVariable("id") int id) {
		return quizservice.getQuizQuestionsById(id);
	}
}
