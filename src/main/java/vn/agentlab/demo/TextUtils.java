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

    /**
     * Kiểm tra đối xứng, chỉ xét chữ cái/chữ số và bỏ qua hoa/thường bằng
     * {@link Character#toLowerCase(int)}. Giữ nguyên dấu, nên {@code "Đi đôi"} trả false.
     *
     * @param s chuỗi cần kiểm tra, có thể null
     * @return false nếu null; true nếu đối xứng hoặc không có chữ cái/chữ số
     */
    public static boolean isPalindrome(String s) {
        if (s == null) {
            return false;
        }
        int[] characters = s.codePoints()
                .filter(Character::isLetterOrDigit)
                .map(Character::toLowerCase)
                .toArray();
        for (int left = 0, right = characters.length - 1; left < right; left++, right--) {
            if (characters[left] != characters[right]) {
                return false;
            }
        }
        return true;
    }

    /** Đếm số từ, phân tách bởi khoảng trắng. */
    public static int wordCount(String s) {
        if (s == null || s.isBlank()) {
            return 0;
        }
        return s.trim().split("\\s+").length;
    }
}
