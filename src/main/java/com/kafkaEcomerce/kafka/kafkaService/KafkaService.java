package com.kafkaEcomerce.kafka.kafkaService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

@Service
public class KafkaService {

	@Autowired
	KafkaTemplate<String, String> kafkaTemplate;

	public void sendMessage(String _topic, String _key, String _msg) {
		System.out.println("the msg is" + _msg + "from the topic " + _topic);
		// String key = "CUS001";
		kafkaTemplate.send(_topic, _key, _msg);
	}

}
