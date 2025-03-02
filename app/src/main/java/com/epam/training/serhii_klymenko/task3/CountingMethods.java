package com.epam.training.serhii_klymenko.task3;

public class CountingMethods {
    public int maxNumberUnequalConsecutiveChars(String inputString) {
        if (inputString == null || inputString.length() == 0) {
            return 0;
        }

        if (inputString.length() == 1) {
            return 1;
        }

        int result = 0;
        int tmpResult = 1;
        boolean hasDifferentChars = false;
        for (int i = 1; i < inputString.length(); i++) {
            if (inputString.charAt(i - 1) != inputString.charAt(i)) {
                tmpResult++;
                hasDifferentChars = true;
            } else {
                if (tmpResult > result) {
                    result = tmpResult;
                }
                tmpResult = 1;
            }
        }
        result = Math.max(result, tmpResult);
        return hasDifferentChars ? result : 0;
    }

    public int maxNumberUnequalConsecutiveIdenticalLatinAlphabetChars(String inputString) {
        //placeholder to TDD process
        return 0;
    }
}