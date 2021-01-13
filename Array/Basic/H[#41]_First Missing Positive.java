//41. First Missing Positive
https://leetcode.com/problems/first-missing-positive/description/


//1. brute force with extra space

class Solution {
    public int firstMissingPositive(int[] nums) {
        Set<Integer> s = new HashSet<Integer>();
        for(int num :nums){
            if( num >=0 && !s.contains(num))
                s.add(num);
        }
        for(int i=1;i<=s.size();i++){
            if(!s.contains(i)){
                return i;
            }
        }
        return s.size()+1;
    }
}


//2. constant space

// TODO: 1/12/21