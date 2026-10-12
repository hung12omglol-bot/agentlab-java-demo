package vn.agentlab.demo;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.Test;

class CalculatorTest {

    private final Calculator calc = new Calculator();

    @Test
    void addsNumbers() {
        assertEquals(5, calc.add(2, 3));
    }

    @Test
    void subtractsNumbers() {
        assertEquals(-1, calc.subtract(2, 3));
    }

    @Test
    void multipliesNumbers() {
        assertEquals(6, calc.multiply(2, 3));
    }

    @Test
    void dividesNumbers() {
        assertEquals(2, calc.divide(7, 3));
    }

    @Test
    void divideByZeroThrows() {
        assertThrows(ArithmeticException.class, () -> calc.divide(1, 0));
    }

    @Test
    void addOverflowThrows() {
        assertThrows(ArithmeticException.class, () -> calc.add(Integer.MAX_VALUE, 1));
    }
}
