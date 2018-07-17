package com.example.consumer;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.sleuth.annotation.NewSpan;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ConsumerController {

	private static final Logger logger = LoggerFactory.getLogger(ConsumerController.class);

	//String url = "http://producer-service:8080/producer";
	@Autowired
	private ProducerProxy proxy;


	@GetMapping("/consumer")
	public String retriveData() {

		logger.info("Retrieving data from producer proxy");

		String response = proxy.produces();

		logger.info("Data retrieved successfully from producer: -> {} ", response);

		return response;
	}

	@GetMapping("/consumerError")
	public String retrieveDataError() {
		logger.info("Retrieving data from producer proxyError");

		try {
			String response = proxy.produceError();
			logger.info("Data retrieved successfully from producer: -> {} ", response);
			return response;
		}catch (RuntimeException e) {
			logger.error("Ops! An unexpected error occur: ->  {}", e.getMessage());
			throw new RuntimeException(e);
		}


	}
}
