//Write a program to find Minimum-Cost Spanning Trees (Prim’s & Kruskal’s Algorithm)

import java.util.Scanner;

public class SPrim {
    int n;
    int v;
    int cost[][];
    int i, j, s[];
    int e[];
    int near1[];
    int t[][];
    int m, minedge, k, l, mincost;
    int jindex;
    float dist[];

    public void get() {
        m = 1;
        minedge = 9999;
        Scanner sc = new Scanner(System.in);
        System.out.println("\nEnter the number of adjacency vertices: ");
        n = sc.nextInt();
        cost = new int[n + 1][n + 1];
        s = new int[n + 1];
        e = new int[n + 1];
        t = new int[n + 1][3];
        dist = new float[n + 1];
        near1 = new int[n + 1];

        System.out.println("\nEnter the adjacency matrix:");
        for (i = 1; i <= n; i++) {
            for (j = 1; j <= 1; j++) {
                cost[i][j] = sc.nextInt();
                if (cost[i][j] == -1) {
                    cost[i][j] = 9999;
                } else {
                    e[m] = cost[i][j];
                    if (e[m] < minedge) {
                        minedge = e[i];
                        k = i;
                        l = j;
                    }
                }
            }
        }
        sc.close();
    }

    public void prime() {
        t[1][1] = k;
        t[1][2] = l;
        mincost = cost[k][l];
        
        for (i = 1; i <= n; i++) {
            if (cost[i][1] < cost[i][k]) {
                near1[i] = l;
            } else {
                near1[i] = k;
            }
        }
        
        near1[k] = near1[l] = 0;
        int minj = 9999;

        for (i = 2; i <= n; i++) {
            minj = 9999;

            for (j = 1; j <= 1; j++) {
                if (near1[j] != 0) {
                    if (cost[j][near1[j]] < minj) {
                        minj = cost[j][near1[j]];
                        jindex = j;
                    }
                }
            }

            t[i][1] = jindex;
            t[i][2] = near1[jindex];
            mincost = mincost + cost[jindex][near1[jindex]];
            near1[jindex] = 0;

            for (int k1 = 1; k1 <= n; k1++) {
                if (near1[k1] != 0 && cost[k1][near1[k1]] > cost[k1][jindex]) {
                    near1[k1] = jindex;
                }
            }
        }
        
        System.out.println("Min cost: " + mincost);
    }

    public void display() {
        System.out.println("\nMinimum spanning tree path is as follows: ");
        System.out.print(t[1][1] + " -> " + t[1][2]);
        
        for (i = 2; i <= n; i++) {
            System.out.print(" -> " + t[i][j]);
        }
    }

    public static void main(String[] args) {
        SPrim d = new SPrim();
        d.get();
        d.prime();
        d.display();
    }
}
