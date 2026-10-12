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
     * Kiểm tra chuỗi có phải là chuỗi đối xứng (palindrome) hay không.
     *
     * <p>Chuỗi được coi là đối xứng nếu đọc xuôi và ngược giống nhau sau khi
     * bỏ qua chữ hoa/thường, khoảng trắng và dấu câu (chỉ xét chữ cái và chữ số
     * theo {@link Character#isLetterOrDigit(int)}).
     *
     * <p>Quy tắc:
     * <ul>
     *   <li>{@code null} trả về {@code false}.</li>
     *   <li>Chuỗi rỗng hoặc chỉ chứa khoảng trắng/dấu câu trả về {@code true}.</li>
     *   <li>Với ký tự Unicode có dấu (ví dụ: tiếng Việt), các dấu thanh/dấu phụ được giữ nguyên
     *       khi so sánh chữ thường. Do đó, chuỗi {@code "Đi đôi"} lọc thành {@code "điđôi"},
     *       đọc ngược là {@code "iôđiđ"}, trả về {@code false}.</li>
     * </ul>
     *
     * @param s chuỗi cần kiểm tra
     * @return {@code true} nếu là palindrome, ngược lại {@code false}
     */
    public static boolean isPalindrome(String s) {
        if (s == null) {
            return false;
        }
        int[] codePoints = s.codePoints()
                .filter(Character::isLetterOrDigit)
                .map(Character::toLowerCase)
                .toArray();
        int left = 0;
        int right = codePoints.length - 1;
        while (left < right) {
            if (codePoints[left] != codePoints[right]) {
                return false;
            }
            left++;
            right--;
        }
        return true;
    }
}
