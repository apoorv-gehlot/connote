package com.agehlot.connote.service;

import org.springframework.stereotype.Service;

import com.agehlot.connote.helper.ConnoteHelper;
import com.agehlot.connote.model.CarrierAccount;

@Service
public class ConnoteService {
    
    /**
     * Method to accept the carrier account object and generates the next connote
     * number in that series.
     * 
     * @param carrierApp
     * @return
     */
    public String generateNextConnoteNumber(CarrierAccount carrierApp) {
        StringBuilder code = new StringBuilder();
        // add the prefix
        code.append(carrierApp.getPrefix());
        // add the account name
        code.append(carrierApp.getAccountNumber());
        // get next index and validate it
        int newIndex = carrierApp.getLastUsedIndex();
        newIndex++;

        if (carrierApp.getRangeStart() > newIndex || carrierApp.getRangeEnd() < newIndex)
            return "Range validation violated!";

        // add additional '0 to make the index "Digits" characters long
        String paddFormat = "%0" + carrierApp.getDigits() + "d";
        String nextPaddedString = String.format(paddFormat, newIndex);
        code.append(nextPaddedString);

        // calculate the check sum for the new index with padding
        int checkSum = ConnoteHelper.checkSum(nextPaddedString);
        code.append(checkSum);

        return code.toString();
    }
}
