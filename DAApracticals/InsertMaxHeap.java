//Write a program for creating max. heap using INSERT

import java.util.*;

public class InsertMaxHeap {
    int n;
    int[] a = new int[20];

    public void insert(int[] a, int n) {
        int i, j, item;
        j = n;
        i = n / 2;
        item = a[n];
        
        while (i > 0 && a[i] < item) {
            a[j] = a[i];
            j = i;
            i = i / 2;
        }
        a[j] = item;
    }

    public void get() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter how many elements to insert into the heap: ");
        n = scanner.nextInt();
        System.out.println("Enter heap elements: ");
        
        for (int i = 1; i <= n; i++) {
            a[i] = scanner.nextInt();
            insert(a, i);
        }
        scanner.close();
    }

    public void show() {
        System.out.println("Max heap using insert:");
        for (int i = 1; i <= n; i++) {
            System.out.print(a[i] + "\t");
        }
    }

    public static void main(String[] args) {
        InsertMaxHeap obj = new InsertMaxHeap();
        obj.get();
        obj.show();
    }
}
