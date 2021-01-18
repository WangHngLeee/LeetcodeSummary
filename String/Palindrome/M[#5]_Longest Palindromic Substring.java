//5. Longest Palindromic Substring
https://leetcode.com/problems/longest-palindromic-substring/

// 检查 (i,i) (i,i+1) 两种情况 --->   1. aba 2. abba
class Solution {
    int start, max;
    public String longestPalindrome(String s) {
        if(s == null || s.length() == 0)return "";
        for(int i=0; i<s.length(); i++){
            check(s,i,i);
            check(s,i,i+1);
        }
        return s.substring(start,start + max);
    }

    private void check(String s, int left, int right){
        while( left >= 0 && right < s.length() && s.charAt(left) == s.charAt(right)){
            left--;
            right++;
        }
        if(right - left > max){
            max = right - left - 1;
            start = left + 1;
        }
    }
}