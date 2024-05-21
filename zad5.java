public class zad5{
    // Метод Гаусса для нахождения обратной матрицы
    public static double[][] inverse(double[][] A) {
        int n = A.length;
        double[][] augmentedMatrix = new double[n][2 * n];

        // Создание расширенной матрицы [A|I]
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                augmentedMatrix[i][j] = A[i][j];
                augmentedMatrix[i][j + n] = (i == j) ? 1 : 0;
            }
        }

        // Приведение к диагональному виду
        for (int k = 0; k < n; k++) {
            double pivot = augmentedMatrix[k][k];
            for (int j = 0; j < 2 * n; j++) {
                augmentedMatrix[k][j] /= pivot;
            }
            for (int i = 0; i < n; i++) {
                if (i != k) {
                    double factor = augmentedMatrix[i][k];
                    for (int j = 0; j < 2 * n; j++) {
                        augmentedMatrix[i][j] -= factor * augmentedMatrix[k][j];
                    }
                }
            }
        }

        // Извлечение обратной матрицы из расширенной
        double[][] inverseMatrix = new double[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                inverseMatrix[i][j] = augmentedMatrix[i][j + n];
            }
        }

        return inverseMatrix;
    }

    // Метод для печати матрицы
    public static void printMatrix(double[][] matrix) {
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                System.out.print(matrix[i][j] + "\t");
            }
            System.out.println();
        }
    }

    public static void main(String[] args) {
        // Пример матрицы, для которой мы хотим найти обратную матрицу
        double[][] A = {{2, -1, 0},
                {-1, 2, -1},
                {0, -1, 2}};

        // Нахождение обратной матрицы
        double[][] inverseMatrix = inverse(A);

        // Вывод обратной матрицы
        System.out.println("Исходная матрица:");
        printMatrix(A);
        System.out.println("\nОбратная матрица:");
        printMatrix(inverseMatrix);
    }
}

