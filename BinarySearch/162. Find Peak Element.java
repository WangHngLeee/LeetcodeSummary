class Solution {
    public int findPeakElement(int[] nums) {
        if(nums == null || nums.length == 0)return -1;
        int left = 0;
        int right = nums.length -1;
        while(left + 1< right){
            int mid = left + (right - left)/2;
            if(nums[mid] < nums[mid + 1]){
                left = mid;
            }else{
                right = mid;
            }
        }
        if(nums[left]>nums[right])return left;
        else return right;
    }
}
//和852一样的思路。
//每次对mid和mid+1比较。更新左右边界即可。