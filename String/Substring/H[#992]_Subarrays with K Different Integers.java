//992. Subarrays with K Different Integers
https://leetcode.com/problems/subarrays-with-k-different-integers/

// combined solution with At most K distinct chars
// Exactly_Distinct(K) = Atmost(k) - Atmost(k-1)
// So we can just regard array as a string and apply with the template of substring.

class Solution {
    public int subarraysWithKDistinct(int[] A, int K) {
        return help(A,K) - help(A,K-1);
    }
    public int help(int[] A, int K){
        if(A == null || A.length == 0)return 0;
        int[] map = new int[20001];

        int left = 0, right = 0, res = 0, count = 0;

        while(right < A.length){
            if(map[A[right]]++ == 0)count++;
            right++;

            while(count > K){
                if(map[A[left]]-- == 1)count--;
                left++;
            }
            res += right - left;
        }
        return res;
    }
}



