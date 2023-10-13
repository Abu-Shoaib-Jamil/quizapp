package com.practice.quizservice.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.practice.quizservice.feign.QuizFeign;
import com.practice.quizservice.model.QuestionWrapper;
import com.practice.quizservice.model.Quiz;
import com.practice.quizservice.repo.QuizRepo;

@Service
public class QuizService {

	@Autowired
	private QuizRepo repo;
	
	@Autowired
	private QuizFeign quizFeign;
	
	public ResponseEntity<String> createQuiz(String title, String lang, int num) {
		try {
//			Communicate with the question-service to get the question ids
			List<Integer> qids = quizFeign.generateQuestionIdsForQuiz(lang, num).getBody();
			
//			Form a quiz add title,lang and question ids and save it in quizdb
			Quiz q = new Quiz();
			q.setTitle(title);
			q.setQids(qids);
			repo.save(q);
			return new ResponseEntity<>("Success",HttpStatus.OK);
		}catch(Exception error) {
			return new ResponseEntity<>("Failed",HttpStatus.OK);
		}
	}
	
	public ResponseEntity<List<QuestionWrapper>> getQuiz(int quizid) {
		try {
//			Get the List of Question ids from quiz table.
			Quiz q = repo.findById(quizid).get();
			List<Integer> qids = q.getQids();
//			Communicate with the question-service to get the questions out of question ids
			List<QuestionWrapper> questions = quizFeign.generateQuestionforQuiz(qids).getBody();
			
			return new ResponseEntity<>(questions,HttpStatus.OK);
		}catch(Exception error) {
			return new ResponseEntity<>(new ArrayList<>(),HttpStatus.OK);
		}
	}
	
	
}
