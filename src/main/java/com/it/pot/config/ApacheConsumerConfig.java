package com.it.pot.config;

import java.util.HashMap;
import java.util.Map;

import org.apache.kafka.clients.consumer.ConsumerConfig;
import org.apache.kafka.common.serialization.StringDeserializer;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.config.ConcurrentKafkaListenerContainerFactory;
import org.springframework.kafka.core.ConsumerFactory;
import org.springframework.kafka.core.DefaultKafkaConsumerFactory;
import org.springframework.kafka.support.serializer.JsonDeserializer;

import com.it.dto.EmailMessageDTO;

@Configuration
public class ApacheConsumerConfig {

	@Value(value = "${bootstrap.servers}")
	private String bootstrapAddress;

	@Value(value = "${email.topic.name=}")
	private String groupId;

	@Bean
	public ConsumerFactory<String, EmailMessageDTO> messageConsumerFactory() {
		Map<String, Object> props = new HashMap<>();
		props.put(ConsumerConfig.BOOTSTRAP_SERVERS_CONFIG, bootstrapAddress);
		props.put(ConsumerConfig.GROUP_ID_CONFIG, "CT100");
		props.put(JsonDeserializer.TRUSTED_PACKAGES, "*");
		return new DefaultKafkaConsumerFactory<>(props, new StringDeserializer(),
				new JsonDeserializer<>(EmailMessageDTO.class));
	}

	@Bean("messageContainerListener")
	public ConcurrentKafkaListenerContainerFactory<String, EmailMessageDTO> messageKafkaListenerContainerFactory() {
		ConcurrentKafkaListenerContainerFactory<String, EmailMessageDTO> factory = new ConcurrentKafkaListenerContainerFactory<>();
		factory.setConsumerFactory(messageConsumerFactory());
		return factory;
	}
}
