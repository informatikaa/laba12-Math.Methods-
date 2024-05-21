import Jama.Matrix;

public class zad7 {
    public static void main(String[] args) {
        double[] x = {0, 1, 2, 3, 4, 5};
        double[] y = {1.2, 2.3, 3.4, 4.5, 5.6, 6.7};

        double[][] A = new double[x.length][4];
        for (int i = 0; i < x.length; i++) {
            A[i][0] = 1;
            A[i][1] = Math.cos(0.1 * Math.PI + x[i]);
            A[i][2] = Math.cos(0.2 * Math.PI + x[i]);
            A[i][3] = Math.cos(0.3 * Math.PI + x[i]);
        }

        Matrix X = new Matrix(A);
        Matrix Y = new Matrix(y, y.length);

        Matrix XT = X.transpose();
        Matrix XTX = XT.times(X);
        Matrix XTY = XT.times(Y);

        Matrix XTXInv = XTX.inverse();
        Matrix coefficients = XTXInv.times(XTY);

        double a0 = coefficients.get(0, 0);
        double a1 = coefficients.get(1, 0);
        double a2 = coefficients.get(2, 0);
        double a3 = coefficients.get(3, 0);

        System.out.println("Коэффициенты: a0 = " + a0 + ", a1 = " + a1 + ", a2 = " + a2 + ", a3 = " + a3);


    }
}

