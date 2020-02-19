package codewars;

import org.junit.Test;

import java.util.*;

import static org.junit.Assert.assertArrayEquals;

public class EnoughIsEnough {

    public static int[] deleteNth(int[] elements, int maxOccurrences) {
        if (maxOccurrences < 1)
            return new int[]{};

        Map<Integer, Integer> numOfElementsMap = new HashMap<>();
        List<Integer> list = new ArrayList<>(elements.length);

        for (int element : elements) {
            if (numOfElementsMap.get(element) == null || numOfElementsMap.get(element) < maxOccurrences)
                list.add(element);
            numOfElementsMap.merge(element, 1, Integer::sum);

        }

        return list.stream().mapToInt(Integer::intValue).toArray();
    }

    @Test
    public void deleteNth() throws Exception {
        assertArrayEquals(
                new int[] {},
                EnoughIsEnough.deleteNth( new int[] { 20, 37, 20, 21 }, 0 )
        );
        assertArrayEquals(
                new int[] { 1, 1, 3, 3, 7, 2, 2, 2 },
                EnoughIsEnough.deleteNth( new int[] { 1, 1, 3, 3, 7, 2, 2, 2, 2 }, 3 )

        );
        assertArrayEquals(
                new int[] { 1, 2, 3, 1, 1, 2, 2, 3, 3, 4, 5 },
                EnoughIsEnough.deleteNth( new int[] { 1, 2, 3, 1, 1, 2, 1, 2, 3, 3, 2, 4, 5, 3, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1 }, 3 )
        );
        assertArrayEquals(
                new int[] { 1, 1, 1, 1, 1 },
                EnoughIsEnough.deleteNth( new int[] { 1, 1, 1, 1, 1 }, 5 )
        );
        assertArrayEquals(
                new int[] { },
                EnoughIsEnough.deleteNth( new int[] { }, 5 )
        );

        System.out.println(Arrays.toString(new int[18]));
        System.out.println(Arrays.toString(EnoughIsEnough.deleteNth( new int[18] , 5 )));

        System.out.println(EnoughIsEnough.deleteNth( new int[18] , 5 ).length);

    }


}