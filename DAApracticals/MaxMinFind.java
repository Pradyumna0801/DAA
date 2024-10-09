//Write a program to find minimum and maximum form a given array
import java.util.*;

public class MaxMinFind {

    public static class MaxMinPair {
        int max;
        int min;

        public MaxMinPair(int max, int min) {
            this.max = max;
            this.min = min;
        }
    }

    public static MaxMinPair findMaxMin(int[] arr, int start, int end) {
        if (start == end) {
            return new MaxMinPair(arr[start], arr[start]);
        }
        if (start + 1 == end) {
            return arr[start] < arr[end] 
                ? new MaxMinPair(arr[end], arr[start]) 
                : new MaxMinPair(arr[start], arr[end]);
        }
        int mid = (start + end) / 2;
        MaxMinPair leftPair = findMaxMin(arr, start, mid);
        MaxMinPair rightPair = findMaxMin(arr, mid + 1, end);
        int globalMax = Math.max(leftPair.max, rightPair.max);
        int globalMin = Math.min(leftPair.min, rightPair.min);
        return new MaxMinPair(globalMax, globalMin);
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Random r = new Random();
        System.out.println("How many elements do you want to insert:\n");
        int n = sc.nextInt();
        int[] a = new int[n];
        System.out.println("System Generated Elements are:\n");

        for (int i = 0; i < n; i++) {
            a[i] = r.nextInt(1000);
        }

        for (int i = 0; i < n; i++) {
            System.out.print("\t" + a[i]);
        }

        MaxMinPair result = findMaxMin(a, 0, n - 1);
        System.out.println("\nMax value: " + result.max);
        System.out.println("Min value: " + result.min);
    }
}
