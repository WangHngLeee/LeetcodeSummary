class Solution {
    public int findMin(int[] nums) {
        int left = 0;
        int right = nums.length -1;
        while(left + 1 < right){
            int mid = left + (right - left)/2;
            if(nums[mid] < nums[right]){
                right = mid;
            }else if (nums[mid] > nums[right]){
                left = mid;
            }else{
                right--;
            }
        }
        if(nums[left] < nums[right])return nums[left];
        else return nums[right];
    }
}
// 和153不同之处在于要更新right边界，因为有重复存在。