package vn.agentlab.demo;

import java.text.Normalizer;

/** Tiện ích xử lý chuỗi. */
public final class TextUtils {

    private TextUtils() {
    }

    /**
     * Chuyển chuỗi thành "slug" dùng trong URL: bỏ dấu, chữ thường, các ký tự
     * không phải a-z/0-9 trở thành "-", gộp "-" liên tiếp và bỏ "-" ở đầu/cuối.
     */
    public static String slugify(String s) {
        if (s == null) {
            return null;
        }
        String normalized = Normalizer.normalize(s, Normalizer.Form.NFD)
                .replaceAll("\\p{M}", "")
                .replace('Đ', 'D')
                .replace('đ', 'd')
                .toLowerCase();
        return normalized.replaceAll("[^a-z0-9]+", "-").replaceAll("^-+|-+$", "");
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
}
