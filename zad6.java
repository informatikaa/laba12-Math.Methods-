public class zad6 {
    public static double[] solveUsingCramer(double[][] A, double[] B) {
        int n = A.length;
        double detA = determinant(A);
        if (detA == 0) {
            System.out.println("Определитель матрицы A равен 0. Уникального решения не существует.");
            return null;
        }

        double[] X = new double[n];
        for (int i = 0; i < n; i++) {
            double[][] Ai = replaceColumn(A, B, i);
            double detAi = determinant(Ai);
            X[i] = detAi / detA;
        }

        return X;
    }

    public static double determinant(double[][] A) {
        int n = A.length;
        double det = 1;
        for (int i = 0; i < n; i++) {
            int maxRow = i;
            for (int j = i + 1; j < n; j++) {
                if (Math.abs(A[j][i]) > Math.abs(A[maxRow][i])) {
                    maxRow = j;
                }
            }
            if (maxRow != i) {
                double[] temp = A[i];
                A[i] = A[maxRow];
                A[maxRow] = temp;
                det *= -1;
            }

            det *= A[i][i];

            if (A[i][i] == 0) {
                return 0;
            }

            for (int j = i + 1; j < n; j++) {
                double factor = A[j][i] / A[i][i];
                for (int k = i; k < n; k++) {
                    A[j][k] -= factor * A[i][k];
                }
            }
        }

        return det;
    }

    public static double[][] replaceColumn(double[][] A, double[] B, int col) {
        int n = A.length;
        double[][] Ai = new double[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (j == col) {
                    Ai[i][j] = B[i];
                } else {
                    Ai[i][j] = A[i][j];
                }
            }
        }
        return Ai;
    }

    public static void main(String[] args) {
        double[][] A = {{2, -1, 1}, {1, 1, -1}, {1, 2, 3}};
        double[] B = {2, -2, 7};

        double[] X = solveUsingCramer(A, B);
        if (X != null) {
            for (int i = 0; i < X.length; i++) {
                System.out.println("x" + i + " = " + X[i]);
            }
        }
    }
}
