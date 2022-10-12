package giai_gan_dung_phuong_trinh_phi_tuyen;

import java.util.Scanner;

public class Phuong_Phap_Gauss {

    static Scanner sc = new Scanner(System.in);
    static int n;
    static double[][] a;
    double[] x;

    public static void Nhap() {
        System.out.println("So luong phuong trinh cua he: ");
        n = sc.nextInt();
        System.out.println("Nhap cac phan tu theo thu tu dong: ");
        for (int i = 0; i < n; i++) {
            System.out.println("Dong thu "+(i+1)+" : ");
            String[] tmp = sc.nextLine().split("\\s");
            for (int j = 0; j < n; j++) {
                a[i][j] = Double.parseDouble(tmp[j]);
            }
        }
    }

    public static void main(String[] args) {
        System.out.println("Giai he phuong trinh tuyen tinh bang phep khu Gauss ");
        Nhap();
    }

}
