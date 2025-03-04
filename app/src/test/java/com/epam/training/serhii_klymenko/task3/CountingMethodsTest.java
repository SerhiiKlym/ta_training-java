package com.epam.training.serhii_klymenko.task3;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;

public class CountingMethodsTest {
    private CountingMethods instance;

    @BeforeClass
    public void instance() {
        instance = new CountingMethods();
    }

    @Test
    public void testUnequalConsecutiveChars_EmptyString() {
        assertEquals(instance.maxNumberUnequalConsecutiveChars(""), 0, "Empty string doesn't produce '0' as a result");
    }

    @Test
    public void testUnequalConsecutiveChars_NullString() {
        assertEquals(instance.maxNumberUnequalConsecutiveChars(null), 0, "Null string doesn't produce '0' as a result");
    }

    @Test
    public void testUnequalConsecutiveChars_AllUniqueChars() {
        assertEquals(instance.maxNumberUnequalConsecutiveChars("abcdefg"), 7, "Entirely unique string should count the longest sequence correctly.");
    }

    @Test
    public void testUnequalConsecutiveChars_AllUniqueCharactersStringWithSymbols() {
        assertEquals(instance.maxNumberUnequalConsecutiveChars("123!_@#%$kji9)"), 14, "A string with numbers and symbols should return its full length.");
    }

    @Test
    public void testUnequalConsecutiveChars_AllCharsEqualString() {
        assertEquals(instance.maxNumberUnequalConsecutiveChars("sssssss"), 0, "All the same characters in the string should produce '0' as a result");
    }

    @Test
    public void testUnequalConsecutiveChars_OneCharacterString() {
        assertEquals(instance.maxNumberUnequalConsecutiveChars("A"), 1, "One character string should count the longest sequence correctly");
    }

    @Test
    public void testUnequalConsecutiveChars_RepeatingUniqueSequenceString() {
        String testString = "ab".repeat(100);
        assertEquals(instance.maxNumberUnequalConsecutiveChars(testString), 200, "Alternating characters should return the full length.");
    }

    @Test
    public void testUnequalConsecutiveChars_StartsWithRepetitionString() {
        assertEquals(instance.maxNumberUnequalConsecutiveChars("SSSasdfghj"), 8, "A string starting with repeated characters should count the longest sequence correctly.");
    }

    @Test
    public void testUnequalConsecutiveChars_EndsWithRepetitionString() {
        assertEquals(instance.maxNumberUnequalConsecutiveChars("abcdefgSSS"), 8, "A string ending with repeated characters should count the longest sequence correctly.");
    }

    @Test
    public void testUnequalConsecutiveChars_RepetitionInTheMiddleString() {
        assertEquals(instance.maxNumberUnequalConsecutiveChars("asdfghjSSSjgkg"), 8, "A string with repeated characters in the middle should count the longest sequence correctly.");
    }

    @Test
    public void testUnequalConsecutiveChars_StringWithSpaces() {
        assertEquals(instance.maxNumberUnequalConsecutiveChars("asd bfg  lk "), 8, "A string with spaces should count the longest sequence correctly.");
    }

    @Test
    public void testUnequalConsecutiveChars_LongString() {
        String longInput = "abcdefgi".repeat(1000);
        assertEquals(instance.maxNumberUnequalConsecutiveChars(longInput), 8000, "A long unique character string should return its full length.");
    }
}