//Write a program for searching element form given array using binary search for n=1000,2000,3000 find exact time of execution


import java.util.Random;
import java.util.Scanner;

public class BinaryS {

    public static void main(String[] args) {

        Random r = new Random();
        Scanner sc = new Scanner(System.in);
        int[] a = new int[6000];
        System.out.println("How many elements do you want to insert:");
        int n = sc.nextInt();

        System.out.println("\nGenerated Elements:");
        for (int i = 1; i <= n; i++) {
            a[i] = r.nextInt(2000);
        }

        for (int i = 1; i <= n; i++) {
            System.out.print("\t" + a[i]);
        }

        // Sorting the generated elements
        for (int i = 1; i <= n; i++) {
            for (int j = i + 1; j <= n; j++) {
                if (a[i] > a[j]) {
                    int t = a[i];
                    a[i] = a[j];
                    a[j] = t;
                }
            }
        }

        System.out.println("\nAfter Sorting Generated Elements:");
        for (int i = 1; i <= n; i++) {
            System.out.print("\t" + a[i]);
        }

        System.out.println("\nEnter the element you want to search:");
        int x = sc.nextInt();

        // Start measuring time
        long st = System.nanoTime();
        int g = binary(a, 0, n, x);
        long en = System.nanoTime();
        double sts = (en - st) / 1000000.0;

        if (g != -1) {
            System.out.println("Total Execution Time: " + sts + " ms");
            System.out.println("\nElement found at index " + g + ", Element is " + a[g]);
        } else {
            System.out.println("Total Execution Time: " + sts + " ms");
            System.out.println("\nElement not found.");
        }
        sc.close();
    }

    public static int binary(int a[], int beg, int end, int x) {
        int mid;
        if (end >= beg) {
            mid = (end + beg) / 2;
            if (a[mid] == x) {
                return mid;
            } else if (a[mid] < x) {
                return binary(a, mid + 1, end, x);
            } else {
                return binary(a, beg, mid - 1, x);
            }
        }
        return -1;
    }
}
