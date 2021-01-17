//159. Longest Substring with At Most Two Distinct Characters
https://leetcode.com/problems/longest-substring-with-at-most-two-distinct-characters/

// using template

class Solution {
    public int lengthOfLongestSubstringTwoDistinct(String s) {
        if(s == null || s.length() == 0)return 0;
        int[] map = new int[128];

        int left = 0, right = 0, maxlen = Integer.MIN_VALUE, count = 0;

        while(right < s.length()){
            if(map[s.charAt(right)]++ == 0)count++;
            right++;

            while(count > 2){
                if(map[s.charAt(left)]-- == 1)count--;
                left++;
            }
            maxlen = Math.max(maxlen, right - left);
        }
        return maxlen;
    }
}


//340. Longest Substring with At Most K Distinct Characters
https://leetcode.com/problems/longest-substring-with-at-most-k-distinct-characters/description/

// same with 159, just change 2 to k.

class Solution {
    public int lengthOfLongestSubstringKDistinct(String s, int k) {
        if(s == null || s.length() == 0)return 0;
        int[] map = new int[128];
        int left = 0, right = 0, maxlen = Integer.MIN_VALUE, count = 0;
        while( right < s.length() ){
            if(map[s.charAt(right)]++ == 0)count++;
            right++;

            while(count > k){
                if(map[s.charAt(left)]-- == 1)count--;
                left++;
            }
            maxlen = Math.max(maxlen, right - left);
        }
        return maxlen;
    }

}