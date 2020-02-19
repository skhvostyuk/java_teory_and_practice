package codewars;

import org.junit.Test;

import java.util.Arrays;
import java.util.stream.Collectors;

import static org.junit.Assert.assertEquals;

public class Dubstep {

    public static String SongDecoder (String song)
    {
        return Arrays.stream(song.split("WUB")).collect(Collectors.joining(" "));
    }

    @Test
    public void Test1() {
        assertEquals("ABC", new Dubstep().SongDecoder("WUBWUBABCWUB"));
    }
    @Test
    public void Test2()
    {
        assertEquals("R L", new Dubstep().SongDecoder("RWUBWUBWUBLWUB"));
    }
}
