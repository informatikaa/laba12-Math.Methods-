public class zad4 {

    // Метод Гаусса для решения СЛАУ
    public static double[] gaussElimination(double[][] A, double[] b) {
        int n = b.length;
        // Прямой ход
        for (int k = 0; k < n - 1; k++) {
            for (int i = k + 1; i < n; i++) {
                double factor = A[i][k] / A[k][k];
                for (int j = k; j < n; j++) {
                    A[i][j] -= factor * A[k][j];
                }
                b[i] -= factor * b[k];
            }
        }
        // Обратный ход
        double[] x = new double[n];
        for (int i = n - 1; i >= 0; i--) {
            double sum = 0.0;
            for (int j = i + 1; j < n; j++) {
                sum += A[i][j] * x[j];
            }
            x[i] = (b[i] - sum) / A[i][i];
        }
        return x;
    }
    public static void main(String[] args) {
        // Пример СЛАУ: 3x + 2y - z = 1, 2x - 2y + 4z = -2, -x + 0.5y - z = 0
        double[][] A = {{3, 2, -1},
                {2, -2, 4},
                {-1, 0.5, -1}};
        double[] b = {1, -2, 0};
        // Решение СЛАУ
        double[] solution = gaussElimination(A, b);
        // Вывод результатов
        System.out.println("Решение СЛАУ:");
        for (int i = 0; i < solution.length; i++) {
            System.out.println("x" + (i+1) + " = " + solution[i]);
        }
    }
}