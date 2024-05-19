package theory;

import java.util.HashMap;
import java.util.Map;
import java.util.Random;

public class Hash {

    static class A {

        private final int value;

        A(int value) {
            this.value = value;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) {
                return true;
            }
            if (o == null || getClass() != o.getClass()) {
                return false;
            }
            A a = (A) o;
            return value == a.value;
        }

        @Override
        public int hashCode() {
            return 10;
        }
    }

    public static int counter = 0;

    public static void main(String[] args) {
        Map<A, Integer> map = new HashMap<>();
        for(int i = 0; i < 1000; i++) {
            A a = new A(i);
            map.put(a, i);
        }

        counter = 0;

        for (int i = 0; i < 500; i++) {
            Random rnd = new Random();

            int v = rnd.nextInt(950);
            A a = new A(v);

            System.out.println("FFFF");
            System.out.println(v + " " + map.get(a));
            //System.out.print("1: " + System.identityHashCode(a) + ", ");
           // System.out.println(" 2: " + map.get(new A(i)));
            System.out.println(i + " counter: " + counter);

        }
        System.out.println("counter: " + counter);
        System.exit(0);

    }

}
