package leetcodes1_50;

/**
 * @author budongbai
 * @version 2017年6月15日上午11:01:22
 */
public class L6ZigZag {
    public String convert(String s, int numRows) {
        // 特殊场景处理，只有一行时不要进行啥操作，直接输出就完
        if (numRows == 1) {
            return s;
        }
        StringBuilder[] arr = new StringBuilder[numRows];

        for (int i = 0; i < arr.length; i++) {
            arr[i] = new StringBuilder();
        }

        int index = 0, incr = 1;
        for (char c : s.toCharArray()) {
            arr[index].append(c);
            if (index == 0) {
                incr = 1;
            } else if (index == numRows - 1) {
                incr = -1;
            }
            index += incr;
        }

        StringBuilder result = new StringBuilder();

        for (StringBuilder sb : arr) {
            result.append(sb);
        }

        return result.toString();
    }

    public static void main(String[] args) {
        L6ZigZag test = new L6ZigZag();
        System.out.println(test.convert("PAYPALISHIRING", 3));
    }
}
