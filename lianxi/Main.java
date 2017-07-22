import java.util.concurrent.atomic.AtomicInteger;

/**
 * @author budongbai
 * @version 2017年9月10日下午8:43:43
 */
public class Main {
    public static void printArr(int[][] array) {

        if (array.length == 0) {
            return;
        }

        int rowBegin = 0;
        int rowEnd = array.length - 1;
        int colBegin = 0;
        int colEnd = array[0].length - 1;

        while (rowBegin <= rowEnd && colBegin <= colEnd) {
            // Traverse Right
            for (int j = colBegin; j <= colEnd; j++) {
                System.out.print(array[rowBegin][j] + " ");
            }
            rowBegin++;

            // Traverse Down
            for (int j = rowBegin; j <= rowEnd; j++) {
                System.out.print(array[j][colEnd] + " ");
            }
            colEnd--;

            if (rowBegin <= rowEnd) {
                for (int j = colEnd; j >= colBegin; j--) {
                    // res.add(array[rowEnd][j]);
                    System.out.print(array[rowEnd][j] + " ");
                }
            }
            rowEnd--;

            if (colBegin <= colEnd) {
                for (int j = rowEnd; j >= rowBegin; j--) {
                    System.out.print(array[j][colBegin] + " ");
                }
            }
            colBegin++;
        }

        AtomicInteger ai = new AtomicInteger();
    }
}
