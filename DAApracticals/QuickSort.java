//QuickSort Write a program for sorting given array in ascending/descending order with n=1000,2000,3000 find exact time of execution using


import java.util.*;

public class QuickSort {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("How many elements do you want to insert?");
        int n = sc.nextInt();
        int[] array = new int[n];
        
        System.out.println("Enter the elements:");
        for (int i = 0; i < n; i++) {
            array[i] = sc.nextInt();
        }
        
        System.out.println("Before sorting:");
        printArray(array);
        
        long startTime = System.nanoTime();
        quickSort(array, 0, n - 1);
        long endTime = System.nanoTime();
        
        System.out.println("After sorting:");
        printArray(array);
        
        double executionTime = (endTime - startTime) / 1000000.0;
        System.out.println("Total execution time: " + executionTime + " milliseconds");
    }

    public static void quickSort(int[] array, int low, int high) {
        if (low < high) {
            int pivotIndex = partition(array, low, high);
            quickSort(array, low, pivotIndex - 1);
            quickSort(array, pivotIndex + 1, high);
        }
    }

    public static int partition(int[] array, int low, int high) {
        int pivot = array[high];
        int i = low - 1;

        for (int j = low; j < high; j++) {
            if (array[j] < pivot) {
                i++;
                int temp = array[i];
                array[i] = array[j];
                array[j] = temp;
            }
        }

        int temp = array[i + 1];
        array[i + 1] = array[high];
        array[high] = temp;

        return i + 1;
    }

    public static void printArray(int[] array) {
        for (int num : array) {
            System.out.print(num + " ");
        }
        System.out.println();
    }
}
