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

    @Test
    public void testEqualConsecutiveLatinChars_EmptyString() {
        assertEquals(instance.maxNumberEqualConsecutiveIdenticalLatinAlphabetChars(""), 0, "Empty string doesn't produce '0' as a result");
    }

    @Test
    public void testEqualConsecutiveLatinChars_NullString() {
        assertEquals(instance.maxNumberEqualConsecutiveIdenticalLatinAlphabetChars(null), 0, "Null string doesn't produce '0' as a result");
    }

    @Test
    public void testEqualConsecutiveLatinChars_AllUniqueChars() {
        assertEquals(instance.maxNumberEqualConsecutiveIdenticalLatinAlphabetChars("abcdefg"), 0, "Entirely unique string should produce '0' as a result.");
    }

    @Test
    public void testEqualConsecutiveLatinChars_AllUniqueCharactersStringWithSymbols() {
        assertEquals(instance.maxNumberEqualConsecutiveIdenticalLatinAlphabetChars("123!_@#%$kji9)"), 0, "A string with numbers and symbols and no consecutive latin symbols should produce '0' as a result.");
    }
    @Test
    public void testEqualConsecutiveLatinChars_StringWithDigitsAndSymbols() {
        assertEquals(instance.maxNumberEqualConsecutiveIdenticalLatinAlphabetChars("123!_@#%$KKKji9)"), 3, "A string with numbers and symbols should count consecutive chars correctly.");
    }

    @Test
    public void testEqualConsecutiveLatinChars_AllCharsEqualString() {
        String sameChars = "sssssss";
        assertEquals(instance.maxNumberEqualConsecutiveIdenticalLatinAlphabetChars(sameChars), sameChars.length(), "All the same characters in the string should produce string lengths as a result");
    }

    @Test
    public void testEqualConsecutiveLatinChars_OneCharacterString() {
        assertEquals(instance.maxNumberEqualConsecutiveIdenticalLatinAlphabetChars("A"), 1, "One character string should count the longest sequence correctly");
    }

    @Test
    public void testEqualConsecutiveLatinChars_RepeatingUniqueSequenceString() {
        String sample = "ab";
        String testString = sample.repeat(100);
        assertEquals(instance.maxNumberEqualConsecutiveIdenticalLatinAlphabetChars(testString), 0, "Alternating characters should return 0, i.e. - 'ab'");
        assertEquals(instance.maxNumberEqualConsecutiveIdenticalLatinAlphabetChars("ab"), 0, "Alternating characters should return 0, i.e. - 'ab'");
    }

    @Test
    public void testEqualConsecutiveLatinChars_StartsWithRepetitionString() {
        assertEquals(instance.maxNumberEqualConsecutiveIdenticalLatinAlphabetChars("SSSasdfghhj"), 3, "A string starting with repeated characters should count the longest sequence correctly.");
    }

    @Test
    public void testEqualConsecutiveLatinChars_EndsWithRepetitionString() {
        assertEquals(instance.maxNumberEqualConsecutiveIdenticalLatinAlphabetChars("abcdeefgSSS"), 3, "A string ending with repeated characters should count the longest sequence correctly.");
    }

    @Test
    public void testEqualConsecutiveLatinChars_RepetitionInTheMiddleString() {
        assertEquals(instance.maxNumberEqualConsecutiveIdenticalLatinAlphabetChars("aasdfghjSSSjgkg"), 3, "A string with repeated characters in the middle should count the longest sequence correctly.");
    }

    @Test
    public void testEqualConsecutiveLatinChars_StringWithSpaces() {
        assertEquals(instance.maxNumberEqualConsecutiveIdenticalLatinAlphabetChars("asd bFFFg    lk "), 3, "A string with spaces should count the longest sequence correctly.");
    }

    @Test
    public void testEqualConsecutiveLatinChars_LongString() {
        String longInput = "aBBBcdefgi".repeat(1000);
        assertEquals(instance.maxNumberEqualConsecutiveIdenticalLatinAlphabetChars("aBBBcdefgi"), 3, "A long unique character string should return its base's full length.");
        assertEquals(instance.maxNumberEqualConsecutiveIdenticalLatinAlphabetChars(longInput), 3, "A long unique character string should return its base's full length.");
    }
}