package com.eoa.webapp.ea.ic.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.eoa.webapp.ea.bc.TestService;
import com.eoa.webapp.ea.ic.dto.TestInDto;
import com.eoa.webapp.ea.ic.dto.TestOutDto;

@CrossOrigin("*")
@RestController
public class TestController {

	@Autowired
    TestService testService;

    @GetMapping("/api/testRequest")
    public String testRequest() {
        return "Hello World";
    }

    @PostMapping("/api/testPost")
    public ResponseEntity<Object> testPost(@RequestBody TestInDto dto){
        return new ResponseEntity<>(dto, HttpStatus.OK);
    }

    @PostMapping("/api/domaTest")
    public ResponseEntity<Object> domaTest(@RequestBody TestInDto dto){
        TestOutDto outDto = testService.test(dto);

        return new ResponseEntity<>(outDto, HttpStatus.OK);
    }

}
