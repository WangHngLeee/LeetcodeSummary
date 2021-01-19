//115. Distinct Subsequences
https://leetcode.com/problems/distinct-subsequences/

//        array mem where mem[i+1][j+1] means that S[0..j] contains T[0..i] that many times as distinct subsequences. Therefor the result will be mem[T.length()][S.length()].
//        we can build this array rows-by-rows:
//        the first row must be filled with 1. That's because the empty string is a subsequence of any string but only 1 time. So mem[0][j] = 1 for every j. So with this we not only make our lives easier, but we also return correct value if T is an empty string.
//        the first column of every rows except the first must be 0. This is because an empty string cannot contain a non-empty string as a substring



//From here we can easily fill the whole grid: for each (x, y), we check if S[x] == T[y] we add the previous item and the previous item in the previous row, otherwise we copy the previous item in the same row. The reason is simple:

//1. if the current character in S doesn't equal to current character T, then we have the same number of distinct subsequences as we had without the new character.
//2. if the current character in S equal to the current character T, then the distinct number of subsequences: the number we had before plus the distinct number of subsequences we had with less longer T and less longer S.

class Solution {
    public int numDistinct(String s, String t) {
        int[][] mem = new int[t.length()+1][s.length()+1];
        for(int i=0;i<=s.length();i++){
            mem[0][i]=1;
        }
        for(int i=0;i<t.length();i++){
            for(int j=0;j<s.length();j++){
                if(t.charAt(i)==s.charAt(j)){
                    mem[i+1][j+1] = mem[i][j]+mem[i+1][j]; // left and top left item
                }else{
                    mem[i+1][j+1] = mem[i+1][j]; // just left item
                }
            }
        }
        return mem[t.length()][s.length()];
    }
}
