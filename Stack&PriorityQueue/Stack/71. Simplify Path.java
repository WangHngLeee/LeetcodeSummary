//71. Simplify Path
https://leetcode.com/problems/simplify-path/

class Solution {
    public String simplifyPath(String path) {
        Stack<String> stack = new Stack<>();
        Set<String> skip = new HashSet<>(Arrays.asList("..",".",""));
        String[] strs = path.split("/");
        for(String str : strs){
            if(str.equals("..") && !stack.isEmpty())stack.pop();
            else if(!skip.contains(str))stack.push(str);
        }
        String res = "";
        while(!stack.isEmpty()){
            res = "/" + stack.pop() + res;
        }
        return res.length() == 0 ? "/" : res;
    }
}