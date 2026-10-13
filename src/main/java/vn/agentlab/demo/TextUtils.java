package vn.agentlab.demo;

import java.text.Normalizer;
import java.util.Locale;
import java.util.regex.Pattern;

/** Tiện ích xử lý chuỗi. */
public final class TextUtils {

    private static final Pattern DIACRITICS = Pattern.compile("\\p{M}");
    private static final Pattern NON_ALNUM = Pattern.compile("[^a-z0-9]+");
    private static final Pattern EDGE_DASHES = Pattern.compile("^-+|-+$");

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
        String normalized = DIACRITICS.matcher(Normalizer.normalize(s, Normalizer.Form.NFD))
                .replaceAll("")
                .replace('Đ', 'D')
                .replace('đ', 'd')
                .toLowerCase(Locale.ROOT);
        String withDashes = NON_ALNUM.matcher(normalized).replaceAll("-");
        return EDGE_DASHES.matcher(withDashes).replaceAll("");
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
