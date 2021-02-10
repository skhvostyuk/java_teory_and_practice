package theory;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.Semaphore;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.function.BiFunction;
import java.util.function.Function;
import java.util.stream.Collectors;
import lombok.SneakyThrows;

public class Test {

    public static void main(String[] args) {
        AtomicBoolean atomicBoolean = new AtomicBoolean(true);
        new ThreadA(atomicBoolean).start();
        new ThreadB(atomicBoolean).start();
        new ArrayList<Integer>().add(1);
    }

    public static class ThreadA extends Thread {

        private final AtomicBoolean counter;

        public ThreadA(AtomicBoolean counter) {
            this.counter = counter;
        }

        @SneakyThrows
        @Override
        public void run() {
            while (true) {
                if (counter.get()) {
                    System.out.println("ping");
                    counter.set(false);
                } else {
                    Thread.sleep(10);
                }
            }
        }
    }

    public static class ThreadB extends Thread {

        private final AtomicBoolean counter;

        public ThreadB(AtomicBoolean counter) {
            this.counter = counter;
        }

        @SneakyThrows
        @Override
        public void run() {

            while (true) {
                if (!counter.get()) {
                    System.out.println("pong");
                    counter.set(true);
                } else {
                    Thread.sleep(10);
                }
            }
        }
    }



    public <T> T[]  generic(T[] array, Function<T, Boolean> filter) {
        return array;
    }

    public static <T> Map<T, Integer> cntVals(T[] avl) {
        return Arrays.stream(avl).
                collect(Collectors.toMap(x -> x, x -> 1, Integer::sum));
    }

}
