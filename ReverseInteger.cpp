#include<iostream>
using namespace std;

class Solution {
public:
    int reverse(int x) {

        int multiplier = 10;
        int operand = x;
        int result = 0;
        while(operand != 0) {
            result *= 10;
            result += (operand % multiplier);
            operand = (operand / multiplier);
        }
        return result;
    }
};

int main()
    {
        Solution s;

        cout << "res is " << s.reverse(1534236469);
        return 0;
    }