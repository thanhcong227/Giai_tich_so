package noi_suy;

import java.util.Scanner;

public class Lagrange {
    // To represent a data point
    // corresponding to x and y = f(x)
    static class Data {
        int x, y;

        public Data(int x, int y) {
            super();
            this.x = x;
            this.y = y;
        }

    }

    static double interpolate(Data f[], int xi, int n) {
        double result = 0; // Initialize result

        for (int i = 0; i < n; i++) {
            double term = f[i].y;
            for (int j = 0; j < n; j++) {
                if (j != i)
                    term = term * (xi - f[j].x) / (f[i].x - f[j].x);
            }

            // Add current term to result
            result += term;
        }

        return result;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        // creating an array of 4 known data points
        Data f[] = {new Data(sc.nextInt(), sc.nextInt()), new Data(sc.nextInt(), sc.nextInt()),
                new Data(sc.nextInt(), sc.nextInt()), new Data(sc.nextInt(), sc.nextInt())};

        // Using the interpolate function to obtain
        // a data point corresponding to x=3
        //System.out.print("Value of f(3) is : " +(int) interpolate(f, 3, f.length));
        System.out.println("x = ");
        int x = sc.nextInt();
        System.out.println("Value of f(" + x + ") is : " + (int) interpolate(f, x, f.length));
    }
}
