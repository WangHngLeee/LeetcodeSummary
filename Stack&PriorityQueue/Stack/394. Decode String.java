//394. Decode String
https://leetcode.com/problems/decode-string/

// Two Stack
class Solution {
    Stack<Integer> count;
    Stack<StringBuilder> strs;
    public String decodeString(String s) {
        if(s == null || s.length() == 0)return "";
        count = new Stack<>();
        strs = new  Stack<>();
        StringBuilder sb = new StringBuilder();
        int num = 0;
        for(char c : s.toCharArray()){
            if(Character.isDigit(c)){
                num = num*10 + c - '0';
            }else if(c == '['){
                count.push(num);
                strs.push(sb);
                num = 0;
                sb = new StringBuilder();
            }else if(c ==']'){
                StringBuilder prev = strs.pop();
                int total = count.pop();
                for(int i=0; i<total; i++){
                    prev.append(sb);
                }
                sb = prev;
            }else{
                sb.append(c);
            }
        }
        return sb.toString();
    }
}
