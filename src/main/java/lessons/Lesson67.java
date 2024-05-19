package lessons;

import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.Scanner;
import java.util.Set;

public class Lesson67 {
/*
    static class Node {

        char c;
        Set<Node> lower = new HashSet<>();
        Set<Node> bigger = new HashSet<>();

        Node parent;

        int h;

        public Node(char c, Node parent) {
            this.c = c;
            this.parent = parent;
            if (parent == null) {
                h = 0;
            } else {
                h = parent.h + 1;
            }
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) {
                return true;
            }
            if (o == null || getClass() != o.getClass()) {
                return false;
            }
            Node node = (Node) o;
            return c == node.c;
        }

        @Override
        public int hashCode() {
            return Objects.hash(c);
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = scanner.nextInt();

        List<String> list = Arrays.stream(scanner.nextLine().split(" ")).toList();

        Map<Character, Node> map = new HashMap<>();

        for (int i = 0; i < n - 1; i++) {
            String lower = list.get(i);
            String bigger = list.get(i + 1);
            for (int j = 0; i < Math.min(lower.length(), bigger.length()); j++) {
                if (lower.charAt(j) != bigger.charAt(j)) {
                    if (!map.containsKey(lower.charAt(j)) && !map.containsKey(bigger.charAt(j))) {
                        Node l = new Node(lower.charAt(j), null);
                        map.put(lower.charAt(j), l);
                        Node b = new Node(bigger.charAt(j), l);
                        map.put(lower.charAt(j), b);

                        l.bigger.add(b);
                    } else if (!map.containsKey(lower.charAt(j))) {
                        Node b = map.get(bigger.charAt(j));
                        Node l = new Node(lower.charAt(j), b);
                        map.put(lower.charAt(j), l);

                        b.lower.add(l);
                    } else if (!map.containsKey(bigger.charAt(j))) {
                        Node l = map.get(lower.charAt(j));
                        Node b = new Node(bigger.charAt(j), l);
                        map.put(bigger.charAt(j), b);

                        map.get(lower.charAt(j)).bigger.add(b);
                    } else {
                        Node l = map.get(lower.charAt(j)), low = l;
                        Node b = map.get(bigger.charAt(j)), big = b;

                        if (hasBigger(l, b) || hasLower(b, l)) {
                            continue;
                        }

                        if (l.h != b.h) {
                            int maxH = Math.max(l.h, b.h);

                            if (l.h == maxH) {
                                while (l.h != b.h) {
                                    l = l.parent;
                                }
                            } else {
                                while (b.h != l.h) {
                                    b = b.parent;
                                }
                            }

                            while (b.parent != l.parent && b.parent != null && l.parent != null) {
                                b = b.parent;
                                l = l.parent;
                            }

                            if (b.parent != null && l.parent != null) {
                                if(b.parent.bigger.contains(b)) {
                                    continue;
                                }




                            }

                        }
                    }
                }
            }
        }


    }

    static boolean hasBigger(Node node, Node bigger) {
        if (node.bigger.contains(bigger)) {
            return true;
        }

        for (Node n : node.bigger) {
            if (hasBigger(n, bigger)) {
                return true;
            }
        }

        return false;
    }

    static boolean hasLower(Node node, Node lower) {
        if (node.lower.contains(lower)) {
            return true;
        }

        for (Node n : node.lower) {
            if (hasLower(n, lower)) {
                return true;
            }
        }

        return false;
    }
*/
}
