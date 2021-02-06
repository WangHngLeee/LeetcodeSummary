//150. Evaluate Reverse Polish Notation
https://leetcode.com/problems/evaluate-reverse-polish-notation/

//后缀表达式的计算方法：
// 遍历整个表达式,如果为数字则入栈;
// 如果为符号则将前面两个数字出栈，先出栈的在右边后出栈的在左边符号放中间算出来结果再扔到栈中即可。

class Solution {
    public int evalRPN(String[] tokens) {
        Stack<Integer> stack = new Stack<>();
        for(String s : tokens){
            if(s.equals("*") || s.equals("+") || s.equals("/") || s.equals("-")){
                int second = stack.pop();
                int first = stack.pop();
                if(s.equals("*"))stack.push(first * second);
                if(s.equals("/"))stack.push(first / second);
                if(s.equals("+"))stack.push(first + second);
                if(s.equals("-"))stack.push(first - second);
            }else{
                stack.push(Integer.valueOf(s));
            }
        }
        return stack.peek();
    }
}

