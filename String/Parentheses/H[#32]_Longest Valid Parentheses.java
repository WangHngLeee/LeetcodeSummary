//32. Longest Valid Parentheses
https://leetcode.com/problems/longest-valid-parentheses/description/


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
                dp[i] = dp[i-1]+2; // 一次加2， pair ->（）
                if(i-dp[i] > 0){ // 将当前valid的长度减去，如果在那之前还有valid的，那么继续加上。
                    dp[i]+=dp[i-dp[i]];
                }
                open--;
            }
            max = Math.max(dp[i],max);
        }
        return max;
    }
}
