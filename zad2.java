public class zad2 {

    public static double function(double x) {
        // Пример функции, для которой нужно найти производную
        return Math.sin(x);
    }

    public static double forwardDifference(double x, double h) {
        return (function(x + h) - function(x)) / h;
    }

    public static double backwardDifference(double x, double h) {
        return (function(x) - function(x - h)) / h;
    }

    public static double centralDifference(double x, double h) {
        return (function(x + h) - function(x - h)) / (2 * h);
    }

    public static void main(String[] args) {
        double x = 0.5; // Точка, в которой вычисляем производную
        double[] hs = {1, 0.1, 0.01, 0.001, 0.0001, 0.00001, 0.000001, 0.0000001};

        for (double h : hs) {
            System.out.println("h = " + h); // Шаг
            System.out.println("Правая разность: " + forwardDifference(x, h));
            // Метод нахождения производной в точке, беря градиент между точкой и точкой, расположенной впереди неё
            System.out.println("Левая разность: " + backwardDifference(x, h));
            // Метод нахождения производной в точке, который берет градиент между точкой и точкой, расположенной позади неё
            System.out.println("Центральная разность: " + centralDifference(x, h));
            // Численный метод, который используется для приближения производной функйии в заданной точке
            System.out.println();
        }
    }
}
