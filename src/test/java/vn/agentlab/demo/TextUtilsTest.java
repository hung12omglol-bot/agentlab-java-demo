package vn.agentlab.demo;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertFalse;
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
    void nullIsNotPalindrome() {
        assertFalse(TextUtils.isPalindrome(null));
    }

    @Test
    void emptyIsPalindrome() {
        assertTrue(TextUtils.isPalindrome(""));
    }

    @Test
    void ignoresWhitespaceAndPunctuation() {
        assertTrue(TextUtils.isPalindrome(" \t\n.,:!?—"));
    }

    @Test
    void ignoresCaseAndSeparators() {
        assertTrue(TextUtils.isPalindrome("A man, a plan, a canal: Panama"));
    }

    @Test
    void rejectsNonPalindrome() {
        assertFalse(TextUtils.isPalindrome("race a car"));
    }

    @Test
    void includesDigits() {
        assertTrue(TextUtils.isPalindrome("1a2A1"));
        assertFalse(TextUtils.isPalindrome("1a2"));
    }

    @Test
    void preservesVietnameseAccents() {
        assertFalse(TextUtils.isPalindrome("Đi đôi"));
        assertFalse(TextUtils.isPalindrome("oô"));
        assertTrue(TextUtils.isPalindrome("Ô!ô"));
    }

    @Test
    void supportsSupplementaryUnicodeLetters() {
        assertTrue(TextUtils.isPalindrome("\uD801\uDC00!\uD801\uDC28"));
        assertFalse(TextUtils.isPalindrome("\uD801\uDC00a"));
    }
}
