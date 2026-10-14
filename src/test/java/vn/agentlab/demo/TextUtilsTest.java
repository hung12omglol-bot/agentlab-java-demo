package vn.agentlab.demo;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;

import org.junit.jupiter.api.Test;

class TextUtilsTest {

    @Test
    void reversesString() {
        assertEquals("cba", TextUtils.reverse("abc"));
    }

    @Test
    void reverseNullIsNull() {
        assertNull(TextUtils.reverse(null));
    }

    @Test
    void countsWords() {
        assertEquals(3, TextUtils.wordCount("  xin   chao  ban "));
    }

    @Test
    void blankHasZeroWords() {
        assertEquals(0, TextUtils.wordCount("   "));
    }

    @Test
    void countsVowels() {
        assertEquals(5, TextUtils.countVowels("xin chao cac ban"));
    }

    @Test
    void countsUppercaseVowels() {
        assertEquals(5, TextUtils.countVowels("AEIOU"));
        assertEquals(4, TextUtils.countVowels("JaVa Is OK"));
    }

    @Test
    void countVowelsIgnoresNonVowels() {
        assertEquals(0, TextUtils.countVowels("xyz 123 !?"));
    }

    @Test
    void countVowelsNullOrEmptyIsZero() {
        assertEquals(0, TextUtils.countVowels(null));
        assertEquals(0, TextUtils.countVowels(""));
    }
}
