class Solution {

    //224. Basic Calculator
    https://leetcode.com/problems/basic-calculator/

    public int calculateI(String s) {
        int len = s.length();
        int sign = 1;
        Stack<Integer> stack = new Stack<>();
        int res = 0;
        for(int i=0; i<len; i++){
            if(Character.isDigit(s.charAt(i))){
                int sum = s.charAt(i) - '0';
                while(i+1 < len && Character.isDigit(s.charAt(i+1))){
                    sum = sum * 10 + s.charAt(i+1) - '0';
                    i++;
                }
                res = res + sum * sign;
            }
            else if(s.charAt(i) == '-')sign = -1;
            else if(s.charAt(i) == '+')sign = 1;
            else if(s.charAt(i) == '('){
                stack.push(res);
                stack.push(sign);
                res = 0;
                sign = 1;
            }
            else if(s.charAt(i) == ')'){
                res = res * stack.pop() + stack.pop();
            }
        }
        return res;
    }


    //227. Basic Calculator II
    https://leetcode.com/problems/basic-calculator-ii/
    public int caculateII(String s){
        if(s==null || s.length() ==0) return 0;
        int len = s.length();
        Stack<Integer> stack = new Stack<Integer>();
        int num = 0, res = 0;
        char sign = '+';
        for(int i=0;i<len;i++){
            char c = s.charAt(i);
            if(Character.isDigit(c)){
                num = num * 10 + c-'0';
            }
            if((!Character.isDigit(c) &&' '!=c) || i==len-1){
                if(sign=='-')stack.push(-num);
                if(sign=='+')stack.push(num);
                if(sign=='*')stack.push(stack.pop()*num);
                if(sign=='/')stack.push(stack.pop()/num);
                sign = s.charAt(i);
                num = 0;
            }
        }
        for(int i:stack){
            res += i;
        }
        return res;
    }
}

