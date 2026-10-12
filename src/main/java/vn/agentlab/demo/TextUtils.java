package vn.agentlab.demo;

/** Tiện ích xử lý chuỗi. */
public final class TextUtils {

    private TextUtils() {
    }

    public static String reverse(String s) {
        if (s == null) {
            return null;
        }
        return new StringBuilder(s).reverse().toString();
    }

    /** Đếm số từ, phân tách bởi khoảng trắng. */
    public static int wordCount(String s) {
        if (s == null || s.isBlank()) {
            return 0;
        }
        return s.trim().split("\\s+").length;
    }

    /**
     * Viết hoa chữ cái đầu của mỗi từ, giữ nguyên các chữ còn lại và mọi khoảng trắng gốc.
     * "Từ" là chuỗi ký tự liên tiếp không phải khoảng trắng ({@link Character#isWhitespace}).
     */
    public static String capitalizeWords(String s) {
        if (s == null || s.isEmpty()) {
            return s;
        }
        StringBuilder result = new StringBuilder(s.length());
        boolean startOfWord = true;
        int i = 0;
        while (i < s.length()) {
            int cp = s.codePointAt(i);
            if (Character.isWhitespace(cp)) {
                result.appendCodePoint(cp);
                startOfWord = true;
            } else {
                result.appendCodePoint(startOfWord ? Character.toUpperCase(cp) : cp);
                startOfWord = false;
            }
            i += Character.charCount(cp);
        }
        return result.toString();
    }
}
