package vn.agentlab.demo;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/** Tiện ích xử lý chuỗi. */
public final class TextUtils {

    /**
     * Một "từ" là chuỗi ký tự không phải khoảng trắng. Mặc định "\s"/"\S" của
     * Java chỉ xét [ \t\n\x0B\f\r], bỏ sót NBSP (U+00A0) và các khoảng trắng
     * khác hay đi kèm văn bản copy từ trang web; cờ UNICODE_CHARACTER_CLASS
     * khắc phục điều đó. Đếm trực tiếp các lần khớp "\S+" nên không cần trim
     * và chỉ duyệt chuỗi một lượt.
     */
    private static final Pattern WORD =
            Pattern.compile("\\S+", Pattern.UNICODE_CHARACTER_CLASS);

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
        Matcher matcher = WORD.matcher(s);
        int count = 0;
        while (matcher.find()) {
            count++;
        }
        return count;
    }
}
