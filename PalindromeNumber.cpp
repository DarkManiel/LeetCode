class Solution {
public:
    bool isPalindrome(int x) {
        if (x < 0) {
            return false;
        }

        int number = x, multiplier = 10, reverse = 0;
        while (number != 0) {
            int remainder = number % multiplier;
            reverse = (reverse * multiplier + remainder);
            number /= multiplier;
        }

        if (reverse == x) {
            return true;
        }
        return false;
    }
};