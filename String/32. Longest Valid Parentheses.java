/*
Input: "(()"
Output: 2
Explanation: The longest valid parentheses substring is "()"

Input: ")()())"
Output: 4
Explanation: The longest valid parentheses substring is "()()"


 */



class Solution {
    public int longestValidParentheses(String s) {
        if(s == null || s.length() == 0)return 0;
        int len = s.length();
        int[] dp = new int[len];
        int open = 0;
        int max = Integer.MIN_VALUE;
        for(int i = 0; i<len ;i++){
            if(s.charAt(i) == '(')open++;
            else if(open >0 && s.charAt(i)==')'){
                dp[i] = dp[i-1]+2;
                if(i-dp[i] > 0){
                    dp[i]+=dp[i-dp[i]];
                }
                open--;
            }
            max = Math.max(dp[i],max);
        }
        return max;
    }
}

/*
        DP problem. When we meet ')' and open >0 then we start dp operation.

        Tricky point is the line in the bellow:

        if(i-dp[i] > 0){
            dp[i]+=dp[i-dp[i]];
        }

        We are looking for the longest continuous parentheses, so we have to check the dp value before the current valid length.

        For example:

        ()()() // case 1
        ((())) // case 2

        In case 1, only we meet ) then we can make current dp to 2, but after that we will back to the value of 0. So we have to check whether there is valid length before the current length.

        In case 2 it is normal way what we think in the first time.

 */