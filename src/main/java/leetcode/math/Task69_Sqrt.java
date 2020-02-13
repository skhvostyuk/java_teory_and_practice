package leetcode.math;

public class Task69_Sqrt {

    public static int mySqrt(int x) {
        if(x < 1)
            return 0;
        int low = 1, high = x;
        while (high - low > 1) {
            int mid = low + (high - low)/2;
            if(x/mid < mid)
                high = mid;
            else
                low = mid;
        }
        return low;
    }

    public static void main(String[] args) {
        System.out.println(mySqrt(1));
        System.out.println(mySqrt(4));
        System.out.println(mySqrt(8));
        System.out.println(mySqrt(9));
    }
}
