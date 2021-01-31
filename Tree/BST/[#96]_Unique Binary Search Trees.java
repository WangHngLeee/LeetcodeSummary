//96. Unique Binary Search Trees
https://leetcode.com/problems/unique-binary-search-trees/


// 解释可以看博客 ：
https://leeemask.com/2020/06/11/tree02/#table-tr-td-bgcolor-F5B041-font-color-white-96-Unique-Binary-Search-Trees-font-td-tr-table

class Solution {
    public int numTrees(int n) {
        int[] dp = new int[n+1];
        dp[0] = dp[1] = 1;
        for(int i = 2; i <=n;i++){
            for(int j = 1 ; j<=i ; j ++){
                dp[i] += dp[j-1]*dp[i-j];
            }
        }
        return dp[n];
    }
}