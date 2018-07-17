package com.example.producer;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.net.InetAddress;
import java.net.UnknownHostException;

@RestController
public class ProducerController {

	private static final Logger logger = LoggerFactory.getLogger(ProducerController.class);

	@GetMapping("/producer")
	public String producer() {
		logger.info("Starting producer ... ");

		String distros[] = new String[] {"Ubuntu","Kurumin","Debian","Kali Linux"};

		int random = (int)(Math.random()*4);
		String host = null;
		try {
			host = String.format("Address-> %s  Hostname -> %s",
					InetAddress.getLocalHost().getHostAddress(),
					InetAddress.getLocalHost().getHostName());

			logger.info("Host got sucessfully -> {}", host);
		} catch (UnknownHostException e) {
			logger.error("Error getting hostname: -> {}", e.getMessage());
		}
		return distros[random] + " >>> HOST "+ host;
	}

	@GetMapping("/producerError")
	public void producerError() {

		logger.info("Producer error starting");
		if(1 == 1)
			throw new RuntimeException("Error trying to run producer");
	}

}
