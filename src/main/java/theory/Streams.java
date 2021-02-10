package theory;

import java.util.Arrays;
import java.util.List;

public class Streams {
    public static void main(String[] args) {
        List<String> list = Arrays.asList("1", "2", "3", "4", "5", "6", "7", "8", "9", "10");
        System.out.println(list.stream().findFirst().get());

        list = Arrays.asList("3", "2", "3", "4", "5", "6", "7", "8", "9", "10");
        for (int i = 0; i < 1000; i++)
            System.out.println(list.stream().parallel().unordered().findFirst().get());

    }
}
