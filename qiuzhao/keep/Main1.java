package keep;

/**
 * @author budongbai
 * @version 2017年9月23日下午11:25:11
 */
public class Main1 {

    public static void main(String[] args) {

        int[] arr = {1, 6, 3, 4, 9, 2, 1};
        int max = 0;
        for (int i = 0; i < arr.length; i++) {
            int sum = 0;
            int j;
            for (j = i; j < arr.length; j += 3) {
                sum += arr[j];
                //System.out.print(arr[j]+" ");
            }
            int start = j % arr.length;
            for (j = start; j < i; j += 3) {
                sum += arr[j];
                //System.out.print(arr[j]+" ");
            }
            //System.out.println();
            if (sum > max) {
                max = sum;
            }
        }
        System.out.println(max);
    }

}
