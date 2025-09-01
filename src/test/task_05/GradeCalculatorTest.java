package test.task_05;

import main.task_05.GradeCalculator;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class GradeCalculatorTest {

    private final GradeCalculator calculator = new GradeCalculator();

    @Test
    void throwExceptionForNullArray() {
        assertThrows(IllegalArgumentException.class, () -> {
            calculator.calculateAverage(null);
        });
    }

    @Test
    void throwExceptionForEmptyArray() {
        assertThrows(IllegalArgumentException.class, () -> {
            calculator.calculateAverage(Collections.emptyList());
        });
    }

    @Test
    void allowedPositiveGrades_returnsCorrectAverage() {
        List<Integer> grades = Arrays.asList(2, 3, 4, 5);
        assertEquals(3.5, calculator.calculateAverage(grades));
    }

    @Test
    void throwExceptionForNegativeGrades() {
        List<Integer> grades = Arrays.asList(-5, -4, -3, -4, -5);
        assertThrows(IllegalArgumentException.class, () -> {
            calculator.calculateAverage(grades);
        });
    }

    @Test
    void throwExceptionForNotAllowedPositiveGrades() {
        List<Integer> grades = Arrays.asList(6, 7);
        assertThrows(IllegalArgumentException.class, () -> {
            calculator.calculateAverage(grades);
        });
    }



}
