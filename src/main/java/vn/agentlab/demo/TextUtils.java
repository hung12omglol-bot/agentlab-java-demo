package vn.agentlab.demo;

import java.util.regex.Pattern;

/** Tiện ích xử lý chuỗi. */
public final class TextUtils {

    /**
     * Khoảng trắng theo chuẩn Unicode. Mặc định "\s" của Java chỉ khớp
     * [ \t\n\x0B\f\r], bỏ sót NBSP (U+00A0) và các khoảng trắng khác hay đi kèm
     * văn bản copy từ trang web; cờ UNICODE_CHARACTER_CLASS khắc phục điều đó.
     */
    private static final Pattern WHITESPACE =
            Pattern.compile("\\s+", Pattern.UNICODE_CHARACTER_CLASS);

    private static final Pattern EDGE_WHITESPACE =
            Pattern.compile("^\\s+|\\s+$", Pattern.UNICODE_CHARACTER_CLASS);

    private TextUtils() {
    }

    public static String reverse(String s) {
        if (s == null) {
            return null;
        }
        return new StringBuilder(s).reverse().toString();
    }

    /** Đếm số từ, phân tách bởi khoảng trắng (kể cả khoảng trắng Unicode). */
    public static int wordCount(String s) {
        if (s == null) {
            return 0;
        }
        String trimmed = EDGE_WHITESPACE.matcher(s).replaceAll("");
        if (trimmed.isEmpty()) {
            return 0;
        }
        return WHITESPACE.split(trimmed).length;
    }
}
