package algorithm.leetcodes51_100;

/**
 * @author budongbai
 * @version 2017年7月16日下午1:36:37
 */
public class L67 {
    public String addBinary(String a, String b) {
        int i = 0;
        int m = a.length();
        int n = b.length();
        int jinwei = 0;
        StringBuilder sb = new StringBuilder();
        // 从低位到高位一一相加
        while (i < m && i < n) {
            int num1 = a.charAt(m - 1 - i) - '0';
            int num2 = b.charAt(n - 1 - i) - '0';
            int sum = num1 + num2 + jinwei;
            sb.append(sum % 2);
            jinwei = sum / 2;
            i++;
        }
        // 位数多的这个继续加
        if (i < n) {
            for (int j = i; j < n; j++) {
                int num = b.charAt(n - 1 - j) - '0';
                int sum = num + jinwei;
                sb.append(sum % 2);
                jinwei = sum / 2;
            }
        } else if (i < m) {
            for (int j = i; j < m; j++) {
                int num = a.charAt(m - 1 - j) - '0';
                int sum = num + jinwei;
                sb.append(sum % 2);
                jinwei = sum / 2;
            }
        }
        if (jinwei != 0) {
            sb.append(jinwei);
        }
        return sb.reverse().toString();
    }

    public String addBinary2(String a, String b) {
        if (a == null || a.length() == 0) {
            return b;
        }
        if (b == null || b.length() == 0) {
            return a;
        }
        char[] aArr = a.toCharArray();
        char[] bArr = b.toCharArray();
        int i = a.length() - 1;
        int j = b.length() - 1;

        int carry = 0;
        StringBuilder sb = new StringBuilder();
        while (i > -1 || j > -1 || carry == 1) {
            int aByte = i > -1 ? Character.getNumericValue(aArr[i--]) : 0;
            int bByte = j > -1 ? Character.getNumericValue(bArr[j--]) : 0;
            sb.append(aByte ^ bByte ^ carry);
            carry = (aByte + bByte + carry) >= 2 ? 1 : 0;
        }
        return sb.reverse().toString();

    }


    public static void main(String[] args) {
        L67 test = new L67();
        String res = test.addBinary("11", "1");
        System.out.println(res);
    }
}
