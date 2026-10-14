package vn.agentlab.demo;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

class FibonacciTest {

    @ParameterizedTest
    @CsvSource({
        "0, 0",
        "1, 1",
        "2, 1",
        "3, 2",
        "4, 3",
        "5, 5",
        "10, 55",
        "20, 6765"
    })
    void returnsTermAtIndex(int index, long expected) {
        assertEquals(expected, Fibonacci.term(index));
    }

    @ParameterizedTest
    @CsvSource({
        "0, 0",
        "1, 0",
        "2, 1",
        "3, 2",
        "4, 4",
        "5, 7",
        "6, 12",
        "10, 88"
    })
    void sumsFirstNTerms(int n, long expected) {
        assertEquals(expected, Fibonacci.sumOfFirst(n));
    }

    /** Hằng đẳng thức F(0) + ... + F(n-1) = F(n+1) - 1. */
    @Test
    void sumMatchesClosedFormIdentity() {
        for (int n = 0; n <= 80; n++) {
            assertEquals(Fibonacci.term(n + 1) - 1, Fibonacci.sumOfFirst(n), "n = " + n);
        }
    }

    @Test
    void acceptsLargestValuesFittingInLong() {
        assertEquals(7540113804746346429L, Fibonacci.term(92));
        assertEquals(7540113804746346428L, Fibonacci.sumOfFirst(91));
    }

    @Test
    void overflowThrows() {
        assertThrows(ArithmeticException.class, () -> Fibonacci.term(93));
        assertThrows(ArithmeticException.class, () -> Fibonacci.sumOfFirst(92));
    }

    @Test
    void negativeInputThrows() {
        assertThrows(IllegalArgumentException.class, () -> Fibonacci.term(-1));
        assertThrows(IllegalArgumentException.class, () -> Fibonacci.sumOfFirst(-1));
    }
}
