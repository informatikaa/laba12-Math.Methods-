public class NewtonMethod {
    // Метод Ньютона для решения уравнения f(x) = 0
    public static double newtonMethod(double x0, double eps) {
        double x = x0;
        double fx = f(x);
        int iter = 0;

        while (Math.abs(fx) > eps) {
            double dfx = df(x);
            x = x - fx / dfx;
            fx = f(x);
            iter++;
        }

        System.out.println("Метод Ньютона: Решение найдено за " + iter + " итераций");
        return x;
    }

    // Функция f(x)
    public static double f(double x) {
        return x*x - 4;
    }

    // Производная функции f(x)
    public static double df(double x) {
        return 2*x;
    }

    // Метод численного интегрирования для оценки влияния на решение задачи
    public static double numericalIntegration(double a, double b, int n) {
        double h = (b - a) / n;
        double sum = 0.0;

        for (int i = 0; i < n; i++) {
            double x1 = a + i*h;
            double x2 = a + (i+1)*h;
            sum += (f(x1) + f(x2)) / 2.0 * h;
        }

        return sum;
    }

    public static void main(String[] args) {
        double x0 = 0.0; // Начальное приближение
        double eps = 1e-9; // Точность
        double analyticalSolution = Math.sqrt(4); // Решение аналитическим методом

        double newtonSolution = newtonMethod(x0, eps);
        double numericalIntegrationResult = numericalIntegration(0, 2, 10000);

        System.out.println("Аналитическое решение: " + analyticalSolution);
        System.out.println("Метод Ньютона: " + newtonSolution);
        System.out.println("Численное интегрирование: " + numericalIntegrationResult);
    }
}

