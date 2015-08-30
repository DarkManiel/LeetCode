import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * Created by markdaniel on 8/28/15.
 */
public class Isomorphic {
    public static void main(String[] args) {
        String s = "ab";
        String t = "aa";
        System.out.println(isIsomorphic(s, t));
    }

    public static boolean isIsomorphic(String s, String t) {
        Set<Character> mapped = new HashSet<>();
        Map<Character, Character> map = new HashMap<>();
        for (int i = 0; i < s.length(); i ++) {
            char sChar = s.charAt(i);
            char tChar = t.charAt(i);

            if (map.containsKey(sChar)) {
                if (map.get(sChar) != tChar) {
                    return false;
                }
            } else if (mapped.contains(tChar)) {
                return  false;
            } else {
                    map.put(sChar, tChar);
                    mapped.add(tChar);
            }
        }
        return true;
    }
}
