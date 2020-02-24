package com.aap.demo.controller;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import com.aap.demo.repository.MessageRepository;
import com.aap.demo.service.Producer;

@RestController
@RequestMapping(value = "/api")
public class KafkaController {

    private final Producer producer;
    private static final Logger logger = LoggerFactory.getLogger(KafkaController.class);    


    @Autowired
    KafkaController(Producer producer) {
        this.producer = producer;
    }

    
    @PostMapping(value="/asyncprocess", consumes = "text/plain", produces = "text/plain")
    public ResponseEntity<String> process(@RequestBody String payload, @RequestParam("interfaceCode") String interfaceCode){
    	producer.sendMessage(payload);
    	return new ResponseEntity<>(HttpStatus.OK);
    }
}
