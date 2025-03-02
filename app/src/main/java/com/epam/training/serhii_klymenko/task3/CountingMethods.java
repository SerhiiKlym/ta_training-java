package com.epam.training.serhii_klymenko.task3;

public class CountingMethods {
    public int maxNumberUnequalConsecutiveChars(String inputString) {
        if (inputString == null || inputString.length() == 0){
            return 0;
        }

        int result = 0;
        int tmpResult = 1;
        for (int i = 1; i < inputString.length(); i++) {
            if (inputString.charAt(i - 1) != inputString.charAt(i)) {
                tmpResult++;
            } else {
                if (tmpResult > result) {
                    result = tmpResult;
                }
                tmpResult = 1;
            }
        }
        return Math.max(result, tmpResult);
    }
}
