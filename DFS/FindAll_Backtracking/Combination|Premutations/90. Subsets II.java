class Solution {
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        if(nums == null || nums.length == 0)return null;
        List<Integer> list = new ArrayList<>();
        Arrays.sort(nums);
        help(nums,res,list,0);
        return res;
    }
    public void help(int[] nums, List<List<Integer>> res, List<Integer> list, int pos){
        res.add(new ArrayList<>(list));
        for(int i = pos ; i< nums.length ; i++){
            if(i!= pos && nums[i] == nums[i-1])continue;
            list.add(nums[i]);
            help(nums,res,list,i+1);
            list.remove(list.size() -1 );
        }
    }
}
// 同样有duplicate的情况，所以要 加入这一行跳过 if(i!= pos && nums[i] == nums[i-1])continue;