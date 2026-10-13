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
    void slugifyNullIsNull() {
        assertNull(TextUtils.slugify(null));
    }

    @Test
    void slugifyEmptyIsEmpty() {
        assertEquals("", TextUtils.slugify(""));
    }

    @Test
    void slugifyOnlySeparatorsIsEmpty() {
        assertEquals("", TextUtils.slugify("---   ***"));
    }

    @Test
    void slugifyRemovesVietnameseDiacriticsAndDStroke() {
        assertEquals("da-nang", TextUtils.slugify("Đà Nẵng"));
    }

    @Test
    void slugifyHandlesPunctuationAndExtraSpaces() {
        assertEquals("xin-chao-viet-nam", TextUtils.slugify("  Xin chào, Việt Nam!  "));
    }

    @Test
    void slugifyCollapsesConsecutiveSeparators() {
        assertEquals("c-java-17", TextUtils.slugify("C++ & Java 17"));
    }

    @Test
    void slugifyLowercasesAsciiText() {
        assertEquals("hello-world", TextUtils.slugify("Hello   World"));
    }
}
