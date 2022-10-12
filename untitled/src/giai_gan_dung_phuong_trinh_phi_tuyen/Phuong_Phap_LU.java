package giai_gan_dung_phuong_trinh_phi_tuyen;

public class Phuong_Phap_LU {
    public static void main(String[] args) {
        double c;
        int n = 3;
        double[][] A = {
                {8, -3, 2},
                {4, 11, -1},
                {6, 3, 12}
        };
        double[][] L = new double[n][n];
        double[][] U = new double[n][n];
        double[] f = {20, 33, 36};
        double[] x = new double[n];
        double[] y = new double[n];
        double coefficient;

        //gán L cho ma trận tam giác dưới
        //U cho ma tran tam giac tren
        for (int i = 0; i < n-1 ; i++) {
            for (int j = i + 1; j < n; j++) {
                coefficient = A[j][i] / A[i][i];
                L[j][i] = coefficient;
                for (int k = i + 1; k < n; k++) {
                    A[j][k] = A[j][k] - coefficient * A[i][k];
                }
            }
        }

        System.out.println("MA TRAN L");
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                System.out.print(L[i][j]+" ");
            }
            System.out.println();
        }

        System.out.println("MA TRAN A");
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                System.out.print(A[i][j]+" ");
            }
            System.out.println();
        }

        //truyền giá trị đường chéo chính bằng 1 cho L
        for (int i = 0; i < n; i++) {
            L[i][i] = 1.0;
        }

        //ma trận U chính là ma trận A
        for (int i = 0; i < n; i++) {
            for (int j = 0; j <= i; j++) {
                U[j][i] = A[j][i];
            }
        }

        System.out.println("MA TRAN U");
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                System.out.print(U[i][j]+" ");
            }
            System.out.println();
        }

        //Gauss đối với LY = B
        c =0.0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < i+1; j++) {
                c += L[i][j] * y[j];
            }
//            System.out.println("c = "+c);
            y[i] = (f[i]-c)/L[i][i];
            c = 0.0;
        }

//        for (int i = 0; i < n; i++) {
//            System.out.println("y[" + i + "] = " + y[i]);
//        }
        //Gauss đối với UX=Y
        c = 0.0;
        for (int i = n-1; i >=0; i--) {
            for (int j = i; j < n; j++) {
                c += U[i][j] * x[j];
            }
//            System.out.println("c = "+c);
            x[i] = (y[i] - c)/U[i][i];
//            System.out.println("x["+i+"] = "+x[i]);
            c = 0.0;

        }
            System.out.println("Nghiem cua phuong tring LU la: ");
        for (int i = 0; i < n; i++) {
            System.out.println(" [" + x[i] + "] ");
        }
    }
}
