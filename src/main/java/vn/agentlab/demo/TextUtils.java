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

    /** Đếm số nguyên âm (a, e, i, o, u), tính cả chữ hoa. */
    public static int countVowels(String s) {
        if (s == null) {
            return 0;
        }
        int count = 0;
        for (int i = 0; i < s.length(); i++) {
            if ("aeiou".indexOf(Character.toLowerCase(s.charAt(i))) >= 0) {
                count++;
            }
        }
        return count;
    }
}
