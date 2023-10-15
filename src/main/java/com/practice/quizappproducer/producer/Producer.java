package com.practice.quizappproducer.producer;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

import com.practice.quizappproducer.model.DataDTO;

@Service
public class Producer {
	
	@Autowired
	private KafkaTemplate<String, String> kafkaTemplate;
	final private String topicname = "quiz-service-topic";
	
//	public void sendMessage(DataDTO dto) {
//		this.kafkaTemplate.send(topicname, dto);
//	}
	
	public void sendMessage(String message) {
		this.kafkaTemplate.send(topicname, message);
	}
	
}
