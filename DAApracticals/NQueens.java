//Write a program to find all solutions for 8-queen problem using backtracking

import java.util.*;

public class NQueens {
    private int n;
    private int[] x;
    private int c;

    public NQueens(int n) {
        this.n = n;
        x = new int[n + 1];
        c = 0;
    }

    private boolean place(int k) {
        for (int i = 1; i < k; i++) {
            if (x[i] == x[k] || Math.abs(x[i] - x[k]) == Math.abs(i - k)) {
                return false;
            }
        }
        return true;
    }

    private void nqueen(int n) {
        x[1] = 0;
        int k = 1;

        while (k > 0) {
            x[k] = x[k] + 1;

            while (x[k] <= n && !place(k)) {
                x[k] = x[k] + 1;
            }

            if (x[k] <= n) {
                if (k == n) {
                    c++;
                    System.out.print(c + "->");
                    for (int i = 1; i <= n; i++) {
                        System.out.print(x[i]);
                    }
                    System.out.println();
                } else {
                    k = k + 1;
                    x[k] = 0;
                }
            } else {
                k = k - 1;
            }
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter the number of queens: ");
        int n = sc.nextInt();
        NQueens nQueens = new NQueens(n);
        System.out.println("The solution for " + n + " queen problem is...");
        nQueens.nqueen(n);
        System.out.println("The total solutions are: " + nQueens.c);
        sc.close();
    }
}
