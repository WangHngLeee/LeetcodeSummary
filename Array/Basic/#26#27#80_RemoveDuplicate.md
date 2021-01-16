## 27. Remove Element from Sorted Array

https://leetcode.com/problems/remove-element/

scan the whole array, if any num not equal to val, move that one to the new array. Finally return the last index( laength of array).

```java
class Solution {
    public int removeElement(int[] nums, int val) {
        int len = 0;
        for(int i=0; i<nums.length; i++){
            if(nums[i] != val){
                nums[len++] = nums[i];
            }
        }
        return len;
    }
}
```


## 26. Remove Duplicates from Sorted Array

https://leetcode.com/problems/remove-duplicates-from-sorted-array/description/

We only keep onece element in the final array, so we need to check current num and nums[len-1], which is the previous one.

```java
class Solution {
    public int removeDuplicatesI(int[] nums) {
        int len = 0;
        for(int num : nums){
            if( len == 0 || num != nums[ len - 1]){
                nums[len++] = num;
            }
        }
        return len;
    }
}
```


## 80. Remove Duplicates from Sorted Array II

https://leetcode.com/problems/remove-duplicates-from-sorted-array-ii/description/

Different between 26 is that : in 80, we can have at most two same element, so we only need to check `num` and `nums[len-2]`

```java
class Solution {
    public int removeDuplicatesII(int[] nums) {
        int len = 0;
        for(int num : nums){
            if(len < 2 || num != nums[len - 2]){ // difference : nums[len-2] in 80 and nums[len-1] in 26
                nums[len++] = num;
            }
        }
        return len;
    }
}
```