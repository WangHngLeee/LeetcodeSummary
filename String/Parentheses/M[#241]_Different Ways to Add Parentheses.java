//241. Different Ways to Add Parentheses
https://leetcode.com/problems/different-ways-to-add-parentheses/

// recursively compute each part and multiply them seperately to get all possible res.
class Solution {
    public List<Integer> diffWaysToCompute(String input) {
        List<Integer> res = new ArrayList<>();
        if(input == null || input.length() == 0)return res;

        Map<String, List<Integer>> map = new HashMap<>();

        for(int i=0 ;i<input.length();i++){
            char c = input.charAt(i);
            if(c == '+' || c== '-' || c=='*'){
                String part1 = input.substring(0,i);
                String part2 = input.substring(i+1);

                List<Integer> list1 = map.getOrDefault(part1,diffWaysToCompute(part1));
                List<Integer> list2 = map.getOrDefault(part2,diffWaysToCompute(part2));

                for(int num1 : list1){
                    for(int num2 : list2){
                        int cursum = 0;
                        switch(c){
                            case '+':
                                cursum = num1 + num2;
                                break;
                            case '-':
                                cursum = num1 - num2;
                                break;
                            case '*':
                                cursum = num1 * num2;
                                break;
                        }
                        res.add(cursum);
                    }
                }

            }
        }
        if(res.size() == 0)res.add(Integer.valueOf(input));
        map.put(input,res);
        return res;
    }
}
