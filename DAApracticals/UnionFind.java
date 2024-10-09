//Write a program to implement union and find operation

import java.util.*;

public class UnionFind {
    private int n;
    private Node[] obj;

    private class Node {
        int info;
        int parent;

        Node(int info) {
            this.info = info;
            this.parent = 0;
        }
    }

    public void input() {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter no of nodes:=");
        n = sc.nextInt();
        obj = new Node[n + 1];
        System.out.println("Enter the nodes:=");
        for (int i = 1; i <= n; i++) {
            int info = sc.nextInt();
            obj[i] = new Node(info);
        }
    }

    public void union(int a, int b) {
        int x;
        x = obj[a].parent + obj[b].parent;
        if (obj[a].parent > obj[b].parent) {
            obj[a].parent = b;
            obj[b].parent = x;
        } else {
            obj[b].parent = a;
            obj[a].parent = x;
        }
        System.out.println("\nParent of " + a + " is: " + obj[a].parent);
        System.out.println("Parent of " + b + " is: " + obj[b].parent);
    }

    public int find(int a) {
        int temp, back, store;
        store = back = a;
        while (obj[back].parent > 0) {
            back = obj[back].parent;
        }
        while (back != a) {
            temp = obj[a].parent;
            obj[a].parent = back;
            a = temp;
        }
        System.out.println("\nParent of " + store + " is: " + obj[store].parent);
        return obj[store].parent;
    }

    public void output() {
        System.out.println("Node\tParent");
        for (int i = 1; i <= n; i++) {
            System.out.println(obj[i].info + "\t" + obj[i].parent);
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        UnionFind u = new UnionFind();
        int a, b, choice, flag;
        char ch;
        flag = 0;

        while (true) {
            System.out.println("Operations in this program. Please enter:");
            System.out.println("1 -> Input the node");
            System.out.println("2 -> Union the node");
            System.out.println("3 -> Find the parent of node");
            System.out.println("4 -> Show all nodes and their parents");
            System.out.println("0 -> Quit from the program");
            System.out.print("Enter your choice: ");
            choice = sc.nextInt();

            switch (choice) {
                case 1:
                    u.input();
                    break;
                case 2:
                    System.out.print("Enter 2 nodes for union operation: ");
                    a = sc.nextInt();
                    b = sc.nextInt();
                    u.union(a, b);
                    break;
                case 3:
                    System.out.print("Enter node for find parent: ");
                    a = sc.nextInt();
                    u.find(a);
                    break;
                case 4:
                    u.output();
                    break;
                case 0:
                    System.out.print("Do you want to quit (y/n): ");
                    ch = sc.next().charAt(0);
                    if (ch == 'y' || ch == 'Y') {
                        flag = 1;
                    }
                    break;
                default:
                    System.out.println("You have entered an invalid choice. Please enter a valid choice.");
            }
            if (flag == 1) {
                break;
            }
        }
        sc.close();
    }
}
