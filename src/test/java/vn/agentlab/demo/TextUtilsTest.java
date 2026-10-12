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
    void capitalizeWordsNullIsNull() {
        assertNull(TextUtils.capitalizeWords(null));
    }

    @Test
    void capitalizeWordsEmptyIsEmpty() {
        assertEquals("", TextUtils.capitalizeWords(""));
    }

    @Test
    void capitalizeWordsSimple() {
        assertEquals("Xin Chao Ban", TextUtils.capitalizeWords("xin chao ban"));
    }

    @Test
    void capitalizeWordsVietnameseCity() {
        assertEquals("Đà Nẵng", TextUtils.capitalizeWords("đà nẵng"));
    }

    @Test
    void capitalizeWordsPreservesWhitespace() {
        assertEquals("Ông  Ba\tBình", TextUtils.capitalizeWords("ông  ba\tbình"));
    }

    @Test
    void capitalizeWordsDoesNotLowercaseRestOfWord() {
        assertEquals("HELLO World", TextUtils.capitalizeWords("HELLO world"));
    }

    @Test
    void capitalizeWordsBlankIsUnchanged() {
        assertEquals("   ", TextUtils.capitalizeWords("   "));
    }

    @Test
    void capitalizeWordsWordStartingWithDigitOrSymbolIsUnchanged() {
        assertEquals("123abc", TextUtils.capitalizeWords("123abc"));
        assertEquals("@domain", TextUtils.capitalizeWords("@domain"));
    }
}
