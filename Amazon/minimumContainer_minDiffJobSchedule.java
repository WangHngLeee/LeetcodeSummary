package AmazonNG;
import java.util.*;

//https://leetcode.com/problems/minimum-difficulty-of-a-job-schedule/

public class minimumContainer_minDiffJobSchedule {
    public static int minContainerSize(List<Integer> itemSizes, int days) {
        // WRITE YOUR BRILLIANT CODE HERE

        int n = itemSizes.size();
        int maxd;
        if(n < days) return -1;
        int[] dp = new int[n + 1];
        for(int i = n - 1; i >= 0; i--) dp[i] = Math.max(dp[i+1], itemSizes.get(i)); for(int d = 2; d <= days; d++) {
            for (int i = 0; i <= n - d; i++) {
                maxd = 0;
                dp[i] = Integer.MAX_VALUE;
                for (int j = i; j <= n - d; j++) {
                    maxd = Math.max(maxd, itemSizes.get(j));
                    dp[i] = Math.min(dp[i], maxd + dp[j + 1]);
                }
            }
        }
        return dp[0];
    }
}
