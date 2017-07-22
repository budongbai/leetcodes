package com.budongbai.offer;

public class MovingRangeOfRobot {
    boolean[][] visited;

    public int movingCount(int threshold, int rows, int cols) {


        visited = new boolean[rows][cols];

        return movingCountCore(threshold, rows, cols, 0, 0);
    }

    private int movingCountCore(int threshold, int rows, int cols, int i, int j) {
        int count = 0;

        if (check(threshold, rows, cols, i, j)) {
            visited[i][j] = true;
            count = 1 + movingCountCore(threshold, rows, cols, i, j + 1)
                + movingCountCore(threshold, rows, cols, i + 1, j)
                + movingCountCore(threshold, rows, cols, i - 1, j)
                + movingCountCore(threshold, rows, cols, i, j - 1);
        }
        return count;
    }

    private boolean check(int threshold, int rows, int cols, int i, int j) {
        return i >= 0 && j >= 0 && i < rows && j < cols
            && !visited[i][j]
            && getDigitSum(i) + getDigitSum(j) <= threshold;
    }

    private int getDigitSum(int number) {
        int sum = 0;
        while (number > 0) {
            sum += number % 10;
            number = number / 10;
        }
        return sum;
    }

    public static void main(String[] args) {

        MovingRangeOfRobot demo = new MovingRangeOfRobot();
        System.out.println(demo.getDigitSum(3533));
    }
}