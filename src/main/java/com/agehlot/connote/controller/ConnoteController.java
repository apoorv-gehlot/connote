package com.agehlot.connote.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.agehlot.connote.model.CarrierApplication;
import com.agehlot.connote.service.ConnoteService;

@RestController
@RequestMapping("/v1")
public class ConnoteController {
    @Autowired
    ConnoteService connoteService;

    @GetMapping("/generate")
    public String generateConnote(@RequestBody CarrierApplication carrierApp){
        return connoteService.generateNextConnoteNumber(carrierApp);
    }
}
