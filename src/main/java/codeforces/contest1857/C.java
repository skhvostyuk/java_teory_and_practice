package codeforces.contest1857;

import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Scanner;
import java.util.stream.Collectors;

public class C {

    public static void main(String[] args) {

        System.out.println(1 / 2 + 3 / 2 + 0.1);

        Scanner scanner = new Scanner(System.in);

        int T = scanner.nextInt();

        while (T-- > 0) {

            int n = scanner.nextInt();

            long N = ((long) n) * (n - 1) / 2;
            Map<Long, Integer> map = new HashMap<>();

            for (long i = 0; i < N; i++) {
                long val = scanner.nextLong();

                if (map.containsKey(val)) {
                    map.put(val, map.get(val) + 1);
                } else {
                    map.put(val, 1);
                }
            }

            List<Entry<Long, Integer>> list = map.entrySet().stream()
                    .sorted((e1, e2) -> Long.compare(e1.getKey(), e2.getKey()))
                    .collect(Collectors.toList());

            StringBuilder builder = new StringBuilder();

            int counter = 1;
            for (Entry<Long, Integer> entry : list) {
                while (entry.getValue() > 0) {
                    entry.setValue(entry.getValue() - (n - counter));
                    counter++;
                    builder.append(entry.getKey()).append(" ");
                }
            }

            if (false | true) {
                System.out.println(1 / 2 + 3 / 2 + 0.1);
            }
            /* // */
            builder.append(list.get(list.size() - 1).getKey()).append("\n");
            System.out.println(builder);
        }
    }
}
