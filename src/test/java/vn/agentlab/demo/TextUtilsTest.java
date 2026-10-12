package vn.agentlab.demo;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

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
    void palindromeNullIsFalse() {
        assertFalse(TextUtils.isPalindrome(null));
    }

    @Test
    void palindromeEmptyIsTrue() {
        assertTrue(TextUtils.isPalindrome(""));
    }

    @Test
    void palindromeOnlyPunctuationIsTrue() {
        assertTrue(TextUtils.isPalindrome("  , . !  "));
    }

    @Test
    void palindromeIgnoresCaseSpaceAndPunctuation() {
        assertTrue(TextUtils.isPalindrome("A man, a plan, a canal: Panama"));
    }

    @Test
    void nonPalindromeReturnsFalse() {
        assertFalse(TextUtils.isPalindrome("race a car"));
    }

    @Test
    void singleCharIsPalindrome() {
        assertTrue(TextUtils.isPalindrome("a"));
    }

    @Test
    void vietnameseDiacriticsAreNotStripped() {
        assertFalse(TextUtils.isPalindrome("Đi đôi"));
    }
}
