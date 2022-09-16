package com.agehlot.connote.model;

import lombok.Data;

@Data
public class CarrierApplication {
    private String carrierName;
    private String prefix;
    private String accountNumber;
    private int digits;
    private int lastUsedIndex;
    private int rangeStart;
    private int rangeEnd;
}
