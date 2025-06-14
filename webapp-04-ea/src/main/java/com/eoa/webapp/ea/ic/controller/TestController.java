package com.eoa.webapp.ea.ic.controller;

import lombok.RequiredArgsConstructor;
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
@RequiredArgsConstructor
public class TestController {

    private final TestService testService;

    @GetMapping("/api/testRequest")
    public String testRequest() {
        return "Hello World";
    }

    @PostMapping("/api/testPost")
    public ResponseEntity<Object> testPost(@RequestBody TestInDto dto){
        return ResponseEntity.ok(dto);
    }

    @PostMapping("/api/domaTest")
    public ResponseEntity<Object> domaTest(@RequestBody TestInDto dto){
        return testService.test(dto)
                .<ResponseEntity<Object>>map(ResponseEntity::ok)
                .orElseGet(() -> ResponseEntity.status(HttpStatus.NOT_FOUND).build());
    }

}
