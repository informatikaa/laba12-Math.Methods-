import java.util.Arrays;
public class zad1 {

    public static void main(String[] args) {

        double epsilon[] = {0.01, 0.001, 0.00001, 0.0000001};
        double initialGuess = 1.0; //первоначальное предположение

        for (int i = 0; i < epsilon.length; i++) {
            System.out.println("Нахождение корней с помощью эпсилон, используя приближенные методы " + epsilon[i]);
            double bisectionResult = bisectionMethod(epsilon[i]);
            double simpleIterationResult = simpleIterationMethod(initialGuess, epsilon[i]);
            double newtonResult = newtonMethod(initialGuess, epsilon[i]);

            compareSolutions(bisectionResult, simpleIterationResult, newtonResult);
        }
    }
    public static double function(double x) {
        return Math.sin(x) - x / 2;
    } // Пример уравнения (sin(x)-x)/2 = 0
    public static double derivativeFunction(double x) {
        return Math.cos(x) - 1 / 2;
    }
    public static double bisectionMethod(double epsilon) {
        double a = 0;
        double b = 2;
        double mid = (a + b) / 2;

        while (Math.abs(function(mid)) > epsilon) {
            if (function(a) * function(mid) < 0) {
                b = mid;
            } else {
                a = mid;
            }
            mid = (a + b) / 2;
        }

        return mid;
    }
    public static double simpleIterationMethod(double initialGuess, double epsilon) {
        double x = initialGuess;
        double prevX; //Предыдущий x

        do {
            prevX = x;
            x = x - function(x);
        } while (Math.abs(x - prevX) > epsilon);
        return x;
    }
    public static double newtonMethod(double initialGuess, double epsilon) {
        double x = initialGuess;
        do {
            x = x - function(x) / derivativeFunction(x);
        } while (Math.abs(function(x)) > epsilon);
        return x;
    }
    public static void compareSolutions(double bisectionResult, double simpleIterationResult, double newtonResult) {
        double analyticalSolution = Math.PI;

        double[] results = {bisectionResult, simpleIterationResult, newtonResult, analyticalSolution};
        Arrays.sort(results);

        System.out.println("Результат биссекции: " + bisectionResult);
        System.out.println("Результат простой итерации: " + simpleIterationResult);
        System.out.println("РЕзультат НЬютона: " + newtonResult);
        System.out.println("Аналитические решения: " + analyticalSolution);
        System.out.println("Лучшее решение: " + results[0]);
        System.out.println("--------------------------------------");
    }
}