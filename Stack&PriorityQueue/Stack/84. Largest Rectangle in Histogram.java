//84. Largest Rectangle in Histogram

https://leetcode.com/problems/largest-rectangle-in-histogram/


// 这个题的核心是要保持一个单调递增的stack，每次遇到比栈顶小的元素，pop掉最高的元素
//     此时最高的元素是局部最大的height，这里就需要利用当前i的index减去栈顶前一个元素的坐标
//     这样可以得到这个局部的width是多少。这样height*width就是局部最大的面积。

//     如果当前的i仍然大于栈顶元素，继续进行pop，这样得到下一个局部最大值

//     最后stack剩下的height index，就是全局下最小的index，因为比他们大的，都被pop掉了
//     所以直接pop stack，width就是总的len 减去他的index即可
//     class Solution {
    public int largestRectangleArea(int[] heights) {
        if(heights == null || heights.length == 0)return 0;
        Stack<Integer> stack = new Stack<>();
        int len = heights.length;
        int max = Integer.MIN_VALUE;

        for(int i=0; i<len; i++){
            while(!stack.isEmpty() && heights[i] < heights[stack.peek()] ){
                int temparea = heights[stack.pop()] * ( i - ( stack.isEmpty() ? 0 : stack.peek() + 1));
                max = Math.max(max, temparea);
            }
            stack.push(i);
        }
        //
        while(!stack.isEmpty()){
            int temparea = heights[stack.pop()] * ( len - (stack.isEmpty() ? 0 : stack.peek() + 1));
            max = Math.max(max, temparea);
        }
        return max;
    }
}
