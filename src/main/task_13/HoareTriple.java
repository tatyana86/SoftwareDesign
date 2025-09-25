package main.task_13;

public class HoareTriple {

    // {true} z = max(a, b) {(z == a && a >= b) || (z == b && b > a)}
    public static double max(double a, double b) {
        if (a > b) {
            return a;
        }
        return b;
    }

    // {true} z = abs(a) {(z == a && a >= 0) || (z == -a && a < 0)}
    public static double abs(double a) {
        if (a >= 0) {
            return a;
        }
        return -a;
    }

    // {true} z = maxAbs(a, b) { (z == abs(a) && abs(a) >= abs(b)) || (z == abs(b) && abs(b) > abs(a)) }
    public static double maxAbs(double a, double b) {
        return max(abs(a), abs(b));
    }
}
