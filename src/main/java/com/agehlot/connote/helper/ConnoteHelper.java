package com.agehlot.connote.helper;

public class ConnoteHelper {

    private static final int MULTIPLY_FIRST_SUM = 3;
    private static final int MULTIPLY_SECOND_SUM = 7;
    private static final int NEXT_MULTIPLE_OF = 10;

    /**
     * Defining private constructor to hide the implicit public one
     */
    private ConnoteHelper() {
        throw new IllegalStateException("Utilitiy class");
    }

    /**
     * Utility method to sum digits of the string passed
     * 
     * @param digiStr
     * @param startIndex
     * @param jump
     * @return
     */
    public static int sumDigits(String digiStr, int startIndex, int jump) {
        int sum = 0;
        int i = digiStr.length() - startIndex - 1;
        for (; i > 0; i -= jump) {
            sum += Character.getNumericValue(digiStr.charAt(i));
        }
        return sum;
    }

    /**
     * Method to get the difference between that number and the next multiple of
     * digits
     * 
     * @param num
     * @param digits
     * @return
     */
    public static int getDifferenceFromNextMultiple(int num) {
        return NEXT_MULTIPLE_OF - (num % NEXT_MULTIPLE_OF);
    }

    /**
     * Method to calculate the check sum by performing sum, addition and remainder
     * calculation
     * 
     * @param newPaddedIndex
     * @param digits
     * @return
     */
    public static int checkSum(String newPaddedIndex) {
        // Adding every second number in the index from the right starting at the first
        // element
        int sum = sumDigits(newPaddedIndex, 0, 2);
        // Multiply that number by 3
        sum *= MULTIPLY_FIRST_SUM;
        // Adding every second number in the index from the right starting at the second
        // element
        int sum2 = sumDigits(newPaddedIndex, 1, 2);
        // Multiply that number by 7
        sum2 *= MULTIPLY_SECOND_SUM;
        // Add the results of step 1 and step 2
        sum += sum2;
        // Get the difference between that number and the next multiple of 10
        return getDifferenceFromNextMultiple(sum);
    }
}
