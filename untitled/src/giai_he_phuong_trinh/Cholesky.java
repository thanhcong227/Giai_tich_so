package giai_he_phuong_trinh;

//Phương pháp Cholessky giải hệ phương trình tuyến tính Ax = b
//với A là ma trận vuông đối xứng dương
//Trong đó A = S^T*S
//S là ma trận tam giác trên
//S^T là ma trận chuyển vị của S
//Giải hệ Ax = b bằng cách giải hệ S^T*y = b
//và S*x = y

import java.io.IOException;
import java.util.Scanner;

public class Cholesky {

    static double[][] lower;
    static double[][] upper;

    static void Cholesky_Decomposition(double[][] matrix,
                                       int n) {

        double[][] lower = new double[n][n];
        double[][] upper = new double[n][n];

        // Phân tách một ma trận
        // vào ma trận tam giác dưới
        for (int i = 0; i < n; i++) {
            for (int j = 0; j <= i; j++) {
                int sum = 0;

                // tính tổng các đường chéo
                if (j == i) {
                    for (int k = 0; k < j; k++)
                        sum += (int) Math.pow(lower[j][k],
                                2);
                    lower[j][j] = (int) Math.sqrt(
                            matrix[j][j] - sum);
                } else {

                    // Evaluating L(i, j)
                    // using L(j, j)
                    for (int k = 0; k < j; k++)
                        sum += (lower[i][k] * lower[j][k]);
                    lower[i][j] = (matrix[i][j] - sum)
                            / lower[j][j];
                }
            }
        }

        //Gán ma trận tam giác trên bằng ma trận chuyển vị của ma trận tam giác dưới
        for (int j = 0; j < n; j++) {
            for (int k = 0; k < n; k++) {
                upper[j][k] = lower[k][j];
            }
        }

        //Hiển thị tam giác dưới và chuyển bị của nó
        System.out.println("Transpose");
        for (int i = 0; i < n; i++) {

            // Lower Triangular
//            for (int j = 0; j < n; j++)
//                System.out.print(lower[i][j] + "\t");
//            System.out.print("");


            //Chuyển vị của ma trận tam giác dưới
            for (int j = 0; j < n; j++)
                System.out.print(lower[j][i] + "\t");
            System.out.println();
        }
    }

    public static void solve(double[][] lower, double[][] upper, double[] y) {
        int n = upper.length;
        double[] x = new double[n];
        double[] b = new double[n];
        for (int i = 0; i < n; i++) {
            b[i] = y[i];
        }
        //Giải hệ S^T*y = b
        for (int i = 0; i < n; i++) {
            int sum = 0;
            for (int j = 0; j < i; j++) {
                sum += lower[j][i] * y[j];
            }
            y[i] = (b[i] - sum) / lower[i][i];
        }

        //Giải hệ S*x = y
        for (int i = n - 1; i >= 0; i--) {
            int sum = 0;
            for (int j = i + 1; j < n; j++) {
                sum += upper[j][i] * x[j];
            }
            x[i] = (y[i] - sum) / upper[i][i];
        }

        //Hiển thị kết quả
        System.out.println("Kết quả: ");
        for (int i = 0; i < n; i++) {
            System.out.println("x" + (i + 1) + " = " + x[i]);
        }
    }

    // Driver Code
    public static void main(String[] args) throws IOException {
//        int n = 3;
//        int[][] matrix = new int[][]{{4, 12, -16},
//                {12, 37, -43},
//                {-16, -43, 98}};

        Scanner reader = new Scanner(System.in);

        //Nhập cỡ ma trận
        int n = reader.nextInt();
        //Nhập ma trận A và y
        double[][] A = new double[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                A[i][j] = reader.nextDouble();
            }
        }

        double[] y = new double[n];
        for (int i = 0; i < n; i++) {
            y[i] = reader.nextDouble();
        }
        Cholesky_Decomposition(A, n);
        solve(lower, upper, y);
    }
}
