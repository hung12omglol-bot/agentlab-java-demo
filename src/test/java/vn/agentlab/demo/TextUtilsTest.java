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
}
