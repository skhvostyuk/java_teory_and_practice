package codewars;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import java.util.HashMap;
import org.junit.Test;

public class SudokuSolutionValidator {

    public static final int DIMENSION = 9;

    public static boolean check(int[][] sudoku) {
        HashMap<Integer, Integer> checkMap = prepareMap();
        // 1. check every line
        for (int i = 0; i < DIMENSION; i++) {
            for (int j = 0; j < DIMENSION; j++) {
                if (checkMap.containsKey(sudoku[i][j]) && checkMap.get(sudoku[i][j]) == 0) {
                    checkMap.put(sudoku[i][j], 1);
                } else {
                    return false;
                }
            }
            if (!checkMap(checkMap))
                return false;
            cleanMap(checkMap);
        }

        // 2. check every column
        for(int j = 0; j < DIMENSION; j++) {
            for (int i = 0; i < DIMENSION; i++) {
                if (checkMap.containsKey(sudoku[i][j]) && checkMap.get(sudoku[i][j]) == 0) {
                    checkMap.put(sudoku[i][j], 1);
                } else {
                    return false;
                }
            }
            if (!checkMap(checkMap))
                return false;
            cleanMap(checkMap);
        }


        // 3. check every 3x3

        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                for (int ind = 0; ind < DIMENSION; ind++) {
                    if (checkMap.containsKey(sudoku[ind/3 + i * 3][ind%3 + j * 3]) && checkMap.get(sudoku[ind/3 + i * 3][ind%3 + j * 3]) == 0) {
                        checkMap.put(sudoku[ind/3 + i * 3][ind%3 + j * 3], 1);
                    } else {
                        return false;
                    }
                }
                if (!checkMap(checkMap))
                    return false;
                cleanMap(checkMap);
            }
        }

        return true;
    }


    private static boolean checkMap(HashMap<Integer, Integer> checkMap) {
        for(int i = 1; i <= DIMENSION; i++)
            if (checkMap.get(i) != 1)
                return false;
        return true;
    }

    private static HashMap<Integer, Integer> prepareMap() {
        HashMap<Integer, Integer> checkMap = new HashMap<>(DIMENSION);
        cleanMap(checkMap);
        return checkMap;
    }


    private static void cleanMap(HashMap<Integer, Integer> checkMap) {
        for (int i = 1; i <= DIMENSION; i++) {
            checkMap.put(i, 0);
        }
    }
    @Test
    public void exampleTest() {
        int[][] sudoku = {
                {5, 3, 4, 6, 7, 8, 9, 1, 2},
                {6, 7, 2, 1, 9, 5, 3, 4, 8},
                {1, 9, 8, 3, 4, 2, 5, 6, 7},
                {8, 5, 9, 7, 6, 1, 4, 2, 3},
                {4, 2, 6, 8, 5, 3, 7, 9, 1},
                {7, 1, 3, 9, 2, 4, 8, 5, 6},
                {9, 6, 1, 5, 3, 7, 2, 8, 4},
                {2, 8, 7, 4, 1, 9, 6, 3, 5},
                {3, 4, 5, 2, 8, 6, 1, 7, 9}
        };
        assertTrue(check(sudoku));

        sudoku[0][0]++;
        sudoku[1][1]++;
        sudoku[0][1]--;
        sudoku[1][0]--;

        assertFalse(check(sudoku));

        sudoku[0][0]--;
        sudoku[1][1]--;
        sudoku[0][1]++;
        sudoku[1][0]++;

        sudoku[4][4] = 0;

        assertFalse(check(sudoku));
    }
}
