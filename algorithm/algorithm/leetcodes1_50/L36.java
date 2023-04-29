package algorithm.leetcodes1_50;

import java.util.HashSet;
import java.util.Set;

/**
 * @author budongbai
 * @version 2017年7月8日下午6:08:51
 */
public class L36 {
    public boolean isValidSudoku(char[][] board) {
        //默认有效，如果有一个违反则返回false
        //验证横向是否有效
        for (int i = 0; i < 9; i++) {
            Set<Character> set = new HashSet<Character>();
            for (int j = 0; j < 9; j++) {
                char c = board[i][j];
                if (c != '.') {
                    if (set.contains(c)) {
                        return false;
                    } else {
                        set.add(c);
                    }
                }
            }
        }
        //验证纵向是否有效
        for (int j = 0; j < 9; j++) {
            Set<Character> set = new HashSet<Character>();
            for (int i = 0; i < 9; i++) {
                char c = board[i][j];
                if (c != '.') {
                    if (set.contains(c)) {
                        return false;
                    } else {
                        set.add(c);
                    }
                }
            }
        }
        //验证单个3*3是否有效
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                Set<Character> set = new HashSet<Character>();
                for (int k = 0; k < 3; k++) {
                    for (int l = 0; l < 3; l++) {
                        char c = board[k + i * 3][l + j * 3];
                        if (c != '.') {
                            if (set.contains(c)) {
                                return false;
                            } else {
                                set.add(c);
                            }
                        }
                    }
                }

            }
        }
        return true;
    }

    public static void main(String[] args) {

        String[] s = {".87654321", "2........", "3........", "4........", "5........", "6........", "7........", "8........", "9........"};
        char[][] cs = new char[9][9];
        for (int i = 0; i < 9; i++) {
            cs[i] = s[i].toCharArray();
        }
        L36 test = new L36();
        System.out.println(test.isValidSudoku(cs));
    }

}
