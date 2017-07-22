

package com.budongbai.offer;

/**
 * 二维数组中的查找
 */
public class FindInSecondArray {

    public boolean contains(int[][] array, int number) {
        for (int i = 0; i < array.length; i++) {
            for (int j = 0; j < array[0].length; j++) {
                if (array[i][j] == number) {
                    return true;
                }
            }
        }
        return false;
    }


    public static boolean find(int target, int[][] array) {
        int startI = 0, endI = array.length;

        while (startI < endI) {

            int middleI = (endI - startI) >> 1 + startI;

            for (int j = 0; j < array[0].length; j++) {
                if (array[middleI][j] == target) {
                    return true;
                } else if (array[middleI][j] > target) {
                    endI = middleI;
                } else {
                    startI = middleI + 1;
                }
            }

        }
        return false;
    }

    public static boolean find2(int target, int[][] array) {
        int curRow = 0, curCol = array[0].length - 1;

        while (curCol >= 0 && curRow < array.length) {
            if (array[curRow][curCol] == target) {
                return true;
            } else if (array[curRow][curCol] > target) {
                curCol--;
            } else {
                curRow++;
            }
        }

        return false;
    }


    public static void main(String[] args) {
        int[][] array = {{1, 2}};
        System.out.println(find2(3, array));
    }
}
