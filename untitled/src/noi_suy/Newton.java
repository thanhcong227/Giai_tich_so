package noi_suy;

import java.util.Scanner;

public class Newton {
    static double u_cal(double u, int n)
    {
        // u = 1 + x/1! + x^2/2! + x^3/3! + ... + x^n/n!
        double temp = u;
        for (int i = 1; i < n; i++)
            temp = temp * (u - i);
        return temp;
    }

    // calculating factorial of given number n
    static int fact(int n)
    {
        int f = 1;
        for (int i = 2; i <= n; i++)
            f *= i;
        return f;
    }

    public static void main(String[] args)
    {
        Scanner sc = new Scanner(System.in);
        // Number of values given
        System.out.print("Nhap so luong diem: ");
        int n = sc.nextInt();
        double x[] = new double[n];
//        double x[] = { 45, 50, 55, 60 };
        for (int i = 0; i < n; i++) {
            System.out.print("x" + (i+1) + " = ");
            x[i] = sc.nextDouble();
        }

        // y[][] is used for difference table
        // with y[][0] used for input
        double y[][]=new double[n][n];
        for (int i = 0; i < n; i++) {
            System.out.print("y" + (i+1) + " = ");
            y[i][0] = sc.nextDouble();
        }
//        y[0][0] = 0.7071;
//        y[1][0] = 0.7660;
//        y[2][0] = 0.8192;
//        y[3][0] = 0.8660;

        // Value to interpolate at
        System.out.print("x = ");
        double value = sc.nextDouble();

        // Calculating the forward difference
        // table
        for (int i = 1; i < n; i++) {
            for (int j = 0; j < n - i; j++)
                y[j][i] = y[j + 1][i - 1] - y[j][i - 1];
        }

        // Displaying the forward difference table
        for (int i = 0; i < n; i++) {
            System.out.print(x[i]+" ");
            for (int j = 0; j < n - i; j++)
                System.out.print(y[i][j]+" ");
            System.out.println();
        }

        // initializing u and sum
        double sum = y[0][0];
        double u = (value - x[0]) / (x[1] - x[0]);
        for (int i = 1; i < n; i++) {
            sum = sum + (u_cal(u, i) * y[0][i]) /
                    fact(i);
        }

        System.out.println("f("+value+") = "+String.format("%.6g%n",sum));
    }
}
