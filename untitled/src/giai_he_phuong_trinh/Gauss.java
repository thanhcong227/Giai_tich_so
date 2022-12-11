package giai_he_phuong_trinh;

public class Gauss {

    //Khai báo ma trận đã cho
    private static double[][] problem1 = {
            // x = 1, y = 2, z = 3
            { 1,  2, 3, 14 },  // 1x + 2y + 3z = 14
            { 1, -1, 1,  2 },  // 1x - 1y + 1z = 2
            { 4, -2, 1,  3 }   // 4x - 2y + 1z = 3
    };



    public static void solve(double[][] c, int row) {
        int rows = c.length;
        int cols = rows + 1;
        // 1. set c[row][row] equal to 1
        double factor = c[row][row];
        for (int col=0; col<cols; col++)
            c[row][col] /= factor;

        // 2. set c[row][row2] equal to 0
        for (int row2=0; row2<rows; row2++)
            if (row2 != row) {
                factor = -c[row2][row];
                for (int col=0; col<cols; col++)
                    c[row2][col] += factor * c[row][col];
            }
    }

    public static void solve(double[][] c) {
        int rows = c.length;
        for (int row=0; row<rows; row++)
            solve(c,row);
    }

    public static void print(double[][] c) {
        int rows = c.length;
        int cols = rows + 1;
        for (int row=0; row<rows; row++) {
            for (int col=0; col<cols; col++)
                System.out.printf("%5.1f ",c[row][col]);
            System.out.println();
        }
        System.out.println();
    }

    public static void printSolution(double[][] c) {
        int rows = c.length, cols = rows + 1;
        char variable = (char)((rows > 3) ? ('z' - (rows-1)) : 'x');
        System.out.println("Solution:\n");
        for (int row=0; row<rows; row++)
            System.out.printf("  %c = %1.1f\n",(char)variable++,c[row][cols-1]);
        System.out.println();
    }

    public static void doProblem(double[][] problem, String description) {
        System.out.printf("******* %s ********\n",description);
        System.out.println("Original Equations:");
        print(problem);
        solve(problem);
        System.out.println("Solved (reduced row echelon form):");
        print(problem);
        printSolution(problem);
    }

    public static void main(String[] args) {
        doProblem(problem1,"Problem 1 (from class)");

    }
}
