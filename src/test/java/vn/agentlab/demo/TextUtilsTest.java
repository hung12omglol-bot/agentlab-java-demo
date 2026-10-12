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
    void isPalindromeNullReturnsFalse() {
        assertFalse(TextUtils.isPalindrome(null));
    }

    @Test
    void isPalindromeEmptyReturnsTrue() {
        assertTrue(TextUtils.isPalindrome(""));
    }

    @Test
    void isPalindromeWhitespaceOrPunctuationOnlyReturnsTrue() {
        assertTrue(TextUtils.isPalindrome("   "));
        assertTrue(TextUtils.isPalindrome(".,;: !?"));
    }

    @Test
    void isPalindromeValidPhrases() {
        assertTrue(TextUtils.isPalindrome("A man, a plan, a canal: Panama"));
        assertTrue(TextUtils.isPalindrome("Madam, I'm Adam"));
        assertTrue(TextUtils.isPalindrome("12321"));
    }

    @Test
    void isPalindromeInvalidPhrases() {
        assertFalse(TextUtils.isPalindrome("race a car"));
        assertFalse(TextUtils.isPalindrome("hello world"));
        assertFalse(TextUtils.isPalindrome("123421"));
    }

    @Test
    void isPalindromeVietnameseNonPalindrome() {
        // "Đi đôi" -> các ký tự: đ, i, đ, ô, i -> ngược lại là i, ô, đ, i, đ -> false
        assertFalse(TextUtils.isPalindrome("Đi đôi"));
    }

    @Test
    void isPalindromeVietnamesePalindrome() {
        // Ký tự tiếng Việt đối xứng sau khi chuẩn hóa chữ thường và bỏ dấu câu/khoảng trắng
        assertTrue(TextUtils.isPalindrome("Bà... à, B"));
    }

    @Test
    void isPalindromeSupplementaryCharactersOutsideBmp() {
        // Ký tự Unicode ngoài BMP (surrogate pairs): U+10400 (𐐀) và U+10428 (𐐨) thuộc Deseret alphabet
        assertTrue(TextUtils.isPalindrome("𐐀 a 𐐨"));
        assertTrue(TextUtils.isPalindrome("𐐀𐐀"));
        assertFalse(TextUtils.isPalindrome("𐐀 a 𐐁"));
    }
}
