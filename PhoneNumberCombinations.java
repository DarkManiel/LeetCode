import java.util.ArrayList;
import java.util.List;

/**
 * Created by markdaniel on 8/20/15.
 */
public class PhoneNumberCombinations {
    public static void main(String[] args) {
        List<String> combos = letterCombinations("23");
        for (String s: combos) {
            System.out.println(s + " ");
        }
    }
    public static List<String> letterCombinations(String digits) {
        List<String> result = new ArrayList<>();
        List<String> dictionary = new ArrayList<>();
        dictionary.add("");
        dictionary.add("");
        dictionary.add("abc");
        dictionary.add("def");
        dictionary.add("ghi");
        dictionary.add("jkl");
        dictionary.add("mno");
        dictionary.add("pqrs");
        dictionary.add("tuv");
        dictionary.add("wxyz");
        result = helper(result, digits, dictionary);

        return result;
    }

    public static  List<String> helper(List<String> list, String digits, List<String> dictionary) {
        if (digits.length() > 0) {
            int target = Integer.parseInt("" + digits.charAt(0));
            String letters = dictionary.get(target);
            List<String> tempList = new ArrayList<>();;
            for (int i = 0; i < letters.length(); i ++) {
                if (list.size() == 0) {
                    tempList.add("" + letters.charAt(i));
                } else {
                    for (String s : list) {
                        tempList.add(s + letters.charAt(i));
                    }
                }
            }
            list = tempList;
            return helper(list, digits.substring(1), dictionary);
        } else {
            return list;
        }
    }
}
