package com.practice.quizappconsumer.consumer;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

import com.practice.quizappconsumer.model.DataDTO;

@Service
public class Consumer {
	
	private final Logger LOGGER = LoggerFactory.getLogger(Consumer.class);
	
//	@KafkaListener(topics = "quiz-service-topic",groupId = "quiz-service")
//	public void consume(DataDTO dto) {
//		LOGGER.info(String.format("--------------> Consumed Message : %s",dto));
//	}
	
	@KafkaListener(topics = "quiz-service-topic",groupId = "quizService")
	public void consume(String message) {
		LOGGER.info(String.format("--------------> Consumed Message : %s",message));
	}
}
