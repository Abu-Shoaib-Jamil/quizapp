package com.practice.quizapp.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.practice.quizapp.model.Question;
import com.practice.quizapp.repo.QuestionRepo;

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

	
	public List<Question> getRandomQuestionByLangWithLimit(String lang, int num) {
		try {
//			Store the 
			return repo.getRandomQuestionByLangWithLimit(lang,num);
		}catch(Exception error) {
			System.out.print(error);
			return new ArrayList<>();
		}
	}

}
