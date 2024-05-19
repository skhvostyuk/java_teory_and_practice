package codeforces.contest915;//package codeforces.contest1857;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

public class B {

    private static class Node {
        List<Node> nodes = new ArrayList<>(2);
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int T = scanner.nextInt();


        while (T-- > 0) {
            int n = scanner.nextInt();

            Map<Integer, Node> nodes = new HashMap<>();

            for(int i = 1; i <= n; i++) {
                nodes.put(i, new Node());
            }

            for(int i = 1; i < n; i++) {
                Node v = nodes.get(scanner.nextInt());
                Node u = nodes.get(scanner.nextInt());

                v.nodes.add(u);
                u.nodes.add(v);
            }
            int counter;
            Node root = nodes.get(1);
            counter = findLeafs(root, null);
            System.out.println(counter % 2 == 0 ? counter/2 : counter/2 + 1);
        }
    }

    private static int findLeafs(Node root, Node prev) {
        if(root.nodes.size() == 1 && prev != null) {
            return 1;
        } else if (root.nodes.size() == 1) {
            return 1 + findLeafs(root.nodes.get(0), root);
        }

        return root.nodes.stream()
                .filter(node -> node != prev)
                .mapToInt(node-> findLeafs(node, root))
                .sum();
    }

}
