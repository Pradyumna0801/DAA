// Write a program to implement breadth first and depth first search

import java.util.Scanner;

public class DFS1 {
    private int[][] a;
    private int[] v;
    private int n;

    public void getdata() {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter the number of vertices: ");
        n = sc.nextInt();
        a = new int[n + 1][n + 1];
        v = new int[n + 1];
        System.out.println("Enter the matrix:");
        
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= n; j++) {
                a[i][j] = sc.nextInt();
            }
        }
        sc.close();
    }

    public int dfs(int i) {
        int w;
        v[i] = 1;
        System.out.print(i + " ");
        
        for (w = 1; w <= n; w++) {
            if (a[i][w] == 1) {
                if (v[w] == 0) {
                    dfs(w);
                }
            }
        }
        return 0;
    }

    public void display() {
        System.out.print("Sequence of nodes in DFS is: ");
        dfs(1);
        System.out.println();
        
        for (int i = 1; i <= n; i++) {
            v[i] = 0;
        }
    }

    public static void main(String[] args) {
        DFS1 b = new DFS1();
        b.getdata();
        b.display();
    }
}
