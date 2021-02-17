package AmazonNG;
import java.util.*;
import java.util.stream.Collectors;

public class CutOffRank_OK {
    public static int cutOffRank(int cutOff, List<Integer> scores) {

        // WRITE YOUR BRILLIANT CODE HERE
        int[] count = new int[101];
        for(int score: scores){
            count[score]++;
        }
        int rank = 1;
        int res = 0;
        for(int i= 100; i>=0; i--){
            if(rank > cutOff)break;
            if(count[i] != 0){
                res += count[i];
                rank = res + 1;
            }
        }
        return res;
    }






    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int cutOff = Integer.parseInt(scanner.nextLine());
        List<Integer> scores = Arrays.stream(scanner.nextLine().split(" ")).map(Integer::parseInt).collect(Collectors.toList());
        scanner.close();
        int res = cutOffRank(cutOff, scores);
        System.out.println(res);
    }
}
