package main.task_05;

import java.util.Arrays;
import java.util.List;

public class GradeCalculator {

    static final List<Integer> allowedGrades = Arrays.asList(2, 3, 4, 5);

    public double calculateAverage(List<Integer> grades) {
        if (grades == null || grades.size() == 0) {
            throw new IllegalArgumentException("List must not be null or empty");
        }
        double sum = 0;

        for (int grade : grades) {
            if (!allowedGrades.contains(grade)) {
                throw new IllegalArgumentException("Unsupportable grade " + grade);
            }
            sum += grade;
        }

        return sum / grades.size();
    }

}




