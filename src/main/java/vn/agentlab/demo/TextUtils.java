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
     * Kiểm tra {@code s} có phải chuỗi đối xứng (palindrome) hay không, chỉ xét các ký tự
     * là chữ cái hoặc chữ số ({@link Character#isLetterOrDigit(char)}), bỏ qua khoảng trắng,
     * dấu câu và không phân biệt hoa/thường (so sánh sau khi {@link Character#toLowerCase(char)}).
     *
     * <p>Chữ cái có dấu (ví dụ tiếng Việt như "Đ", "ô") được giữ nguyên dấu khi so sánh,
     * không bỏ dấu phụ âm/thanh điệu; ví dụ {@code "Đi đôi"} trả về {@code false} vì chuỗi
     * đã chuẩn hoá "điđôi" không đối xứng.
     *
     * @param s chuỗi cần kiểm tra; {@code null} trả về {@code false}
     * @return {@code true} nếu {@code s} đối xứng theo quy tắc trên; {@code false} nếu
     *     {@code s} là {@code null} hoặc không đối xứng. Chuỗi rỗng hoặc chỉ gồm khoảng
     *     trắng/dấu câu trả về {@code true}.
     */
    public static boolean isPalindrome(String s) {
        if (s == null) {
            return false;
        }
        int left = 0;
        int right = s.length() - 1;
        while (left < right) {
            char leftChar = s.charAt(left);
            if (!Character.isLetterOrDigit(leftChar)) {
                left++;
                continue;
            }
            char rightChar = s.charAt(right);
            if (!Character.isLetterOrDigit(rightChar)) {
                right--;
                continue;
            }
            if (Character.toLowerCase(leftChar) != Character.toLowerCase(rightChar)) {
                return false;
            }
            left++;
            right--;
        }
        return true;
    }
}
