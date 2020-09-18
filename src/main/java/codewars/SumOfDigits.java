package codewars;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class SumOfDigits {

    public static int digital_root(int n) {
        int answer = 0;
        while (n > 0) {
            answer += n % 10;
            n = n / 10;
        }
        if (answer > 9)
            return digital_root(answer);

        return answer;
    }

    public static int smart_digital_root(int n) {
        return (n != 0 && n%9 == 0) ? 9 : n % 9;
    }

    @Test
    public void Test1() {
        assertEquals("Nope!", 7, digital_root(16));
    }

    @Test
    public void Test2() {
        assertEquals("Nope!", 6, digital_root(456));
    }
}
