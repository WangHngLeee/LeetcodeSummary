class Solution {
    public boolean canPartitionKSubsets(int[] nums, int k) {
        int sum = 0;
        for(int num : nums){
            sum+=num;
        }
        if(sum%k != 0 || k<0)return false;
        boolean[] seen = new boolean[nums.length];
        return check(nums,seen,0,k,0,sum/k);
    }
    public boolean check(int[] nums, boolean[] seen, int start, int k, int cursum, int target){
        if(k == 1)return true;
        if(cursum == target)return check(nums,seen,0,k-1,0,target);
        for(int i= start; i< nums.length; i++){
            if(!seen[i]){
                seen[i] = true;
                if(check(nums,seen,i+1,k,cursum+nums[i],target))return true;
                seen[i] = false;
            }
        }
        return false;
    }
}
//dfs。k个sum相同的substet，即每个的sum都为nums的和/k。递归寻找
// 如果当前cursum等于目标值target，返回上一层递归，找剩下的k-1个。否则对每个没遇到的数进行dfs+backtracking，之后把该数变为未见过。