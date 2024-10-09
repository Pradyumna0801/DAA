// MergeSort Write a program for sorting given array in ascending/descending order with n=1000,2000,3000 find exact time of execution using

import java.util.*;

public class MergeSort {
    public void mergeSort(int[] array, int left, int right) {
        if (left < right) {
            int mid = left + (right - left) / 2;
            mergeSort(array, left, mid);
            mergeSort(array, mid + 1, right);
            merge(array, left, mid, right);
        }
    }

    public void merge(int[] array, int left, int mid, int right) {
        int leftSize = mid - left + 1;
        int rightSize = right - mid;
        int[] leftArray = new int[leftSize];
        int[] rightArray = new int[rightSize];

        for (int i = 0; i < leftSize; i++) {
            leftArray[i] = array[left + i];
        }

        for (int i = 0; i < rightSize; i++) {
            rightArray[i] = array[mid + 1 + i];
        }

        int i = 0;
        int j = 0;
        int k = left;

        while (i < leftSize && j < rightSize) {
            if (leftArray[i] <= rightArray[j]) {
                array[k] = leftArray[i];
                i++;
            } else {
                array[k] = rightArray[j];
                j++;
            }
            k++;
        }

        while (i < leftSize) {
            array[k] = leftArray[i];
            i++;
            k++;
        }

        while (j < rightSize) {
            array[k] = rightArray[j];
            j++;
            k++;
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("How many elements do you want to insert:\n");
        int n = sc.nextInt();
        int[] a = new int[n];
        System.out.println("Enter the " + n + " elements:\n");

        for (int i = 0; i < n; i++) {
            a[i] = sc.nextInt();
        }

        MergeSort m = new MergeSort();
        System.out.println("Original Array: " + Arrays.toString(a));
        long startTime = System.nanoTime();
        m.mergeSort(a, 0, n - 1);
        long endTime = System.nanoTime();
        double executionTimeMs = (endTime - startTime) / 1000000.0;
        System.out.println("Sorted Array: " + Arrays.toString(a));
        System.out.println("Execution Time: " + executionTimeMs + " ms");
        System.out.println("Thank you:");
        sc.close();
    }
}
