class Solution {
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        List<List<Integer>> res = new ArrayList<>();
        List<Integer> list = new ArrayList<>();
        if(candidates == null || candidates.length == 0)return res;
        Arrays.sort(candidates);
        help(res,list,candidates,target,0);
        return res;
    }
    public void help(List<List<Integer>> res,List<Integer> list, int[] nums, int remain, int start){
        if(remain == 0)res.add(new ArrayList<>(list));
        else if(remain < 0)return;
        else{
            for(int i=start ;i<nums.length ;i++){
                if(i>start && nums[i] == nums[i-1] )continue;//如果有重复的，当i>start说明前面用过了，这个不能再用
                //因为前面的那个循环必定会用到当前的元素，不能重复使用。
                list.add(nums[i]);
                help(res,list,nums,remain - nums[i],i+1);// duplicate exist in nums and each number we can only use once.
                list.remove(list.size()-1);
            }
        }
    }
}
