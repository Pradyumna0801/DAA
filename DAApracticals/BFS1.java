//Write a program to implement breadth first search

import java.util.Scanner;

public class BFS1 {
    private int[][] a;
    private int[] v;
    private int n;
    private int[] q;
    private int f, b, r;

    public BFS1() {
        f = b = r = 0;
    }

    public void getdata() {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter the number of vertices: ");
        n = sc.nextInt();
        a = new int[n + 1][n + 1];
        v = new int[n + 1];
        q = new int[15];
        System.out.println("Enter the matrix:");
        
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= n; j++) {
                a[i][j] = sc.nextInt();
            }
        }
        sc.close();
    }

    public void bfs(int v1) {
        int w;
        v[v1] = 1;
        System.out.print(v1 + " ");
        
        while (true) {
            for (w = 1; w <= n; w++) {
                if (a[v1][w] == 1) {
                    if (v[w] == 0) {
                        if (f == 0 && r == 0) {
                            f = r = 1;
                        } else {
                            r++;
                        }
                        q[r] = w;
                        v[w] = 1;
                        System.out.print(w + " ");
                    }
                }
            }
            if (f == 0 && r == 0) {
                break;
            }
            v1 = q[f];
            if (f == r) {
                f = r = 0;
            } else {
                f++;
            }
        }
    }

    public void display() {
        System.out.print("Sequence of nodes in BFS is: ");
        bfs(1);
        System.out.println();
        
        for (int i = 1; i <= n; i++) {
            v[i] = 0;
        }
    }

    public static void main(String[] args) {
        BFS1 b = new BFS1();
        b.getdata();
        b.display();
    }
}
