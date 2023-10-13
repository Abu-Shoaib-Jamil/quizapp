package com.practice.questionservice.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.practice.questionservice.model.Question;
import com.practice.questionservice.model.QuestionWrapper;
import com.practice.questionservice.model.Response;
import com.practice.questionservice.service.QuestionService;



@RestController
@RequestMapping("question")
public class QuestionController {

	@Autowired
	private QuestionService questionService;
	
	@GetMapping("allquestions")
	public ResponseEntity<List<Question>> getAllQuestions(){
		return questionService.getAllQuestions();
	}
	
	@GetMapping("{lang}/questions")
	public ResponseEntity<List<Question>> forwardLangController(@PathVariable("lang") String lang) {
		return questionService.getQuestionsByLang(lang);
	}
	
	@PostMapping("add")
	public ResponseEntity<String> addQuestion(@RequestBody Question q) {
		return questionService.addQuestion(q);
//		return "redirect:question/allquestions";
	}
	
	@PostMapping("generate")
	public ResponseEntity<List<Integer>> generateQuestionIdsForQuiz(@RequestParam("lang") String lang,@RequestParam("num") int num){
		return questionService.getRandomQuestionByLangWithLimit(lang, num);
	}
	
	@PostMapping("get")
	public ResponseEntity<List<QuestionWrapper>> generateQuestionforQuiz(@RequestBody List<Integer> qids){
		return questionService.getQuestionByIds(qids);
	}
	
	@PostMapping("score")
	public ResponseEntity<Integer> generateScore(@RequestBody List<Response> response){
		return questionService.generateScore(response);
	}
}
