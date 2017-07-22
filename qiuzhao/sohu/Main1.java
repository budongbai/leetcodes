package sohu;

import java.util.Arrays;
import java.util.Deque;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Scanner;
import java.util.Set;

/**
 * @author budongbai
 * @version 2017年9月17日下午7:22:00
 */
public class Main1 {

    public static String simplifyPath(String path) {
        Deque<String> stack = new LinkedList<>();
        Set<String> skip = new HashSet<>(Arrays.asList("..", ".", ""));
        for (String dir : path.split("/")) {
            //当dir为..，并且栈不为空，则弹出一个元素
            if (dir.equals("..") && !stack.isEmpty())
                stack.pop();
                //如果当前dir不是".."或"."或""，就压入栈
            else if (!skip.contains(dir))
                stack.push(dir);
        }
        String res = "";
        for (String dir : stack)
            res = "/" + dir + res;
        return res.isEmpty() ? "/" : res;
    }

    public static void main(String[] args) {

        Scanner scan = new Scanner(System.in);

        String path = scan.next();

        String simplePath = Main1.simplifyPath(path);
        System.out.println(simplePath);
        scan.close();
    }

}
