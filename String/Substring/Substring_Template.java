import java.util.*;

class Solution {
    public int findSubstring(string s) {
        int[] map = new int[128];
        /* initialize the hash map here */
        for (char c : s.toCharArray()) {
            map[c]++;
        }

        int count = map.size(); // check whether the substring is valid
        int begin = 0, end = 0; //two pointers, one point to tail and one  head
        int len = Integer.MAX_VALUE; //the length of substring

        while (end < s.length()) {
            if (map[s.charAt(end)] ?) {
                /* modify counter here */
            }
            map[s.charAt(end)]--;
            end++;

            while (count == 0) { /* When we found a valid window, move start to find smaller window.*/

                /* update d here if finding minimum*/
                if(len > end - start){
                    .......
                }

                //increase begin to make it invalid/valid again
                map[s.charAt(start)]++;

                if (map[s.charAt(begin)] ?) {
                    /*modify counter here*/
                }
                begin++;
            }
            /* update d here if finding maximum*/
        }
        return len;
    }
}