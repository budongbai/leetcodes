package wangyi;

import java.util.Scanner;

/*
 * 在一个N*N的数组中寻找所有横，竖，左上到右下，右上到左下，四种方向的直线连续D个数字的和里面最大的值 
输入描述:
每个测试输入包含1个测试用例，第一行包括两个整数 N 和 D :
3 <= N <= 100
1 <= D <= N
接下来有N行，每行N个数字d:
0 <= d <= 100
输出描述:
输出一个整数，表示找到的和的最大值

输入例子:
4 2
87 98 79 61
10 27 95 70
20 64 73 29
71 65 15 0

输出例子:
193*/

public class Wangyi {

	public int calculate(int[][] a, int n, int d) {
		int sum = 0;
		int max = a[0][0];
		int num = 0;
		// 计算横着的
		for (int i = 0; i < n; i++) {

			for (int j = 0; j <= n - d; j++) {
				for (int l = j; l < j + d; l++) {
					sum = a[i][l] + sum;
					num++;
					if (num == d) {
						System.out.println(sum);
						if (sum > max) {
							max = sum;
						}
					}
				}
				num = 0;
				sum = 0;
			}
		}
		System.out.println("----" + max);
		// 计算竖着的
		for (int i = 0; i < n; i++) {
			for (int j = 0; j <= n - d; j++) {
				for (int l = j; l < j + d; l++) {
					sum = a[l][i] + sum;
					num++;
					if (num == d) {
						System.out.println(sum);
						if (sum > max) {
							max = sum;
						}
					}
				}
				num = 0;
				sum = 0;
			}
		}
		System.out.println("----" + max);
		// 计算右上-左下
		for (int m = d - 1; m <= 2 * n - 2; m++) {
			int i = 0, j = m - i;
			while (j >= n) {
				i++;
				j--;
			}
			while (i >= n) {
				break;
			}
			while (i < n && j >= 0) {
				System.out.println(i + ", " + j);
				sum = a[i][j] + sum;
				num++;
				if (num == d) {
					System.out.println(sum);
					if (sum > max) {
						max = sum;
					}
				}
				i++;
				j--;
			}
			num = 0;
			sum = 0;
			System.out.println("---");
		}

		System.out.println("----");
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				for (int l = 0; l < d; l++) {
					sum = a[i][j] + sum;
				}
			}
			System.out.println(sum);
			if (sum > max) {
				max = sum;
				sum = 0;
			}
		}
		System.out.println("----");
		return max;
	}

	public static void main(String[] args) {

		// 读取
		Scanner scan = new Scanner(System.in);
		int N = scan.nextInt();
		int array[][] = new int[N][N];
		int sum = scan.nextInt();
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				array[i][j] = scan.nextInt();
			}
		}
		int maxInt = 0;
		// 水平
		for (int i = 0; i < N; i++) {

			for (int j = 0; j + sum - 1 < N; j++) {
				int temp = 0;
				for (int s = 0; s < sum; s++) {
					temp += array[i][j + s];
				}
				if (temp > maxInt) {
					maxInt = temp;
				}
			}

		}
		// 垂直
		for (int i = 0; i < N; i++) {

			for (int j = 0; j + sum - 1 < N; j++) {
				int temp = 0;
				for (int s = 0; s < sum; s++) {
					temp += array[j + s][i];
				}
				if (temp > maxInt) {
					maxInt = temp;
				}
			}

		}
		// 左上斜，这里的斜是所有的斜，不只是对角线的，刚开始理解错了一直不能全对
		for (int i = 0; i + sum - 1 < N; i++) {

			for (int j = 0; j + sum - 1 < N; j++) {
				int temp1 = 0;
				for (int s = 0; s < sum; s++) {
					System.out.println((i + s) + " " + (j + s));
					temp1 += array[i + s][j + s];
				}
				if (temp1 > maxInt) {
					maxInt = temp1;
				}
			}

		}
		// 右上斜
		System.out.println();
		for (int i = 0; i + sum - 1 < N; i++) {
			for (int j = 0; (j + sum - 1) < N; j++) {
				int temp2 = 0;
				for (int s = 0; s < sum; s++) {
					System.out.println((i + s) + " " + (N - j - s - 1));
					temp2 += array[i + s][N - j - s - 1];
				}
				if (temp2 > maxInt) {
					maxInt = temp2;
				}
			}
		}

		System.out.println(maxInt + "");
		scan.close();
	}

}
