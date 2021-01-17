//76. Minimum Window Substring
https://leetcode.com/problems/minimum-window-substring/

// using substring template

class Solution{
    public String minWindow(String s, String t) {
        int[] map = new int[128];
        for(char c : t.toCharArray())map[c]++; // 初始化目标map
        int left = 0, right = 0, start = 0, minlen = Integer.MAX_VALUE, count = t.length();
        while(right < s.length()){
            if(map[s.charAt(right)] > 0){
                count--; // 找到t中到char，count--
            }
            map[s.charAt(right)]--; // remove once target char from map
            right++; // move right
            while(count == 0){ // if current substring(left, right) is valid

                // update minlen and start point
                if(minlen > right - left){
                    minlen = right - left;
                    start = left;
                }
                // add from left to make the substring invalid again
                map[s.charAt(left)]++;
                if(map[s.charAt(left)] > 0)count++;
                left++;
            }
        }
        return minlen == Integer.MAX_VALUE ? "" : s.substring(start, start + minlen);
    }
}