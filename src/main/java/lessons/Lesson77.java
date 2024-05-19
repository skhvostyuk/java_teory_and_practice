package lessons;

public class Lesson77 {

    public static void main(String[] args) {
        System.out.println(kthElement(new int[]{1, 2, 3, 4, 5}, 3));
        System.out.println(kthElement(new int[]{5, 4, 3, 2, 1}, 3));
        System.out.println(kthElement(new int[]{3, 2, 1, 4, 5}, 3));
        System.out.println(kthElement(new int[]{1, 1, 1, 1, 1}, 3));
    }

    public static int kthElement(int[] array, int k) {
        int left = 0, right = array.length - 1;

        while (left < right) {
            int leftPointer = left, rightPointer = right;
            int median = (right + left)/2;
            int medianValue = array[median];

            while (leftPointer < rightPointer) {
                while (array[leftPointer] < medianValue) {
                    leftPointer++;
                }

                while (array[rightPointer] > medianValue) {
                    rightPointer--;
                }

                if(leftPointer>= rightPointer) {
                    break;
                }

                swap(array, leftPointer++, rightPointer--);
            }

            if (k < leftPointer) {
                right = leftPointer;
            } else if (k > leftPointer){
                left = leftPointer;
            } else {
                return array[k];
            }
        }
        
        return array[left];
    }


    public static void swap(int[] arr, int a, int b) {
        arr[a] ^= arr[b];
        arr[b] ^= arr[a];
        arr[a] ^= arr[b];
    }

}
