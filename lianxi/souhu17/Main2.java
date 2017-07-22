package souhu17;

import java.util.Scanner;

public class Main2 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int len = 6;
        int[] nums = new int[len + 1];
        int count = 0;
        while (scan.hasNextLine()) {

            for (int i = 1; i <= len; i++) {

                nums[i] = scan.nextInt();
                if (nums[i] == 0) {
                    count++;
                }

            }
            if (count == 6) {
                break;
            } else {
                count = 0;
                int sum = nums[6];
                while (nums[5] > 0) {
                    sum++;
                    nums[5]--;
                    if (nums[1] >= 11) {
                        nums[1] = nums[1] - 11;
                    } else if (nums[1] < 11 && nums[1] > 0) {
                        nums[1] = 0;
                    }
                }
                while (nums[4] > 0) {
                    sum++;
                    nums[4]--;
                    if (nums[2] > 0) {
                        if (nums[2] >= 5)
                            nums[2] = nums[2] - 5;
                        else if (nums[2] < 5) {
                            int last = 20 - 4 * nums[2];
                            nums[2] = 0;
                            if (nums[1] > 0) {
                                if (nums[1] < last)
                                    nums[1] = 0;
                                else
                                    nums[1] = nums[1] - last;
                            }
                        }
                    } else {
                        if (nums[1] >= 20) {
                            nums[1] = nums[1] - 20;
                        } else {
                            nums[1] = 0;
                        }
                    }
                }
                while (nums[3] > 0) {
                    sum++;
                    int last, num;
                    if (nums[3] >= 4) {
                        nums[3] = nums[3] - 4;
                        last = 0;
                        num = 4;
                    } else {
                        last = 36 - nums[3] * 9;
                        num = nums[3];
                        nums[3] = 0;
                    }
                    if (num == 4) {
                        continue;
                    } else if (num == 1) {
                        if (nums[2] >= 5) {
                            nums[2] = nums[2] - 5;
                            last = last - 20;
                            if (last < nums[1]) {
                                nums[1] = nums[1] - last;
                            } else {
                                nums[1] = 0;
                            }
                        } else {
                            last = last - nums[2] * 4;
                            nums[2] = 0;
                            if (last >= nums[1]) {
                                nums[1] = 0;
                            } else {
                                nums[1] = nums[1] - last;
                            }
                        }
                    } else if (num == 2) {
                        if (nums[2] >= 3) {
                            nums[2] = nums[2] - 3;
                            last = last - 12;
                            if (last < nums[1]) {
                                nums[1] = nums[1] - last;
                            } else {
                                nums[1] = 0;
                            }
                        } else {
                            last = last - nums[2] * 4;
                            nums[2] = 0;
                            if (last >= nums[1]) {
                                nums[1] = 0;
                            } else {
                                nums[1] = nums[1] - last;
                            }
                        }
                    } else if (num == 3) {
                        if (nums[2] >= 1) {
                            nums[2] = nums[2] - 1;
                            last = last - 4;
                            if (last < nums[1]) {
                                nums[1] = nums[1] - last;
                            } else {
                                nums[1] = 0;
                            }
                        } else {
                            last = last - nums[2] * 4;
                            nums[2] = 0;
                            if (last >= nums[1]) {
                                nums[1] = 0;
                            } else {
                                nums[1] = nums[1] - last;
                            }
                        }
                    }
                }
                while (nums[2] > 0) {
                    sum++;
                    if (nums[2] >= 9) {
                        nums[2] = nums[2] - 9;
                    } else {
                        int last = 36 - nums[2] * 4;
                        nums[2] = 0;
                        if (last > nums[1]) {
                            nums[1] = 0;
                        } else {
                            nums[1] = nums[1] - last;
                        }
                    }
                }
                while (nums[1] > 0) {
                    sum++;
                    if (nums[1] >= 36) {
                        nums[1] = nums[1] - 36;
                    } else {
                        nums[1] = 0;
                    }
                }
                System.out.println(sum);
            }

        }
        scan.close();
    }
}
