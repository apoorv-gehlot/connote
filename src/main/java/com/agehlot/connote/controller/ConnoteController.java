package com.agehlot.connote.controller;

import java.util.List;
import java.util.stream.Collectors;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.agehlot.connote.model.CarrierAccount;
import com.agehlot.connote.service.ConnoteService;

@RestController
@RequestMapping("/v1")
public class ConnoteController {
    
    @Autowired
    ConnoteService connoteService;

    @GetMapping("/connote")
    public ResponseEntity<?> generateConnote(@Valid @RequestBody CarrierAccount carrierApp,
            BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            List<FieldError> fieldErrors = bindingResult.getFieldErrors();
            List<String> errList = fieldErrors.stream().map(FieldError::getDefaultMessage)
                    .collect(Collectors.toList());
            return new ResponseEntity<>(errList, HttpStatus.BAD_REQUEST);
        }
        String connote = connoteService.generateNextConnoteNumber(carrierApp);
        return new ResponseEntity<>(connote, HttpStatus.OK);
    }
}
