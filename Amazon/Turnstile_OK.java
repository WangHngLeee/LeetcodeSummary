package AmazonNG;
import java.util.*;

public class Turnstile_OK {
    public int[] getTimes(int numCustomers, int[] arrTime, int[] direction) {
        Queue<int[]> exit = new LinkedList<>();
        Queue<int[]> entry = new LinkedList<>();
        int n = arrTime.length;
        int[] res = new int[n];

        for (int i = 0; i < n; i++) {
            if (direction[i] == 1)
                exit.offer(new int[]{arrTime[i], i});
            else
                entry.offer(new int[]{arrTime[i], i});
        }

        int ct = 0, lc = -1;

        // ct is the current time & lc indicates who used
        // turnstile in the previous second lc = -1 if none
        // used the turnstile in the last second

        while (!exit.isEmpty() || !entry.isEmpty()) {
            // checking for exit queue
            if (!exit.isEmpty() && exit.peek()[0] <= ct &&
                    (lc == 1 || lc == -1 || entry.isEmpty() || entry.peek()[0] > ct) ) {

                res[exit.peek()[1]] = ct;
                lc = 1;
                exit.poll();
            }
            // checking for entry queue
            else if (!entry.isEmpty() && entry.peek()[0] <= ct) {
                res[entry.peek()[1]] = ct;
                lc = 0;
                entry.poll();
            } else {
                lc = -1;
            }
            ct++;
        }
        return res;
    }
}
