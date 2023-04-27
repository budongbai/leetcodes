package leetcodes51_100;

import java.util.Arrays;
import java.util.Deque;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Set;

/**
 * @author budongbai
 * @version 2017年7月18日下午5:28:58
 */
public class L71 {
    public String simplifyPath(String path) {
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
        L71 test = new L71();
        String res = test.simplifyPath("///");
        System.out.println(res);
    }
}
