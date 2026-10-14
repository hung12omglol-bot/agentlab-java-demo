package vn.agentlab.demo;

/**
 * Dãy Fibonacci quy ước F(0) = 0, F(1) = 1, F(k) = F(k-1) + F(k-2).
 *
 * <p>Các phép tính dùng {@code long} và {@link Math#addExact(long, long)} nên
 * ném {@link ArithmeticException} khi tràn số thay vì trả kết quả sai.
 */
public final class Fibonacci {

    private Fibonacci() {
    }

    /**
     * Trả về phần tử thứ {@code index} của dãy (0-based): 0, 1, 1, 2, 3, 5, ...
     *
     * @throws IllegalArgumentException nếu {@code index} âm
     * @throws ArithmeticException nếu kết quả vượt quá {@code long} (index &gt; 92)
     */
    public static long term(int index) {
        if (index < 0) {
            throw new IllegalArgumentException("index must be >= 0, got " + index);
        }
        if (index == 0) {
            return 0;
        }
        long prev = 0;
        long curr = 1;
        for (int i = 1; i < index; i++) {
            long next = Math.addExact(prev, curr);
            prev = curr;
            curr = next;
        }
        return curr;
    }

    /**
     * Tính tổng {@code n} phần tử đầu của dãy, tức F(0) + F(1) + ... + F(n-1).
     * Với {@code n = 0} trả về 0.
     *
     * @throws IllegalArgumentException nếu {@code n} âm
     * @throws ArithmeticException nếu tổng vượt quá {@code long} (n &gt; 91)
     */
    public static long sumOfFirst(int n) {
        if (n < 0) {
            throw new IllegalArgumentException("n must be >= 0, got " + n);
        }
        long sum = 0;
        long prev = 0;
        long curr = 1;
        for (int i = 0; i < n; i++) {
            sum = Math.addExact(sum, prev);
            long next = Math.addExact(prev, curr);
            prev = curr;
            curr = next;
        }
        return sum;
    }
}
