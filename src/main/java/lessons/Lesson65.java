package lessons;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Lesson65 {

    //https://codeforces.com/contest/339/problem/D

    static class Node {

        Node left;
        Node right;
        boolean operation; // true = xor
        int value;
        int start;
        int end;


        @Override
        public String toString() {
            return "Node{" +
                    "operation=" + operation +
                    ", value=" + value +
                    ", start=" + start +
                    ", end=" + end +
                    ",\n left=" + left +
                    ",\n right=" + right +
                    '}';
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = scanner.nextInt();
        int m = scanner.nextInt();

        int powN = (int) Math.pow(2, n);

        int[] a = new int[powN];

        for (int i = 0; i < powN; i++) {
            a[i] = scanner.nextInt();
        }

        Node root = buildTree(a, 0, powN);

        System.out.println(root);
        //System.out.println(root.value);

        for (int i = 0; i < m; i++) {
            int p = scanner.nextInt();
            int b = scanner.nextInt();

            a[p] = b;

            updateTree(root, a, p);
            System.out.println(root.value);
            System.out.println(root);


        }


    }

    private static void updateTree(Node root, int[] a, int p) {

        if (root.end - root.start <= 2) {
            root.value = a[root.start] | a[root.start + 1];
            return;
        }

        if (p < root.left.end) {
            updateTree(root.left, a, p);
        } else {
            updateTree(root.right, a, p);
        }

        if (root.operation) {
            root.value = root.left.value ^ root.right.value;
        } else {
            root.value = root.left.value | root.right.value;
        }
    }

    private static Node buildTree(int[] a, int start, int end) {
        Node node = new Node();

        node.start = start;
        node.end = end;

        if (end - start <= 2) {
            node.value = a[start] | a[start + 1];
            node.operation = false;
            return node;
        }

        node.left = buildTree(a, start, (start + end) / 2);
        node.right = buildTree(a, (start + end) / 2, end);
        node.operation = !node.left.operation;

        if (node.operation) {
            node.value = node.left.value ^ node.right.value;
        } else {
            node.value = node.left.value | node.right.value;
        }
        return node;
    }
}
