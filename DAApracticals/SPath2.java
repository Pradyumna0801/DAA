//Write a program to find shortest path using all pair path. 

import java.util.Scanner;

public class SPath2 {
    private int[][] a;
    private int[][] s;
    private int n;

    public void read() {
        Scanner sc = new Scanner(System.in);
        System.out.print("\nHow many vertices in the graph: ");
        n = sc.nextInt();
        a = new int[n + 1][n + 1];
        s = new int[n + 1][n + 1];

        System.out.println("\nEnter the adjacency matrix:");
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= n; j++) {
                System.out.print("(" + i + "," + j + ") ");
                a[i][j] = sc.nextInt();
                if (a[i][j] == 0) {
                    s[i][j] = 9999;
                } else {
                    s[i][j] = a[i][j];
                }
            }
        }
        sc.close();
    }

    public int min(int m, int n) {
        return (m < n) ? m : n;
    }

    public void allPath() {
        for (int k = 1; k <= n; k++) {
            for (int i = 1; i <= n; i++) {
                for (int j = 1; j <= n; j++) {
                    if (i == j) {
                        s[i][j] = 0;
                    }
                    s[i][j] = min(s[i][j], s[i][k] + s[k][j]);
                }
            }
        }
        
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= n; j++) {
                if (s[i][j] >= 9999) {
                    s[i][j] = 0;
                }
            }
        }
    }

    public void display() {
        System.out.println("\nThe shortest path matrix is:");
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= n; j++) {
                System.out.print("\t" + s[i][j]);
            }
            System.out.println();
        }
    }

    public static void main(String[] args) {
        SPath2 s = new SPath2();
        s.read();
        s.allPath();
        s.display();
    }
}
