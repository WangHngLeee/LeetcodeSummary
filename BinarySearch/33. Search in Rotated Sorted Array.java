class Solution {
    public int search(int[] nums, int target) {
        if(nums == null || nums.length == 0)return -1;
        int len = nums.length;
        int left = 0;
        int right = len-1;
        while(left+1 < right){
            int mid = left + (right - left)/2;
            if(nums[mid] >= nums[left]){
                if(target <= nums[mid] && target>= nums[left]){
                    right = mid;
                }else{
                    left = mid;
                }
            }else{
                if(nums[mid] < target && target <= nums[right]){
                    left = mid;
                }else{
                    right = mid;
                }
            }
            if (nums[mid] == target) return mid;
        }
        if(nums[left] == target)return left;
        else if (nums[right] == target) return right;
        else return -1;
    }
}
//二分新模版注意最后要判断left和right。