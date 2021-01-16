class Solution {
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> res = new ArrayList<>();
        List<Integer> list = new ArrayList<>();
        if(candidates == null || candidates.length == 0)return res;
        help(res,list,candidates,target,0);
        return res;
    }
    public void help(List<List<Integer>> res,List<Integer> list, int[] nums, int remain, int start){
        if(remain == 0)res.add(new ArrayList<>(list));
        else if(remain < 0)return;
        else{
            for(int i=start ;i<nums.length ;i++){
                list.add(nums[i]);
                help(res,list,nums,remain - nums[i],i);// no dupicate in nums so we can reuse the same number
                list.remove(list.size()-1);
            }
        }
    }
}
// 经典conbinaton模版。注意由于没有重复所以可以重复使用一个数字。

