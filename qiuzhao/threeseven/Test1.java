package threeseven;

/**
 * @author budongbai
 * @version 2017年9月6日下午11:20:26
 */
public class Test1 {
    private String a;

    public void printA() {
        System.out.println(a + "ABC");
    }

    public void printB() {
        String b;
        //System.out.println(b+"ABC");
    }

    public static void main(String[] args) {

        Test1 tes = new Test1();
        tes.printA();
    }

}
