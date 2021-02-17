package AmazonNG;

import java.util.*;

public class DistinctK_Substring {
    public static int subKstring(String A,  int k) {
        return help(A,k) - help(A,k-1);
    }
    public static int help(String A, int K){

        if(A == null || A.length() == 0)return 0;
        Map<Character, Integer> map = new HashMap<>();
        int left = 0, right = 0, res = 0, count = 0;
        char[] chars = A.toCharArray();

        while(right < A.length()){
            map.put(chars[right], map.getOrDefault(chars[right], 0) + 1);
            if(map.get(chars[right]) == 1)count++;
            right++;
            while(count > K){
                map.put(chars[left], map.getOrDefault(chars[left],0) - 1);
                if(map.get(chars[left]) == 0)count--;
                left++;
            }
            res += right - left + 1;
        }
        return res;
    }

    public static void main(String[] args){
        System.out.println(subKstring("pqpqs", 2));
    }
}
