package jianzhioffer;

public class L5 {
    public String replaceSpace(String s) {
        char[] array = s.toCharArray();
        StringBuilder res = new StringBuilder();
        for(char c: array){
            if(c == ' '){
                res.append("%20");
            }else{
                res.append(c);
            }
        }
        return res.toString();
    }
}
