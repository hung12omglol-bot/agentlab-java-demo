package vn.agentlab.demo;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;

import java.util.Locale;
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
        assertEquals("dd", TextUtils.slugify("Đđ"));
    }

    @Test
    void slugifyIsLocaleIndependent() {
        Locale previous = Locale.getDefault();
        try {
            Locale.setDefault(new Locale("tr", "TR"));
            assertEquals("i", TextUtils.slugify("I"));
        } finally {
            Locale.setDefault(previous);
        }
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
