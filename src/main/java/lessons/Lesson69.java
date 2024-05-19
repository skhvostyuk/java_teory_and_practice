package lessons;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.Stack;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class Lesson69 {

    static Stack<String> nums = new Stack<>();
    static Stack<Character> operations = new Stack<>();
    static Map<Character, Integer> priority = new HashMap<>();

    static {
        priority.put('*', 2);
        priority.put('/', 2);
        priority.put('+', 1);
        priority.put('-', 1);
        priority.put('(', 0);
        priority.put(')', 0);
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String line = scanner.nextLine();

        computeLine(line);
    }

    private static String computeLine(String line) {
        line = line + " ";
        boolean readingNumber = false;
        int numberStart = 0;
        boolean wasOperation = false;

        for (int i = 0; i < line.length(); i++) {
            if (line.charAt(i) == ' ' && readingNumber) {
                readingNumber = false;
                nums.push(line.substring(numberStart, i));
            } else if ((line.charAt(i) >= '0' && line.charAt(i) <= '9') || line.charAt(i) == '.') {
                if (!readingNumber) {
                    readingNumber = true;
                    numberStart = i;
                }
            } else if (line.charAt(i) >= '(' && line.charAt(i) <= '/') {
                if (readingNumber) {
                    readingNumber = false;
                    nums.push(line.substring(numberStart, i));
                }
                Character currentOperation = line.charAt(i);
                System.out.println("currentOperation " + currentOperation);


                if (operations.isEmpty()) {
                    operations.push(currentOperation);
                } else if(currentOperation == ')') {
                    Character previousOperation = operations.peek();

                    while (previousOperation != '(') {
                        computeOperations();
                        previousOperation = operations.peek();
                    }
                    operations.pop();

                } else if(currentOperation == '('){
                    operations.push(currentOperation);
                } else {
                    Character previousOperation = operations.peek();
                    System.out.println("previousOperation " + previousOperation);
                    if (priority.get(currentOperation) >= priority.get(previousOperation)) {
                        operations.push(currentOperation);
                    } else {
                        while (priority.get(currentOperation) < priority.get(previousOperation)) {
                            computeOperations();

                            if(operations.empty()) {
                                throw new IllegalArgumentException("Wrong input");
                            }
                            previousOperation = operations.peek();
                        }
                    }
                }
            }
        }

        while (!operations.empty()) {
            computeOperations();
        }

        //System.out.println(nums);
        //System.out.println(operations);

        String answer = nums.pop();
        System.out.println("answer " + answer);

        return answer;
    }

    private static void computeOperations() {
        Character operation = operations.pop();
        System.out.println("operation " + operation);

        if(operation == '(' || operation == ')') {
            throw new IllegalArgumentException("Wrong input");
        }

        if(nums.empty()) {
            throw new IllegalArgumentException("Wrong input");
        }
        String a = nums.pop();

        if(nums.empty()) {
            throw new IllegalArgumentException("Wrong input");
        }
        String b = nums.pop();



        boolean isFloat = false;

        if (a.contains(".") || b.contains(".")) {
            Double doubleA = Double.parseDouble(a);
            Double doubleB = Double.parseDouble(b);

            if (operation == '+') {
                nums.push((doubleA + doubleB) + "");
            } else if (operation == '-') {
                nums.push((doubleA - doubleB) + "");
            } else if (operation == '/') {
                nums.push((doubleB / doubleA) + "");
            } else if (operation == '*') {
                nums.push((doubleA * doubleB) + "");
            }
        } else {
            Integer integerA = Integer.parseInt(a);
            Integer integerB = Integer.parseInt(b);

            if (operation == '+') {
                nums.push((integerA + integerB) + "");
            } else if (operation == '-') {
                nums.push((integerA - integerB) + "");
            } else if (operation == '/') {
                nums.push(((double) integerB / (double) integerA) + "");
            } else if (operation == '*') {
                nums.push((integerA * integerB) + "");
            }
        }
    }


    @Test
    public void tests() {
        Assertions.assertEquals("1", computeLine("1"));
        Assertions.assertEquals("2", computeLine("1 + 1"));
        Assertions.assertEquals("2", computeLine("(1 + 1)"));
        Assertions.assertEquals("3.0", computeLine("2 + 2 / 2"));
        Assertions.assertEquals("2.0", computeLine("(2 + 2) / 2"));
        Assertions.assertEquals("1.0", computeLine("(2 + 2) / (2 + 2)"));
        Assertions.assertEquals("1.0", computeLine("2 * 2 / (2 + 2)"));

        Assertions.assertThrows(IllegalArgumentException.class, () -> computeLine(") 1 + 1"));
        Assertions.assertThrows(IllegalArgumentException.class, () -> computeLine("1 + 1 ("));
        Assertions.assertThrows(IllegalArgumentException.class, () -> computeLine("+ 1 + 1"));
        Assertions.assertThrows(IllegalArgumentException.class, () -> computeLine("1 + 1 +"));


    }
}
