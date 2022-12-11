package tinh_gan_dung_tich_phan;

import java.util.ArrayList;
import java.util.LinkedList;

public class Simpson {

    // Function to calculate f(x)
    static float func(float x)
    {
        return (float)Math.log(x);
    }

    // Function for approximate integral
    static float simpsons_(float ll, float ul,
                           int n)
    {
        // Calculating the value of h
        float h = (ul - ll) / n;

        // Array for storing value of x
        // and f(x)
        float[] x = new float[10];
        float[] fx= new float[10];

        // Calculating values of x and f(x)
        for (int i = 0; i <= n; i++) {
            x[i] = ll + i * h;
            fx[i] = func(x[i]);
        }

        // Calculating result
        float res = 0;
        for (int i = 0; i <= n; i++) {
            if (i == 0 || i == n)
                res += fx[i];
            else if (i % 2 != 0)
                res += 4 * fx[i];
            else
                res += 2 * fx[i];
        }

        res = res * (h / 3);
        return res;
    }

    // Driver Code
    public static void main(String s[])
    {
        // Lower limit
        float lower_limit = 4;

        // Upper limit
        float upper_limit = (float)5.2;

        // Number of interval
        int n = 6;

        System.out.println(simpsons_(lower_limit,
                upper_limit, n));
    }
}

/* Đánh giá logx dx trong giới hạn 4 đến 5.2.
   Đầu tiên, chúng ta sẽ chia khoảng thời gian thành sáu phần bằng nhau
   vì số khoảng thời gian phải là số chẵn.

   x    : 4.0   4.2  4.4  4.6  4.8  5.0  5.2
   logx : 1.38 1.43 1.48 1.52 1.56 1.60 1.64

Bây giờ chúng ta có thể tính giá trị gần đúng của tích phân
bằng công thức trên:
     = h/3[( 1.38 + 1.64) + 4 * (1.43 + 1.52 +
                      1.60 ) +2 *(1,48 + 1,56)]
     = 1,84
Do đó giá trị gần đúng của tích phân trên là
1,827 khi sử dụng quy tắc 1/3 của Simpson.  */