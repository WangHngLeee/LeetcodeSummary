package AmazonNG;
import java.util.*;

public class TwoSumUniquePairs {
    public static int twoSumUniquePairs(List<Integer> nums, int target) {
        Set<Integer> set = new HashSet<Integer>();
        Set<Integer> seen = new HashSet<Integer>();
        int count = 0;

        for(int num : nums){
            if(set.contains(target-num) && !seen.contains(num)){
                count++;
                seen.add(target-num);
                seen.add(num);
            }
            else set.add(num);
        }
        return count;
    }
}
