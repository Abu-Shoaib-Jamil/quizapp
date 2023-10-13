package com.practice.questionservice.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.practice.questionservice.model.Question;

@Repository
public interface QuestionRepo extends JpaRepository<Question, Integer>{
	public List<Question> findByLang(String lang);

	@Query(value = "SELECT question_id FROM question WHERE LANG=:lang ORDER BY RAND() LIMIT :num",nativeQuery = true)
	List<Integer> getRandomQuestionByLangWithLimit(String lang, int num);
}
