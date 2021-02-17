package AmazonNG;
import java.util.*;

public class CountTeams_OK {
    static Map<String,Integer> memoMap = new HashMap<>();
    public static int countTeams(int num, int[] skills, int minAssociates, int minLevel, int maxLevel){
        // WRITE YOUR BRILLIANT CODE HERE
        int count = 0;
        int res = 0;
        for(int skill : skills){
            if(skill >= minLevel && skill <= maxLevel)count++;
        }
        for(int i= minAssociates; i<= count; i++){
            res += comb(count, i);
        }
        return res;
    }
    private static int comb(int m, int n){
        String key = m +"+"+ n;
        if(n == 0)return 1;
        if(n == 1)return m;
        if(n > m/2)return comb(m, m-n);
        if(n > 1){
            if(!memoMap.containsKey(key)){
                int temp = comb(m-1,n-1) + comb(m-1,n);
                memoMap.put(key, temp);
            }
            return memoMap.get(key);
        }
        return 0;
    }








    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);
        int num = Integer.parseInt(scanner.nextLine());
        int[] skills = Arrays.stream(scanner.nextLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        int minAssociates = Integer.parseInt(scanner.nextLine());
        int minLevel = Integer.parseInt(scanner.nextLine());
        int maxLevel = Integer.parseInt(scanner.nextLine());
        scanner.close();
        System.out.println(countTeams(num, skills, minAssociates, minLevel, maxLevel));
    }
}
