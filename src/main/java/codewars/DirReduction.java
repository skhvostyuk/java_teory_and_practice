package codewars;

import com.sun.xml.internal.ws.api.model.wsdl.WSDLOutput;
import org.junit.Test;

import java.util.*;

import static org.junit.Assert.assertArrayEquals;

public class DirReduction {
    private static Map<String, String> oppositeDirection = new HashMap<>();

    static {
        oppositeDirection.put("NORTH", "SOUTH");
        oppositeDirection.put("SOUTH", "NORTH");
        oppositeDirection.put("WEST", "EAST");
        oppositeDirection.put("EAST", "WEST");
    }

    public static String[] dirReduc(String[] arr) {
        List<String> path = new ArrayList<>(Arrays.asList(arr));

        for (int i = 0; i < path.size() - 1; i++) {
            if (isOpposite(path.get(i), path.get(i + 1))) {
                path.remove(i);
                path.remove(i);
                if (i > 0)
                    i -= 2;
            }
        }
        return path.toArray(new String[0]);
    }

    public static String[] dirReduc2(String[] arr) {
        Stack<String> stack = new Stack<>();

        for (String s : arr) {
            if (!stack.isEmpty() && isOpposite(stack.peek(), s))
                stack.pop();
            else
                stack.push(s);
        }
        return stack.toArray(new String[0]);
    }

    private static boolean isOpposite(String direction1, String direction2) {
        return direction2.equals(oppositeDirection.get(direction1));
    }

    @Test
    public void testSimpleDirReduc() {
        System.out.println(Arrays.toString(DirReduction.dirReduc2(new String[]{"NORTH", "SOUTH", "SOUTH", "EAST", "WEST", "NORTH", "WEST"})));

        assertArrayEquals("\"NORTH\", \"SOUTH\", \"SOUTH\", \"EAST\", \"WEST\", \"NORTH\", \"WEST\"",
                new String[]{"WEST"},
                DirReduction.dirReduc2(new String[]{"NORTH", "SOUTH", "SOUTH", "EAST", "WEST", "NORTH", "WEST"}));
        assertArrayEquals("\"NORTH\",\"SOUTH\",\"SOUTH\",\"EAST\",\"WEST\",\"NORTH\"",
                new String[]{},
                DirReduction.dirReduc2(new String[]{"NORTH", "SOUTH", "SOUTH", "EAST", "WEST", "NORTH"}));
    }
}
