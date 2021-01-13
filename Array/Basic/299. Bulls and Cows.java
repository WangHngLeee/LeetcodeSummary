//299. Bulls and Cows
https://leetcode.com/problems/bulls-and-cows/

class Solution {
    public String getHint(String secret, String guess) {
        if(secret == null || guess == null)return "";

        int cows = 0;
        int bulls = 0;
        int[] sr = new int[10];
        int[] gr = new int[10];

        for(int i=0; i< secret.length(); i++){
            if(guess.charAt(i) == secret.charAt(i)){
                bulls++;
            }else{
                sr[secret.charAt(i) -'0']++;
                gr[guess.charAt(i) -'0']++;
            }
        }

        for(int i=0; i<= 9; i++){
            cows += Math.min(sr[i], gr[i]);
        }

        return "" + bulls + "A" + cows + "B";
    }
}
