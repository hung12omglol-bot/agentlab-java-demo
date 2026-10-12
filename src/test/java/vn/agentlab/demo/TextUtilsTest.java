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
}
