package com.epam.training.serhii_klymenko.task3;

import com.epam.training.serhii_klymenko.task3.util.CountingUtils;

import java.util.regex.Pattern;

public class CountingMethods {

    public int maxNumberUnequalConsecutiveChars(String inputString) {
        Integer x = CountingUtils.checkForEmptyNullSingleChar(inputString);
        if (x != null) return x;

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


    public int maxNumberEqualConsecutiveIdenticalLatinAlphabetChars(String inputString) {
        Integer x = CountingUtils.checkForEmptyNullSingleChar(inputString);
        if (x != null) return x;

        int result = 0;
        int tmpResult = 1;
        boolean hasDifferentChars = false;
        Pattern pattern = Pattern.compile("[A-Za-z]");

        for (int i = 1; i < inputString.length(); i++) {
            char prevChar = inputString.charAt(i - 1);
            char currChar = inputString.charAt(i);

            boolean isPrevLatin = pattern.matcher(String.valueOf(prevChar)).matches();
            boolean isCurrentLatin = pattern.matcher(String.valueOf(currChar)).matches();

            if (isPrevLatin && isCurrentLatin && prevChar == currChar) {
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

    public int maxNumberConsecutiveIdenticalDigitChars(String inputString) {
        Integer x = CountingUtils.checkForEmptyNullSingleChar(inputString);
        if (x != null) return x;

        int result = 0;
        int tmpResult = 1;
        boolean hasDifferentChars = false;
        Pattern pattern = Pattern.compile("\\d");

        for (int i = 1; i < inputString.length(); i++) {
            char prevChar = inputString.charAt(i - 1);
            char currChar = inputString.charAt(i);

            boolean isPrevLatin = pattern.matcher(String.valueOf(prevChar)).matches();
            boolean isCurrentLatin = pattern.matcher(String.valueOf(currChar)).matches();

            if (isPrevLatin && isCurrentLatin && prevChar != currChar) {
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

}