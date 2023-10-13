package com.practice.quizservice.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.practice.quizservice.model.QuestionWrapper;
import com.practice.quizservice.service.QuizService;

@RestController
@RequestMapping("quiz")
public class QuizController {
	
	@Autowired
	private QuizService quizService;
	
	@GetMapping("create")
	public String createQuiz(@RequestParam("title") String title,@RequestParam("lang") String lang,@RequestParam("num") int num){
		quizService.createQuiz(title,lang,num);
		return "success";
	}
	
	@PostMapping("{id}")
	public List<QuestionWrapper> getQuizQuestions(@PathVariable("id") int id) {
		return quizService.getQuiz(id).getBody();
	}

}
