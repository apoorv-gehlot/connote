package com.agehlot.connote.model;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotEmpty;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class CarrierAccount {

    private String carrierName;

    @NotEmpty(message = "Carrier prefix cannot be null/empty")
    private String prefix;

    @NotEmpty(message = "Carrier account number cannot be null/empty")
    private String accountNumber;

    @Min(value=6, message = "Digits cannot be less than 6")
    private int digits;

    @Min(value=1, message = "Last used index cannot be less than 1")
    private int lastUsedIndex;

    @Min(value=1, message = "Range start cannot be less than 1")
    private int rangeStart;

    @Min(value=1, message = "Range end cannot be less than 1")
    private int rangeEnd;
}
