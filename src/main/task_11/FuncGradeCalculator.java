package main.task_11;

import java.util.Arrays;
import java.util.List;
import java.util.Objects;

public class FuncGradeCalculator {

    static final List<Integer> allowedGrades = Arrays.asList(2, 3, 4, 5);

    public double calculateAverage(List<Integer> grades) {
        Objects.requireNonNull(grades, "List must not be null");
        if (grades.isEmpty()) {
            throw new IllegalArgumentException("List must not be empty");
        }

        boolean allAllowed = grades.stream()
                .allMatch(grade -> allowedGrades.contains(grade));
        if (!allAllowed) {
            throw new IllegalArgumentException("List contains unsupported grade");
        }

        double sum = grades.stream()
                .mapToInt(Integer::intValue)
                .sum();

        return sum / grades.size();
    }

}
