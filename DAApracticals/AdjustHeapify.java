//write a program to create MAX heap using ADJUST/HEAPIFY

import java.util.*;

class AdjustHeapify {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int[] a = new int[100];
        int n;

        System.out.print("Enter value of n: ");
        n = sc.nextInt();
        System.out.print("Enter elements: ");
        for (int i = 0; i < n; i++) {
            a[i] = sc.nextInt();
        }

        heapify(a, n);
        System.out.print("Heap using heapify: ");
        for (int i = 0; i < n; i++) {
            System.out.print(a[i] + "\t");
        }
    }

    public static void heapify(int[] a, int n) {
        // Build max heap
        for (int i = n / 2 - 1; i >= 0; i--) {
            adjust(a, i, n);
        }
    }

    public static void adjust(int[] a, int i, int n) {
        int item = a[i];
        int j = 2 * i + 1;

        while (j < n) {
            if (j + 1 < n && a[j] < a[j + 1]) {
                j++;
            }
            if (item >= a[j]) {
                break;
            }
            a[(j - 1) / 2] = a[j];
            j = 2 * j + 1;
        }
        a[(j - 1) / 2] = item;
    }
}
