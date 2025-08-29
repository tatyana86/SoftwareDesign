package main.task_04;

public class AverageCalculator {

    public double calculateAverage(int[] numbers) {
        if (numbers == null) {
            throw new IllegalArgumentException("Недопустимое значение для массива: null");
        }

        if (numbers.length == 0) {
            throw new IllegalArgumentException("Массив не может быть пустой");
        }

        int sum = 0; // возможно переполнение при использовании int
        for (int number : numbers) {
            sum += number;
        }

        return sum / numbers.length; // возможна потеря точности из-за неявного приведения типа
    }

}
