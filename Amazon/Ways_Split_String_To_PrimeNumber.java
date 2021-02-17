package AmazonNG;
import java.util.*;
public class Ways_Split_String_To_PrimeNumber {

    public static int countPrimeString_I(String str) {
        boolean[] isPrime = isValidPrime(1000);
        int n = str.length();
        int mod = (int) 1e9 + 7;
        int[] dp = new int[n + 1];
        dp[0] = 1;
        for (int i = 1; i <= n; i++) {
            for (int j = Math.max(0, i - 3); j < i; j++) {
                String temp = str.substring(j, i);
                if (isPrime[Integer.parseInt(temp)] && !temp.startsWith("0")) {
                    dp[i] += dp[j];
                    dp[i] %= mod;
                }
            }
        }
        return dp[n];
    }
    private static boolean[] isValidPrime(int n) {
        boolean[] isPrime = new boolean[n + 1];
        Arrays.fill(isPrime, true);
        isPrime[0] = isPrime[1] = false;

        for (int i = 2; i <= n; i++) {
            if (isPrime[i]) {
                for (int j = i; i * j <= n; j++) {
                    isPrime[i * j] = false;
                }
            }
        }
        return isPrime;
    }

//  SOludion 2

    public static int countPrimeString_II(String str) {
        int mod = (int)1e9 + 7;
        int n = Integer.parseInt(str);
        boolean[] arr = new boolean[(int)1e6 + 1];
        Arrays.fill(arr, true);
        for(int i=2; i*i < (int)1e6; i++){
            if(arr[i]){
                for(int j = i; j*i <=n; j++){
                    arr[i*j] = false;
                }
            }
        }
        arr[1] = false;
        arr[0] = false;
        int[] dp = new int[str.length() + 1];
        dp[0] = 1;
        for(int i=1; i<= str.length(); i++){
            for(int j = Math.max(0,i-6); j<i; j++){
                if(arr[Integer.parseInt(str.substring(j,i))]){
                    dp[i] = (dp[i] + dp[j]) % mod;
                }
            }
        }
        return dp[str.length()];
    }
}
