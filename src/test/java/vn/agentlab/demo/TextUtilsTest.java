package vn.agentlab.demo;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Timeout;

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

    /** Văn bản gõ tay: các từ cách nhau bằng dấu cách thường U+0020. */
    @Test
    void countsWordsTypedByHand() {
        assertEquals(4, TextUtils.wordCount("Xin chào Việt Nam"));
    }

    /**
     * Tái hiện đúng chuỗi trong editor.log (paste source=web): dấu phân tách là
     * khoảng trắng không ngắt NBSP (U+00A0) nên trước đây chỉ đếm được 2 từ.
     */
    @Test
    void countsWordsPastedFromWebWithNonBreakingSpace() {
        assertEquals(4, TextUtils.wordCount("Xin chào\u00A0Việt\u00A0Nam"));
    }

    /** Các loại khoảng trắng Unicode khác cũng hay gặp khi copy từ web. */
    @Test
    void countsWordsSeparatedByOtherUnicodeSpaces() {
        assertEquals(4, TextUtils.wordCount("Xin\u2009chào\u202FViệt\u2007Nam"));
    }

    /** Khoảng trắng Unicode ở hai đầu không được tính thành từ rỗng. */
    @Test
    void trimsLeadingAndTrailingUnicodeWhitespace() {
        assertEquals(2, TextUtils.wordCount("\u00A0Xin chào\u00A0"));
    }

    /** Chuỗi chỉ gồm NBSP vẫn là 0 từ. */
    @Test
    void nonBreakingSpaceOnlyHasZeroWords() {
        assertEquals(0, TextUtils.wordCount("\u00A0\u00A0"));
    }

    @Test
    void nullHasZeroWords() {
        assertEquals(0, TextUtils.wordCount(null));
    }

    @Test
    void emptyStringHasZeroWords() {
        assertEquals(0, TextUtils.wordCount(""));
    }

    /** Tab v\u00E0 xu\u1ED1ng d\u00F2ng c\u0169ng l\u00E0 k\u00FD t\u1EF1 ph\u00E2n t\u00E1ch t\u1EEB. */
    @Test
    void countsWordsSeparatedByTabsAndNewlines() {
        assertEquals(4, TextUtils.wordCount("\tXin\tch\u00E0o\r\nVi\u1EC7t\nNam\n"));
    }

    /** T\u1EEB ch\u1EE9a k\u00FD t\u1EF1 ngo\u00E0i BMP (c\u1EB7p surrogate) ch\u1EC9 \u0111\u01B0\u1EE3c t\u00EDnh l\u00E0 m\u1ED9t t\u1EEB. */
    @Test
    void countsWordOutsideBasicMultilingualPlane() {
        assertEquals(2, TextUtils.wordCount("ch\u00E0o \uD83C\uDF1F\uD83C\uDF1F"));
    }

    /**
     * \u0110o\u1EA1n kho\u1EA3ng tr\u1EAFng r\u1EA5t d\u00E0i gi\u1EEFa hai t\u1EEB: v\u1EABn l\u00E0 2 t\u1EEB v\u00E0 ph\u1EA3i tr\u1EA3 k\u1EBFt qu\u1EA3
     * nhanh. C\u00E1ch c\u0169 ("^\\s+|\\s+$") backtrack b\u1EADc hai n\u00EAn m\u1EA5t h\u00E0ng gi\u00E2y.
     */
    @Test
    @Timeout(5)
    void longWhitespaceRunBetweenWordsIsFast() {
        assertEquals(2, TextUtils.wordCount("a" + " ".repeat(100_000) + "b"));
    }
}
