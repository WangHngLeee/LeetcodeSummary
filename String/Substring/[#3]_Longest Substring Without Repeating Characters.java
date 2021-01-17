//3. Longest Substring Without Repeating Characters
https://leetcode.com/problems/longest-substring-without-repeating-characters/

// 暴力： set + sliding window

class Solution {
    public int lengthOfLongestSubstring(String s) {
        Set<Character> set = new HashSet<>();
        int i=0;
        int j=0;
        int max = 0;
        while(i < s.length()){
            if(!set.contains(s.charAt(i))){
                set.add(s.charAt(i));
                max = Math.max(max, set.size());
                i++;
            }else{
                set.remove(s.charAt(j));
                j++;
            }
        }
        return max;
    }
}

// using substring template

class Solution {
    public int lengthOfLongestSubstring(String s) {
        if(s == null || s.length() == 0)return 0;
        int left = 0, right = 0, maxlen = Integer.MIN_VALUE, count = 0;
        int[] map = new int[128];
        while (right < s.length()){
            if(map[s.charAt(right)] > 0)count++;
            map[s.charAt(right)]++;
            right++;
            while(count > 0){
                if(map[s.charAt(left)] > 1)count--;
                map[s.charAt(left)]--;
                left++;
            }
            maxlen = Math.max(maxlen, right - left);
        }
        return maxlen;
    }
}