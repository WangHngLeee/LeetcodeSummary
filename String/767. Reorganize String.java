/*
Example 1:

Input: S = "aab"
Output: "aba"
Example 2:

Input: S = "aaab"
Output: ""
 */
class Solution {
    public String reorganizeString(String S) {
        int[] arr = new int[26];
        for(int i = 0 ; i < S.length() ;i++){
            arr[S.charAt(i)-'a']++;
        }
        int max = 0, letter = 0;
        for(int i = 0;i<arr.length;i++){
            if(arr[i]>max){
                max = arr[i];
                letter = i;
            }
        }
        if(max > (S.length() + 1)/2)return "";
        char[] res = new char[S.length()];
        int index = 0;
        while(arr[letter] > 0){
            res[index] = (char)(letter +'a');
            index+=2;
            arr[letter]--;
        }
        for(int i = 0; i<arr.length ;i++){
            while(arr[i]>0){
                if(index >= S.length()){
                    index = 1;
                }
                res[index] = (char)(i + 'a');
                index+=2;
                arr[i]--;
            }
        }
        return String.valueOf(res);
    }
}
/*


T:O(n) S:O(1)

Easy thoughts: We first find the char with max currency and put it on the even positin first like 0,2,4,6... Then we keep to put all other chars in the remained position.

If we get the end of the size of string, we turn back to the position of 1 and keep put char in it.
It easy to understand with the following explain.

        a _ a _ a _ _ _ _ // fill in "a" at position 0, 2, 4
        a b a _ a _ b _ b // fill in "b" at position 6, 8, 1
        a b a c a _ b _ b // fill in "c" at position 3
        a b a c a d b d b // fill in "d" at position 5, 7
 */