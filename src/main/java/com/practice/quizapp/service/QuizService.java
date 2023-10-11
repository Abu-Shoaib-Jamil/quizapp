package com.practice.quizapp.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.practice.quizapp.model.Question;
import com.practice.quizapp.model.QuestionWrapper;
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

	public List<QuestionWrapper> getQuizQuestionsById(int id) {
		Optional<Quiz> questions = repo.findById(id);
		List<Question> questionsFromDB = questions.get().getQuestions();
		List<QuestionWrapper> questionsToClient = new ArrayList<>();
		for(Question q:questionsFromDB) {
			
			QuestionWrapper qw = new QuestionWrapper(q.getQuestionId(),q.getQuestion(),q.getOption1(),q.getOption2(),q.getOption3(),q.getOption4());
			questionsToClient.add(qw);
		}
		return questionsToClient;
	}
}
