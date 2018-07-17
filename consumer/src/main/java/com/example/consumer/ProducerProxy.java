package com.example.consumer;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;

//@FeignClient(name = "producer-service", url = "http://producer-service:8080")
@FeignClient(name = "producer-service", url="http://producer-service:8080")
public interface ProducerProxy {

    @GetMapping("/producer")
    public String produces();

    @GetMapping("/producerError")
    String produceError();
}
