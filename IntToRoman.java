/**
 * Created by markdaniel on 8/19/15.
 */
public class IntToRoman {
    public static void main(String[] args) {
        System.out.printf(intToRoman(19));
    }
    public static String intToRoman(int num) {
        StringBuilder sb = new StringBuilder();

        if (num >= 1000) {
            for (int i = 0; i < num / 1000; i ++ ){
                    sb.append("M");
            }
            num = num % 1000;
        }
        if (num >= 900 && num < 1000) {
            sb.append("CM");
            num %= 900;
        }
        if (num >= 400 && num < 500) {
            sb.append("CD");
            num %= 400;
        }
        if (num >= 500) {
            sb.append("D");
            num %= 500;
        }
        if (num >= 100) {
            for (int j = 0; j < num / 100; j ++ ) {
                sb.append("C");
            }
            num %= 100;
        }
        if (num >= 90 && num < 100) {
            sb.append("XC");
            num %= 90;
        }
        if (num >=40 && num < 50) {
            sb.append("XL");
            num %= 40;
        }
        if (num >= 50){
            sb.append("L");
            num %= 50;
        }
        if (num >= 10) {
            for (int k= 0; k <num / 10; k ++) {
                sb.append("X");
            }
            num %= 10;
        }
        if (num == 9) {
            sb.append("IX");
            num %= 9;
        }
        if (num >= 5) {
            sb.append("V");
            num %= 5;
        }
        if (num >= 1 && num == 4) {
            sb.append("IV");
        } else {
            for (int l = 0; l < num; l ++) {
                sb.append("I");
            }
        }
        return sb.toString();
    }
}
