class Solution {
    Map<String, String> map = new HashMap<String, String>() {{
        put("2", "abc");
        put("3", "def");
        put("4", "ghi");
        put("5", "jkl");
        put("6", "mno");
        put("7", "pqrs");
        put("8", "tuv");
        put("9", "wxyz");
    }};
    public List<String> letterCombinations(String digits) {
        List<String> res = new ArrayList<>();
        if(digits == null || digits.length() == 0)return res;
        help("",digits,res);
        return res;
    }
    public void help(String cur, String digits, List<String> res){
        if(digits.length() == 0)res.add(cur);
        else{
            String digit = digits.substring(0,1);
            String letters = map.get(digit);
            for(int i = 0 ; i < letters.length() ;i++){
                String ch = map.get(digit).substring(i,i+1);
                help(cur + ch, digits.substring(1),res);
            }
        }
    }
}
// 根据不同数字取到不同chars，然后递归找所有的情况，加入res。