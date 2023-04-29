

package algorithm.recursion;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class No17 {
    private static Map<Character, List<String>> initMap() {
        Map<Character, List<String>> map = new HashMap<>();

        map.put('2', Arrays.asList("a", "b", "c"));
        map.put('3', Arrays.asList("d", "e", "f"));
        map.put('4', Arrays.asList("g", "h", "i"));
        map.put('5', Arrays.asList("j", "k", "l"));
        map.put('6', Arrays.asList("m", "n", "o"));
        map.put('7', Arrays.asList("p", "q", "r", "s"));
        map.put('8', Arrays.asList("t", "u", "v"));
        map.put('9', Arrays.asList("w", "x", "y", "z"));
        return map;
    }

    public static List<String> letterCombinations(String digits) {

        if (digits.length() == 0) {
            return Collections.emptyList();
        }
        if (digits.length() == 1) {
            return initMap().get(digits.charAt(0));
        }
        List<String> result = new ArrayList<>();
        for (char digit : digits.toCharArray()) {
            result = combine(digit, result);
        }
        return result;
    }


    public static List<String> letterCombinations2(String digits) {
        if (digits.length() == 0) {
            return Collections.emptyList();
        }
        if (digits.length() == 1) {
            return initMap().get(digits.charAt(0));
        }
        List<String> result = new ArrayList<>();
        combine(digits, 0, "", result);
        return result;

    }

    private static void combine(String digits, int index, String s, List<String> result) {
        if (digits.length() == index) {
            result.add(s);
            return;
        }
        Character c = digits.charAt(index);
        List<String> letters = initMap().get(c);
        for (String letter : letters) {
            combine(digits, index + 1, s + letter, result);
        }
    }


    private static List<String> combine(char digit, List<String> initList) {
        List<String> list = new ArrayList<>();
        if (initList.size() == 0) {
            return initMap().get(digit);
        }
        for (String string : initList) {
            for (String string2 : initMap().get(digit)) {
                list.add(string + string2);
            }
        }
        return list;
    }

    public static void main(String[] args) {
        String digits = "232";
        System.out.println(letterCombinations2(digits));
    }


}
