//package codeforces.edu161;//package codeforces.edu161;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.StringTokenizer;

public class oldD {

    public static class Monster {

        public int index;
        public int a;
        public int d;

        public Monster left;
        public Monster right;

        public boolean isDead = false;

        public Monster(int index, int a, int d) {
            this.index = index;
            this.a = a;
            this.d = d;
        }
    }

    public static void main(String[] args) {
        FastReader fastReader = new FastReader();
        PrintWriter out = new PrintWriter(System.out);

        int T = fastReader.nextInt();

        while (T-- > 0) {
            int n = fastReader.nextInt();
            int[] a = new int[n];
            for (int i = 0; i < n; i++) {
                a[i] = fastReader.nextInt();
            }

            int[] d = new int[n];
            for (int i = 0; i < n; i++) {
                d[i] = fastReader.nextInt();
            }

            if (n == 1) {
                out.println("0");
                continue;
            }

            Monster[] monsters = new Monster[n];
            for (int i = 0; i < n; i++) {
                monsters[i] = new Monster(i, a[i], d[i]);
            }
            monsters[0].right = monsters[1];
            monsters[n - 1].left = monsters[n - 2];

            for (int i = 1; i < n - 1; i++) {
                monsters[i].left = monsters[i - 1];
                monsters[i].right = monsters[i + 1];
            }

            List<Monster> candidates = Arrays.stream(monsters).toList();

            int[] damage = new int[n + 2];

            for (int round = 0; round < n; round++) {
                for (Monster monster : candidates) {
                    damage[monster.index] = 0;

                    if (monster.left != null) {
                        damage[monster.index] += monster.left.a;
                    }
                    if (monster.right != null) {
                        damage[monster.index] += monster.right.a;
                    }
                }

                List<Monster> newCandidates = new ArrayList<>();
                int dead = 0;

                for (Monster monster : candidates) {
                    if (!monster.isDead && damage[monster.index] > monster.d) {
                        dead++;

                        if (monster.left != null) {
                            newCandidates.add(monster.left);
                            monster.left.right = monster.right;
                        }
                        if (monster.right != null) {
                            newCandidates.add(monster.right);
                            monster.right.left = monster.left;
                        }
                        monster.isDead = true;
                    }
                }

                candidates = newCandidates;

                out.println(dead);
            }


        }
        out.flush();
    }


    static class FastReader {

        BufferedReader br;
        StringTokenizer st;

        public FastReader() {
            br = new BufferedReader(
                    new InputStreamReader(System.in));
        }

        String next() {
            while (st == null || !st.hasMoreElements()) {
                try {
                    st = new StringTokenizer(br.readLine());
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            return st.nextToken();
        }

        int nextInt() {
            return Integer.parseInt(next());
        }

        long nextLong() {
            return Long.parseLong(next());
        }

        double nextDouble() {
            return Double.parseDouble(next());
        }

        String nextLine() {
            String str = "";
            try {
                if (st.hasMoreTokens()) {
                    str = st.nextToken("\n");
                } else {
                    str = br.readLine();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
            return str;
        }
    }

}
