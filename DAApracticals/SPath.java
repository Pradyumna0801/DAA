//Write a program to find shortest path using single source shortest path
import java.util.Scanner;

public class SPath {
    
    private int[][] cost;
    private int[] dist, s;
    private int n, v;
    private final int infinity = 10000;

    public void input() {
        Scanner sc = new Scanner(System.in);
        System.out.print("\nEnter the number of vertices of the graph: ");
        n = sc.nextInt();
        cost = new int[n + 1][n + 1];
        dist = new int[n + 1];
        s = new int[n + 1];
        
        System.out.println("\nEnter the cost matrix:");
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= n; j++) {
                cost[i][j] = sc.nextInt();
            }
        }
        
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= n; j++) {
                if (cost[i][j] == 0) {
                    if (i == j) {
                        cost[i][j] = 0;
                    } else {
                        cost[i][j] = infinity;
                    }
                }
            }
        }
        
        System.out.print("\nEnter the starting vertex: ");
        v = sc.nextInt();
        shortestPath(v);
        sc.close();
    }

    public void output() {
        System.out.println("\nDistances are:");
        for (int i = 1; i <= n; i++) {
            System.out.print(dist[i] + "\t");
        }
    }

    public void shortestPath(int v) {
        for (int i = 1; i <= n; i++) {
            s[i] = 0;
            dist[i] = cost[v][i];
        }
        
        s[v] = 1;
        dist[v] = 0;
        
        for (int num = 2; num <= n - 1; num++) {
            int temp = dist[1];
            int u = 1;
            for (int i = 1; i <= n; i++) {
                if ((temp > dist[i]) && (s[i] == 0)) {
                    temp = dist[i];
                    u = i;
                }
            }
            s[u] = 1;
            for (int j = 1; j <= n; j++) {
                if (s[j] == 0) {
                    dist[j] = min(dist[j], dist[u] + cost[u][j]);
                }
            }
        }
    }

    public int min(int x, int y) {
        return (x < y) ? x : y;
    }

    public static void main(String[] args) {
        SPath s = new SPath();
        s.input();
        s.output();
    }
}
