package com.agehlot.connote.service;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.agehlot.connote.model.CarrierAccount;

@SpringBootTest
public class ConnoteServiceTest {

    @Autowired
    ConnoteService connoteService;

    private CarrierAccount CARRIER_APP = new CarrierAccount("FreightmateCourierCo",
            "FMCC", "123ABC", 10,
            19604, 19000, 20000);

    @Test
    public void whenCarrierAccountIsProvided_thenReturnNextConnoteNumber() {
        assertEquals("FMCC123ABC00000196051", connoteService.generateNextConnoteNumber(CARRIER_APP));
    }

    @Test
    public void whenLastUsedIndexIsSmallThanRangeStart_thenReturnValidationMessage() {
        CARRIER_APP.setLastUsedIndex(18998);
        assertEquals("Range validation violated!", connoteService.generateNextConnoteNumber(CARRIER_APP));
    }

    @Test
    public void whenLastUsedIndexIsLargeThanRangeEnd_thenReturnValidationMessage() {
        CARRIER_APP.setLastUsedIndex(20000);
        assertEquals("Range validation violated!", connoteService.generateNextConnoteNumber(CARRIER_APP));
    }

    @Test
    public void whenCarrierAccountHasNineDigits_thenReturnNextConnoteNumber(){
        CarrierAccount carrierApp = new CarrierAccount("FreightmateCourierCo",
        "FMCC", "123ABC", 9,
        19604, 19000, 20000);
        assertEquals("FMCC123ABC0000196051", connoteService.generateNextConnoteNumber(carrierApp));
    }
}
