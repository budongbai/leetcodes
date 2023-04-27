package leetcodes1_50;

/**
 * @author budongbai
 * @version 2017年7月9日下午4:43:49
 */
public class L38 {
    public String countAndSay(int n) {
        int i = 2;
        String lastStr = "1";
        String res = "";
        if (n == 1) {
            return lastStr;
        }
        while (i <= n) {
            int len = lastStr.length();
            int count = 1;
            char c = lastStr.charAt(0);
            if (len == 1) {
                res += count + "" + c;
                lastStr = res;
                res = "";
            } else {
                for (int j = 1; j < len; j++) {
                    if (c == lastStr.charAt(j)) {
                        count++;
                    } else {
                        res += count + "" + c;
                        count = 1;
                        c = lastStr.charAt(j);
                    }
                }
                lastStr = res + count + "" + c;
                res = "";
            }
            i++;
        }
        return lastStr;
    }

    /**
     * 使用StringBuilder替换字符串+连接效率有所提高
     */
    public String countAndSay2(int n) {
        StringBuilder curr = new StringBuilder("1");
        StringBuilder prev;
        int count;
        char say;
        for (int i = 1; i < n; i++) {
            prev = curr;
            curr = new StringBuilder();
            count = 1;
            say = prev.charAt(0);

            for (int j = 1, len = prev.length(); j < len; j++) {
                if (prev.charAt(j) != say) {
                    curr.append(count).append(say);
                    count = 1;
                    say = prev.charAt(j);
                } else count++;
            }
            curr.append(count).append(say);
        }
        return curr.toString();
    }

    public static void main(String[] args) {
        L38 test = new L38();
        long l1 = System.currentTimeMillis();
        System.out.println(test.countAndSay(40));
        long l2 = System.currentTimeMillis();
        long l3 = System.currentTimeMillis();
        System.out.println(test.countAndSay2(40));
        long l4 = System.currentTimeMillis();
        System.out.println(l2 - l1 + "," + (l4 - l3));
        //相差近100倍
    }

}
