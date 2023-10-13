package com.practice.questionservice.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.practice.questionservice.model.Question;
import com.practice.questionservice.model.QuestionWrapper;
import com.practice.questionservice.model.Response;
import com.practice.questionservice.repo.QuestionRepo;


@Service
public class QuestionService {
	
	@Autowired
	private QuestionRepo repo;
	
	public ResponseEntity<List<Question>> getAllQuestions(){
		try {
			return new ResponseEntity<>(repo.findAll(),HttpStatus.OK);
		}catch(Exception error) {
			System.out.print(error);
			return new ResponseEntity<>(new ArrayList<>(),HttpStatus.BAD_REQUEST);
		}
	}
	
	public ResponseEntity<List<Question>> getQuestionsByLang(String lang){
		try {
			return new ResponseEntity<>(repo.findByLang(lang),HttpStatus.OK);
		}catch(Exception error) {
			System.out.print(error);
			return new ResponseEntity<>(new ArrayList<>(),HttpStatus.BAD_REQUEST);
		}
	}
	
	public ResponseEntity<String> addQuestion(Question q) {
		try {
			repo.save(q);
			return new ResponseEntity<>("success",HttpStatus.OK);
		}catch(Exception error) {
			System.out.print(error);
			return new ResponseEntity<>("failed",HttpStatus.BAD_REQUEST);
		}
	}

	public ResponseEntity<List<Integer>> getRandomQuestionByLangWithLimit(String lang, int num) {
		try {
			return new ResponseEntity<>(repo.getRandomQuestionByLangWithLimit(lang, num),HttpStatus.OK);
		}catch(Exception error) {
			System.out.print(error);
			return new ResponseEntity<>(new ArrayList<>(),HttpStatus.BAD_REQUEST);
		}
	}

	public ResponseEntity<List<QuestionWrapper>> getQuestionByIds(List<Integer> qids) {
		try {
			List<Question> questions = repo.findAllById(qids);
			List<QuestionWrapper> processedQuestions = new ArrayList<>();
			for(Question q : questions) {
				QuestionWrapper qw = new QuestionWrapper(
						q.getQuestionId(),
						q.getQuestion(),
						q.getOption1(),
						q.getOption2(),
						q.getOption3(),
						q.getOption4()
						);
				processedQuestions.add(qw);
			}
			return new ResponseEntity<>(processedQuestions,HttpStatus.OK);
		}catch(Exception error) {
			System.out.print(error);
			return new ResponseEntity<>(new ArrayList<>(),HttpStatus.BAD_REQUEST);
		}
	}

	public ResponseEntity<Integer> generateScore(List<Response> response) {
		try {
			int score=0;
			for(Response r : response) {
				String correctAnswer = repo.findById(r.getId()).get().getCorrectOption();
				if(r.getResponse().equals(correctAnswer)) {
					score++;
				}
			}
			return new ResponseEntity<>(score,HttpStatus.OK);
		}catch(Exception error) {
			System.out.print(error);
			return new ResponseEntity<>(0,HttpStatus.BAD_REQUEST);
		}
	}
	
	
	
}
