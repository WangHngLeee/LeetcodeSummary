// 189. Rotate Array
https://leetcode.com/problems/rotate-array/

// 先整体reverse，再从0到k，最后剩下的reverse
class Solution{
    public void rotate(int[] nums, int k){
        k = k % nums.length;
        help(nums, 0, nums.length - 1);
        help(nums, 0, k - 1);
        help(nums, k, nums.length - 1);
    }
    private void help(int[] nums, int start, int end){
        while( start < end){
            int temp = nums[start];
            nums[start++] = nums[end];
            nums[end--] = temp;
        }
    }
}