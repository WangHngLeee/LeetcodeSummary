//370. Range Addition
https://leetcode.com/problems/range-addition/


// 按照start的位置顺序开始累加，在end+1位置减去加上的value，因为范围外相当于没加，对于范围内的来说就是减去。
// 最后从左到右累加sum并更新temp。

class Solution {
    public int[] getModifiedArray(int length, int[][] updates) {
        int[] temp = new int[length];
        for(int[] up : updates){
            int value = up[2];
            int start = up[0];
            int end = up[1];

            temp[start] += value;
            if(end < length - 1){
                temp[end + 1] -= value;
            }
        }
        int sum = 0;
        for(int i=0; i<temp.length; i++){
            sum += temp[i];
            temp[i] = sum;
        }
        return temp;
    }
}