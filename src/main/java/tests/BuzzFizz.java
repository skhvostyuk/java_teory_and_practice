package tests;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class BuzzFizz {

    public static void main(String[] args) {
        int[] array = IntStream.range(0, 100).map(i -> new Random().nextInt()).toArray();
        buzzFizz(array);
    }

    public static void buzzFizz (int[] arr) {
        for(int i = 0; i < arr.length; i++) {
            if (i % 3 == 0) {
                System.out.print("Buzz");
            }
            if (i % 5 == 0) {
                System.out.print("Fizz");
            }
            if (i % 3 != 0 && i % 5 != 0) {
                System.out.print(i);
            }
            System.out.println();
        }
    }
}
