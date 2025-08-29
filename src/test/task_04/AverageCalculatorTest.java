package test.task_04;

import main.task_04.AverageCalculator;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class AverageCalculatorTest {

    private final AverageCalculator calculator = new AverageCalculator();

    @Test
    void throwExceptionForNullArray() {
        assertThrows(IllegalArgumentException.class, () -> {
            calculator.calculateAverage(null);
        });
    }

    @Test
    void throwExceptionForEmptyArray() {
        int[] numbers = {};
        assertThrows(IllegalArgumentException.class, () -> {
            calculator.calculateAverage(numbers);
        });
    }

    @Test
    void positiveNumbers_returnsCorrectAverage() {
        int[] numbers = {1, 2, 3, 4, 5};
        assertEquals(3.0, calculator.calculateAverage(numbers));
    }

    @Test
    void overflowInt() {
        int[] numbers = {Integer.MAX_VALUE, 1};

        double result = calculator.calculateAverage(numbers);
        double expected = 1073741824;

        // переполнение при использовании int для вычисления sum
        System.out.println("Результат: " + result); // получим -1073741824
        System.out.println("Ожидаемый результат: " + expected);

        assertNotEquals(expected, result, 0.001);
    }

    @Test
    void precisionLoss() {
        int[] numbers = {1, 2, 3, 4, 5, 6};

        double result = calculator.calculateAverage(numbers);
        double expected = 3.5;

        // потеря точности из-за целочисленного деления
        System.out.println("Результат: " + result);
        System.out.println("Ожидаемый результат: " + expected);

        assertNotEquals(expected, result, 0.001);
    }

}
