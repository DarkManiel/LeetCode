/**
 * Created by markdaniel on 8/17/15.
 */
public class RegexMatching {
    public static void main(String[] args) {
        System.out.println(isMatch("aaa", "a*a"));
    }

    public static boolean isMatch(String s, String p) {
        if (p.length() < s.length()) {
            return false;
        }
        if (s.length() == 0) {
            return p.length() == 0 || p.charAt(0) == '*';
        }
        if (s.length() == 1) {
            return p.charAt(0) == '*' || p.charAt(0) == '.' || p.charAt(0) == s.charAt(0);
        }
        int sTarget = 0;
        int pLag = 0, pLead = 1;
        while (sTarget < s.length()) {
            char sTargetChar = s.charAt(sTarget);
            char pLeadChar;
            if (pLead >= p.length()) {
                pLeadChar = ' ';
            } else {
                pLeadChar = p.charAt(pLead);
            }
            if (pLag >= p.length()) {
                return false;
            }
            char pLagChar = p.charAt(pLag);
            if (pLeadChar == '*') {
                if (pLagChar == '.') {
                    while (sTarget < s.length()) {
                        if (isMatch(s.substring(sTarget, s.length()), p.substring(2, p.length()))) {
                            return true;
                        }
                        sTarget++;
                    }
                } else {
                    while (sTarget < s.length() && s.charAt(sTarget) == pLagChar) {
                        sTarget++;
                    }
                }
                pLag = pLead + 1;
                pLead = pLead + 2;

            } else if (pLagChar == '.') {
                pLag++;
                pLead++;
                sTarget++;
            } else {
                if (pLagChar != sTargetChar) {
                    return false;
                }
                pLag++;
                pLead++;
                sTarget++;
            }
        }
        if (sTarget < s.length() || pLag < p.length()) {
            return false;
        }
        return true;
    }
}
