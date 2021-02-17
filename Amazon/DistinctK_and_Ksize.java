package AmazonNG;
import java.util.*;
public class DistinctK_and_Ksize {
    public static List<String> substrings(String s, int k) {
        Set<String> set = new HashSet<>();
        List<String> res = new ArrayList<>();
        int[] ch = new int[26];
        int left=0;
        int right=0;
        
        while(left <= right && right < s.length()) {
            ch[s.charAt(right)-'a']++;
            while(ch[s.charAt(right)-'a'] != 1) {
                ch[s.charAt(left)-'a']--;
                left++;
            }
            if( right - left+ 1 == k) {
                String temp = s.substring(left, right + 1);

                if(!set.contains(temp)){
                    res.add(temp);
                    set.add(s.substring(left, right+1));
                }
                ch[s.charAt(left)-'a']--;
                left++;
            }
            right++;
        }
        return res;
    }


    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String s = scanner.nextLine();
        int k = Integer.parseInt(scanner.nextLine());
        scanner.close();
        List<String> res = substrings(s, k);
        System.out.println(String.join(" ", res));
    }
}

