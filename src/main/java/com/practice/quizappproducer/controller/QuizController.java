package com.practice.quizappproducer.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.practice.quizappproducer.model.DataDTO;
import com.practice.quizappproducer.producer.Producer;

@RestController
@RequestMapping("quiz")
public class QuizController {

	@Autowired
	private Producer producer;
	
//	@GetMapping("create")
//	public String createQuiz(@RequestParam("lang") String lang,@RequestParam("num") int num) {
//		DataDTO dto = new DataDTO();
//		dto.setLang(lang);
//		dto.setNum(num);
//		producer.sendMessage(dto);
//		return "success";
//	}
	
	@GetMapping("create")
	public String createQuiz(@RequestParam("lang") String lang) {
		producer.sendMessage(lang);
		return "success";
	}
	
}
