package com.it.pot;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

import com.it.dto.EmailMessageDTO;

//Integer - >> int
@Service
public class KafkaConsumerService {
	
	private final Logger logger 
	= LoggerFactory.getLogger(KafkaConsumerService.class);
	
	@KafkaListener(topics = "${email.topic.name}",groupId = "CT100",containerFactory = "messageContainerListener")
	public void consumeEmailMessage(EmailMessageDTO message) {
		logger.info(String.format("###MESSAGE RECIEVED FROM CONSUMER#->>1 -> %s", message));
	}

}
