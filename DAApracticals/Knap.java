//Write a program to find solution of Knapsack instant.
import java.util.Scanner;

public class Knap {
    private float[] p, x, w;
    private float m;
    private int n;

    public void getData() {
        Scanner sc = new Scanner(System.in);
        System.out.print("\nEnter the number of objects: ");
        n = sc.nextInt();
        System.out.print("\nEnter the capacity of knapsack: ");
        m = sc.nextFloat();
        p = new float[n + 1];
        x = new float[n + 1];
        w = new float[n + 1];

        System.out.println("\nEnter the profits:");
        for (int i = 1; i <= n; i++) {
            System.out.print("p[" + i + "] = ");
            p[i] = sc.nextFloat();
        }

        System.out.println("\nEnter the weights of knapsack:");
        for (int i = 1; i <= n; i++) {
            System.out.print("w[" + i + "] = ");
            w[i] = sc.nextFloat();
        }
    }

    public void knapSol() {
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= n - 1; j++) {
                if ((p[i] / w[j]) < (p[j + 1] / w[j + 1])) {
                    float tp = p[j];
                    float tw = w[j];
                    p[j] = p[j + 1];
                    w[j] = w[j + 1];
                    p[j + 1] = tp;
                    w[j + 1] = tw;
                }
            }
        }

        int i;
        float cu = m;
        for (i = 1; i <= n; i++) {
            x[i] = 0;
        }

        for (i = 1; i <= n; i++) {
            if (w[i] > cu) {
                break;
            }
            x[i] = 1;
            cu = cu - w[i];
        }

        if (i <= n) {
            x[i] = cu / w[i];
        }
    }

    public void show() {
        float s = 0;
        System.out.println("\n\nThe optimal solution is ==> x = {");
        for (int i = 1; i <= n; i++) {
            System.out.print(x[i] + ",");
            s = s + p[i] * x[i];
        }
        System.out.print("\t}\n\nOptimal value: " + s);
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Knap k = new Knap();
        k.getData();
        k.knapSol();
        k.show();
        sc.close();
    }
}
