package codewars;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class HumanReadableTime {

    public static String makeReadable(int seconds) {
        return String.format("%02d:%02d:%02d", seconds/60/60, seconds/60%60, seconds%60);
    }

    @Test
    public void Tests() {
        assertEquals("makeReadable(0)", "00:00:00", HumanReadableTime.makeReadable(0));
        assertEquals("makeReadable(5)", "00:00:05", HumanReadableTime.makeReadable(5));
        assertEquals("makeReadable(60)", "00:01:00", HumanReadableTime.makeReadable(60));
        assertEquals("makeReadable(86399)", "23:59:59", HumanReadableTime.makeReadable(86399));
        assertEquals("makeReadable(359999)", "99:59:59", HumanReadableTime.makeReadable(359999));
    }
}
