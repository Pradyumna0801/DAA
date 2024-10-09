// Write a program for matrix multiplication using Strassen’s matrix multiplication.

import java.util.Scanner;

public class MatrixM {
    public static void main(String[] args) {
        int[][] a = new int[10][10];
        int[][] b = new int[10][10];
        int[][] c = new int[10][10];
        int P, Q, R, S, T, U, V;

        Scanner sc = new Scanner(System.in);
        System.out.println("\nEnter the First 2x2 Matrix:\n");
        for (int i = 1; i <= 2; i++) {
            for (int j = 1; j <= 2; j++) {
                a[i][j] = sc.nextInt();
            }
        }

        System.out.println("\nMatrix is \n");
        for (int i = 1; i <= 2; i++) {
            for (int j = 1; j <= 2; j++) {
                System.out.print("\t" + a[i][j]);
            }
            System.out.println("");
        }

        System.out.println("\nEnter the Second 2x2 Matrix:\n");
        for (int i = 1; i <= 2; i++) {
            for (int j = 1; j <= 2; j++) {
                b[i][j] = sc.nextInt();
            }
        }

        System.out.println("\nMatrix is \n");
        for (int i = 1; i <= 2; i++) {
            for (int j = 1; j <= 2; j++) {
                System.out.print("\t" + b[i][j]);
            }
            System.out.println("");
        }

        P = (a[1][1] + a[2][2]) * (b[1][1] + b[2][2]);
        Q = (a[2][1] + a[2][2]) * b[1][1];
        R = (a[1][1]) * (b[1][2] - b[2][2]);
        S = a[2][2] * (b[2][1] - b[1][1]);
        T = (a[1][1] + a[1][2]) * b[2][2];
        U = (a[2][1] - a[1][1]) * (b[1][1] + b[1][2]);
        V = (a[1][2] - a[2][2]) * (b[2][1] + b[2][2]);

        c[1][1] = P + S - T + V;
        c[1][2] = R + T;
        c[2][1] = Q + S;
        c[2][2] = P + R - Q + U;

        System.out.println("\nMatrix Multiplication is:\n");
        for (int i = 1; i <= 2; i++) {
            for (int j = 1; j <= 2; j++) {
                System.out.print("\t" + c[i][j]);
            }
            System.out.println("");
        }
        System.out.println("\nThank You!");
    }
}
