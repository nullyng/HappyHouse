package com.ssafy.happyhouse.controller;

import com.ssafy.happyhouse.service.CodeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/code")
public class CodeController {

    @Autowired
    private CodeService codeService;

    @GetMapping
    public ResponseEntity<?> getCodes(@RequestParam("regcode") String regcode){
        return new ResponseEntity<>(codeService.getCodeDtoList(regcode), HttpStatus.OK);
    }
}
