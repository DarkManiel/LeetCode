#include<iostream>
#include<cstring>
#include <vector>

using namespace std;

class Solution {
    public:
        string convert(string s, int numRows) {
            std::vector<string> rows(numRows);
            string solution = "";
            if(numRows == 1 || numRows > s.length()) {
                        return s;
                    }
            int cur = 0;
            int down = 1;
            for (int i = 0; i < s.length(); i ++) {
                rows[cur] += s[i];
                if (cur == numRows - 1) {
                    down = 0;
                } else if (cur == 0) {
                    down = 1;
                }
                if (down == 1) {
                    cur ++;
                } else {
                    cur --;
                }
            }
            for (int i = 0; i < numRows; i ++) {
                solution += rows[i];
            }
            return solution;
        }
    };

/*Main */
    int main()
    {
        Solution s;

        string str = "PAYPALISHIRING";
        cout << "res is " << s.convert(str, 3);
        return 0;
    }


