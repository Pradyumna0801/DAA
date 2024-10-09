// HeapSort Write a program for sorting given array in ascending/descending order with n=1000,2000,3000 find exact time of execution using


import java.util.*;

public class Heap {

    public void heapSort(int[] arr) {
        int n = arr.length;

        for (int i = n / 2 - 1; i >= 0; i--) {
            heapify(arr, n, i);
        }

        for (int i = n - 1; i >= 0; i--) {
            int temp = arr[0];
            arr[0] = arr[i];
            arr[i] = temp;
            heapify(arr, i, 0);
        }
    }

    public void heapify(int[] arr, int n, int rootIndex) {
        int largest = rootIndex;
        int leftChild = 2 * rootIndex + 1;
        int rightChild = 2 * rootIndex + 2;

        if (leftChild < n && arr[leftChild] > arr[largest]) {
            largest = leftChild;
        }
        if (rightChild < n && arr[rightChild] > arr[largest]) {
            largest = rightChild;
        }
        if (largest != rootIndex) {
            int temp = arr[rootIndex];
            arr[rootIndex] = arr[largest];
            arr[largest] = temp;
            heapify(arr, n, largest);
        }
    }
}

class MyHeap {
    public static void main(String[] args) {
        Heap h = new Heap();
        Scanner sc = new Scanner(System.in);
        
        System.out.println("How many elements do you want to insert:");
        int n = sc.nextInt();
        int[] a = new int[n];
        
        System.out.println("Enter the " + n + " elements:");
        for (int i = 0; i < n; i++) {
            a[i] = sc.nextInt();
        }
        
        System.out.println("Original array: " + Arrays.toString(a));
        long st = System.nanoTime();
        h.heapSort(a);
        long en = System.nanoTime();
        double s = (en - st) / 1000000.0;
        
        System.out.println("Sorted array: " + Arrays.toString(a));
        System.out.println("Exact Time Execution: " + s + " ms");
        System.out.println("Thank you:");
        
        sc.close();
    }
}
