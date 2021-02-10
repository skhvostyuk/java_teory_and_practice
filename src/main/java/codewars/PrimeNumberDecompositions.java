package codewars;

import static org.junit.Assert.assertEquals;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import org.junit.BeforeClass;
import org.junit.Test;

public class PrimeNumberDecompositions {

    public static void main(String[] args) {
        System.out.println(Arrays.deepToString(getAllPrimeFactors(0)));
        System.out.println(Arrays.deepToString(getUniquePrimeFactorsWithCount(0)));
        System.out.println(Arrays.deepToString(getPrimeFactorPotencies(0)));
    }

    public static Long[] getAllPrimeFactors(long num) {
        ArrayList<Long> result = new ArrayList<>();
        for (long prime = 2; prime <= num; prime++) {
            for (; num % prime == 0; num /= prime) {
                result.add(prime);
            }
        }
        return result.toArray(new Long[result.size()]);
    }

    public static Long[][] getUniquePrimeFactorsWithCount(long num) {
        Long[] primeF = getAllPrimeFactors(num);
        Set<Long> set = new HashSet<Long>(Arrays.asList(primeF));
        Long[][] result = new Long[2][set.size()];
        result[0] = set.toArray(new Long[set.size()]);
        for (int i = 0; i < result[0].length; i++) {
            result[1][i] = (long) Collections.frequency(Arrays.asList(primeF), result[0][i]);
        }
        return result;
    }

    public static Long[] getPrimeFactorPotencies(long num) {
        Long[][] primeFC = getUniquePrimeFactorsWithCount(num);
        Long[] result = new Long[primeFC[0].length];
        for (int i = 0; i < primeFC[0].length; i++) {
            result[i] = (long) Math.pow(primeFC[0][i], primeFC[1][i]);
        }
        return result;
    }
}
