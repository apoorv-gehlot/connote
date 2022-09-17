package com.agehlot.connote.controller;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import com.agehlot.connote.model.CarrierAccount;
import com.agehlot.connote.service.ConnoteService;
import com.fasterxml.jackson.databind.ObjectMapper;

@SpringBootTest
@AutoConfigureMockMvc
public class ConnoteControllerTest {

    @Autowired
    private MockMvc mvc;

    @MockBean
    private ConnoteService connoteService;

    @Autowired
    private ObjectMapper objectMapper;

    private CarrierAccount CARRIER_APP = new CarrierAccount("FreightmateCourierCo",
            "FMCC", "123ABC", 10,
            19604, 19000, 20000);

    @Test
    public void givenNoData_thenSendBadRequestStatus() throws Exception {
        this.mvc.perform(get("/v1/connote"))
                .andExpect(status().isBadRequest());
    }

    @Test
    public void givenCarrierAccount_thenReturnNextConnoteNumber() throws Exception {
        String requestJson = objectMapper.writeValueAsString(CARRIER_APP);
        this.mvc.perform(get("/v1/connote")
                .contentType(MediaType.APPLICATION_JSON).content(requestJson)).andExpect(status().isOk());
    }

    @Test
    public void givenBlankCarrierAccount_thenReturnFieldErrors() throws Exception {
        CarrierAccount blankCarrierObj = new CarrierAccount("",
                "", "", 0,
                0, 0, 0);

        String requestJson = objectMapper.writeValueAsString(blankCarrierObj);
        this.mvc.perform(get("/v1/connote")
                .contentType(MediaType.APPLICATION_JSON).content(requestJson)).andExpect(status().isBadRequest());
    }
}
