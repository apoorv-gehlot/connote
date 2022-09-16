package com.agehlot.connote.helper;

public class ConnoteHelper {

    /**
     * Defining private constructor to hide the implicit public one
     */
    private ConnoteHelper() {
        throw new IllegalStateException("Utilitiy class");
    }

    /**
     * Utility method to sum digits of the string passed and return multiplication
     * 
     * @param digiStr
     * @param startIndex
     * @param jump
     * @param multiplyBy
     * @return
     */
    public static int sumDigitsAndMultiply(String digiStr, int startIndex, int jump, int multiplyBy) {
        int sum = 0;
        int i = digiStr.length() - startIndex - 1;
        for (; i > 0; i -= jump) {
            sum += Character.getNumericValue(digiStr.charAt(i));
        }
        return sum * multiplyBy;
    }

    /**
     * Method to calculate the check sum by sum, addition and remainder calculation
     * 
     * @param newPaddedIndex
     * @param digits
     * @return
     */
    public static int checkSum(String newPaddedIndex, int digits) {
        int sum = sumDigitsAndMultiply(newPaddedIndex, 0, 2, 3);
        sum += sumDigitsAndMultiply(newPaddedIndex, 1, 2, 7);
        // get mod for next multiple of 10
        return digits - (sum % 10);
    }
}
