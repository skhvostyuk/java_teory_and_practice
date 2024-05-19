package leetcode.array;

import org.junit.jupiter.api.Test;

import java.util.*;

public class Task380_InsertDeleteGetRandom {

    public static class RandomizedSet {
        Set<Integer> set = new HashSet<>();
        List<Integer> list = new LinkedList<>();
        Random random = new Random();

        public RandomizedSet() {

        }

        public boolean insert(int val) {
            if (set.contains(val)) {
                return false;
            }
            set.add(val);
            list.add(val);
            System.out.println(list);
            return true;
        }

        public boolean remove(int val) {
            if (!set.contains(val)) {
                return false;
            }
            set.remove(val);
            list.remove(Integer.valueOf(val));
            System.out.println(list);
            return true;
        }

        public int getRandom() {
            if(list.size() == 1) {
                return list.get(0);
            }
            int index = random.nextInt(list.size() - 1);
            return list.get(index);
        }
    }

    @Test
    public void test() {
        RandomizedSet set = new RandomizedSet();
        set.insert(1);
        set.remove(2);
        set.insert(2);
        set.getRandom();
        set.remove(1);
        set.insert(2);
        set.getRandom();
    }

}



/**
 * Your RandomizedSet object will be instantiated and called as such:
 * RandomizedSet obj = new RandomizedSet();
 * boolean param_1 = obj.insert(val);
 * boolean param_2 = obj.remove(val);
 * int param_3 = obj.getRandom();
 */

