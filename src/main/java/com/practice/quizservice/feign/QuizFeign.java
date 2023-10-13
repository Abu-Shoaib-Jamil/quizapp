package com.practice.quizservice.feign;

import java.util.List;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;

import com.practice.quizservice.model.QuestionWrapper;
import com.practice.quizservice.model.Response;


@Component
@FeignClient("QUESTION-SERVICE")
public interface QuizFeign {
	@PostMapping("question/generate")
	public ResponseEntity<List<Integer>> generateQuestionIdsForQuiz(@RequestParam("lang") String lang,@RequestParam("num") int num);
	
	@PostMapping("question/get")
	public ResponseEntity<List<QuestionWrapper>> generateQuestionforQuiz(@RequestBody List<Integer> qids);
	
	@PostMapping("question/score")
	public ResponseEntity<Integer> generateScore(@RequestBody List<Response> response);
}
