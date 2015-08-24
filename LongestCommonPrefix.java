/**
 * Created by markdaniel on 8/19/15.
 */
public class LongestCommonPrefix {
    public static void main(String[] args) {
        String[] strs = {"apple", "app", "apartheid"};
        System.out.println(longestCommonPrefix(strs));
    }
    public static String longestCommonPrefix(String[] strs) {
        if (strs == null) {
            return null;
        }
        if (strs.length == 0) {
            return "";
        }
        if (strs.length == 1) {
            return strs[0];
        }

        StringBuilder sb = new StringBuilder();
        int minStrLen = strs[0].length(), index = 0;
        boolean inPrefix = true;
        while (index < minStrLen && inPrefix) {
            if (strs[strs.length - 1].length() == 0) {
                return "";
            }
            char currentChar = strs[strs.length - 1].charAt(index);
            for (int i = strs.length - 1; i >= 0; i --) {
                if (strs[i].length() == 0) {
                    return "";
                }
                minStrLen = Math.min(minStrLen, strs[i].length());
                if (strs[i].charAt(index) != currentChar) {
                    inPrefix = false;
                }
            }
            if (inPrefix) {
                sb.append(currentChar);
            }
            index ++;
        }

        return sb.toString();
    }
}
