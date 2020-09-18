package codewars;
//it returns the sum of all the multiples of 3 or 5 below the number passed in
public class MultiplesOf3Or5 {

    //TODO: Переделать на стримы
    public static int solution(int number) {
        int sum = 0;
        for (int i = 0; i < number; i++) {
            if(i % 15 == 0) {
                sum += i;
                continue;
            } else if (i % 5 == 0) {
                sum += i;
                continue;
            } else if (i % 3 == 0) {
                sum += i;
                continue;
            }
        }
        return sum;
    }

    public static void main(String[] args) {
        System.out.println(solution(10));
    }
}
