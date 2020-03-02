package codewars;

import org.junit.Test;

import java.util.Arrays;
import java.util.stream.Collectors;

import static org.junit.Assert.assertEquals;

public class WeightSort {

    public static String orderWeight(String string) {

        return Arrays.stream(string.split(" "))
                .sorted(WeightSort::compareWeights)
                .collect(Collectors.joining(" "));
    }

    private static int compareWeights(String a, String b) {
        int aWeight = a.chars().map(Character::getNumericValue).sum();
        int bWeight = b.chars().map(Character::getNumericValue).sum();
        return aWeight - bWeight != 0 ? aWeight - bWeight : a.compareTo(b);
    }

    @Test
    public void BasicTests() {
        System.out.println("****** Basic Tests ******");
        assertEquals("2000 103 123 4444 99", WeightSort.orderWeight("103 123 4444 99 2000"));
        assertEquals("11 11 2000 10003 22 123 1234000 44444444 9999", WeightSort.orderWeight("2000 10003 1234000 44444444 9999 11 11 22 123"));
    }
}
