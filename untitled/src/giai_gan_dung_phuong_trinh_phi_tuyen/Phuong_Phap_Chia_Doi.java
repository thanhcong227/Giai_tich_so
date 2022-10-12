package giai_gan_dung_phuong_trinh_phi_tuyen;

import java.util.Scanner;

public class Phuong_Phap_Chia_Doi {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("a = ");
        double a = sc.nextDouble();
        System.out.print("b = ");
        double b = sc.nextDouble();
        double x = (a + b) / 2;
        double epsilon = 0.001;
        while (b - a > epsilon) {
            if (f(a) * f(x) < 0) {
                b = x;
            } else {
                a = x;
            }
            x = (b + a) / 2;
        }
        System.out.println(x);
    }

    public static double f(double x) {
        double f_x = Math.pow(x, 4) + 2 * Math.pow(x, 3) - x - 1;
        return f_x;
    }
}
