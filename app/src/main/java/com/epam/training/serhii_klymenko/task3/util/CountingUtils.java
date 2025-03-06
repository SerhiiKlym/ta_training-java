package com.epam.training.serhii_klymenko.task3.util;

public class CountingUtils {
    public static Integer checkForEmptyNullSingleChar(String inputString) {
        if (inputString == null || inputString.length() == 0) {
            return 0;
        }

        if (inputString.length() == 1) {
            return 1;
        }
        return null;
    }
}
