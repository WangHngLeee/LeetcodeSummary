class Solution {
    public boolean search(int[] nums, int target) {
        if(nums == null || nums.length == 0)return false;
        int len = nums.length;
        int left = 0;
        int right = len-1;
        while(left+1 < right){
            int mid = left + (right - left)/2;
            if (nums[mid] == target) return true;
            else if(nums[mid] > nums[left]){
                if(target <= nums[mid] && target>= nums[left]){
                    right = mid;
                }else{
                    left = mid;
                }
            }else if(nums[left]==nums[mid]){
                left++;
            }
            else if(nums[right] == nums[mid]){
                right--;
            }else{
                if(nums[mid] < target && target <= nums[right]){
                    left = mid;
                }else{
                    right = mid;
                }
            }
        }
        if(nums[left] == target)return true;
        else if (nums[right] == target) return true;
        else return false;
    }
}
// 和33 类似，只不过多了duplicate的情况
//多了重复的数字，要检查mid和left right。其他不变。

