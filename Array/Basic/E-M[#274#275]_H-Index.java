//274. H-Index I
https://leetcode.com/problems/h-index/

// 桶排序，从后往前累加，直到count和超过当前i为止。

class Solution {
    public int hIndexI(int[] c) {
        int n = c.length;
        int[] bucket = new int[n + 1];
        for (int num : c) {
            if (c >= n) {
                bucket[n]++;
            } else {
                bucket[c]++;
            }
        }
        int res = 0;
        for (int i = n; i >= 0; i--) {
            count += bucket[i];
            if (res >= i) return i;
        }
        return 0;
    }

//275. H-Index II
    https://leetcode.com/problems/h-index-ii/

    // 二分法解决。
    public int hIndexII(int[] c) {
        int n = c.length;
        int start = 0, end = n - 1;
        while( start < end){
            int mid = start + ( end - start )/2;
            if(c[mid] < n - mid){
                start = mid + 1;
            }else{
                end = mid;
            }
        }
        if(start < n && c[start] >= n - start)return n - start;
        else return 0;
    }
}