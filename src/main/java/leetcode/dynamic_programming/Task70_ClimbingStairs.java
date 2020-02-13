package leetcode.dynamic_programming;

public class Task70_ClimbingStairs {
    public static int climbStairs(int n) {
        if (n == 1)
            return 1;
        else if (n == 2)
            return 2;
        int first = 1, second = 2, third = 0;

        for(int i = 3; i <= n; i++) {
            third = first + second;
            first = second;
            second = third;
        }
        return third;
    }

    public static void main(String[] args) {
        System.out.println(climbStairs(1));
        System.out.println(climbStairs(2));
        System.out.println(climbStairs(3));
        System.out.println(climbStairs(4));
        System.out.println(climbStairs(1000000));
    }

}
