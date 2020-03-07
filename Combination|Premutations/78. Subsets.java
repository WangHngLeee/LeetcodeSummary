class Solution {
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        List<Integer> list = new ArrayList<>();
        if(nums == null || nums.length == 0)return res;
        Arrays.sort(nums);
        help(nums,res,list,0);
        return res;
    }
    public void help(int[] nums, List<List<Integer>> res, List<Integer> list, int pos){
        res.add(new ArrayList<>(list));
        for(int i= pos ;i<nums.length;i++){
            list.add(nums[i]);
            help(nums,res,list,i+1);
            list.remove(list.size()-1);
        }
    }
}