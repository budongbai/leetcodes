package datastructures;

/**
 * 在2.5亿个整数中找出所有出现了的整数的个数，内存空间不足以容纳这2.5亿个整数
 * 使用bitmap实现，只需要两个状态，有或者没有，有的整数就计数++
 *
 * @author budongbai
 * @version 2017年4月15日下午4:15:10
 */
public class Bitmap {
    public static final int SHIFT = 5;
    public static final int MASK = 1;

    public static void setVal(int n, int[] arr) {
        int indexLoc, bitLoc;
        indexLoc = n >> SHIFT;
        bitLoc = n % 32;
        arr[indexLoc] |= 1 << bitLoc;//设置第bitLoc位为1
    }

    public static void init(int n, int[] arr) {
        int indexLoc;
        indexLoc = n >> SHIFT;
        arr[indexLoc] &= 0;
    }

    public static int getFlag(int n, int[] arr) {
        int flag;
        int indexLoc = n >> SHIFT;
        int bitLoc = n % 32;
        flag = arr[indexLoc] >> bitLoc & MASK;
        return flag;
    }

    public static void main(String[] args) {

		/*int[] arr = new int[5000/32+1];
		for(int i=0; i< 8000;i++){
			int num = (int) (Math.random()*5000) ;
			System.out.print(num+" ");
			setVal(num,arr);
			
		}*/
        int[] arr = new int[1];

        int[] a = {3, 5, 2, 4, 7, 5, 6, 7, 8, 10};
        for (int i = 0; i < a.length; i++) {
            setVal(a[i], arr);
        }
        int count = 0;
        for (int i = 0; i < 11; i++) {
            int flag = getFlag(i, arr);
            System.out.println("i=" + i + " " + flag);
            if (flag != 0) {
                count++;
            }
        }
        System.out.println(count);
        System.out.println(Integer.toBinaryString(arr[0]));
    }

}
