/**
 * Created by markdaniel on 9/2/15.
 */
public class CountAndSay {
    public static void main(String[] args) {
        System.out.println(countAndSay(5));
    }

    public static String countAndSay(int n) {
        int index = 1;
        String curSet = "1";
        StringBuilder newSet = new StringBuilder();
        newSet.append(curSet);
        while (index < n) {
            newSet = new StringBuilder();
            for (int i = 0; i < curSet.length(); i++) {
                int countSame = 0;
                char targetChar = curSet.charAt(i);
                while (i < curSet.length() && curSet.charAt(i) == targetChar) {
                    countSame++;
                    i++;
                }
                if (i < curSet.length()) {
                    i--;
                }
                newSet.append("" + countSame + targetChar);
            }
            curSet = newSet.toString();
            index++;
        }
        return newSet.toString();
    }
}
