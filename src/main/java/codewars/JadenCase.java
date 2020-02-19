package codewars;

import org.junit.Test;

import java.util.Arrays;
import java.util.stream.Collectors;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;

public class JadenCase {

    public static String toJadenCase(String phrase) {
        if (phrase == null || phrase.equals(""))
            return null;

        return Arrays.stream(phrase.split(" "))
                .map(word -> word.replaceFirst("\\b[a-zA-Z]", word.substring(0, 1).toUpperCase()))
                .collect(Collectors.joining(" "));
    }



    @Test
    public void test() {
        assertEquals("toJadenCase doesn't return a valide JadenCase String! try again please :)", "Most Trees Are Blue", JadenCase.toJadenCase("most trees are blue"));
    }

    @Test
    public void testNullArg() {
        assertNull("Must return null when the arg is null", JadenCase.toJadenCase(null));
    }

   @Test
    public void testEmptyArg() {
        assertNull("Must return null when the arg is empty string", JadenCase.toJadenCase(""));
    }
}
