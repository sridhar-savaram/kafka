package com.aap.demo.controller;


import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.aap.demo.model.Emp;
import com.aap.demo.repository.APIHandlerRepository;
import com.aap.demo.repository.EmpRepository;
import com.aap.demo.service.Producer;
import com.fasterxml.jackson.databind.ObjectMapper;

@RestController
@RequestMapping(value = "/api")
public class KafkaController {

    private final Producer producer;
    private static final Logger logger = LoggerFactory.getLogger(KafkaController.class);    
    @Autowired
    EmpRepository empRepo;
    
    @Autowired
    APIHandlerRepository apiHandlerRepository;

    @Autowired
    KafkaController(Producer producer) {
        this.producer = producer;
    }

    @PostMapping(value = "/publish", produces = "application/json")
    public ResponseEntity<String> sendMessageToKafkaTopic(@RequestParam("empno") String empNoStr) {
        
    	if(StringUtils.isEmpty(empNoStr))
    		return new ResponseEntity<>("empno value is blank", HttpStatus.BAD_REQUEST); 
        
    	logger.info("Emp No:" + empNoStr);
    	String result = "";
    	try {
    		Long empNo = Long.parseLong(empNoStr);
    		Optional<Emp> empRec = empRepo.findById(empNo);
    		if(!empRec.isPresent())
        		return new ResponseEntity<>("Emp record not found", HttpStatus.NOT_FOUND); 
    		Emp employee = empRec.get();
    		ObjectMapper mapper = new ObjectMapper();
    		result = mapper.writerWithDefaultPrettyPrinter().writeValueAsString(employee);
    		logger.info("Sending message to Kafka");
    		producer.sendMessage(result);
    	}catch(NumberFormatException e) {
    		logger.error(e.getMessage());
    		return new ResponseEntity<>("empno value is not a number", HttpStatus.BAD_REQUEST);
    	}catch(Exception e) {
    		logger.error(e.getMessage());
    		return new ResponseEntity<>(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
    	}
    	logger.info(result);
		return new ResponseEntity<>(result, HttpStatus.OK);

    }
    
    @PostMapping(value="/process", consumes = "text/plain", produces = "text/plain")
    public ResponseEntity<String> process(@RequestBody String payload, @RequestParam("interfaceCode") String interfaceCode){
    	String result = apiHandlerRepository.processAPI(interfaceCode, payload);
    	return new ResponseEntity<>(result, HttpStatus.OK);
    }
}
