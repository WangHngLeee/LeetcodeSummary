// 277. Find the Celebrity
https://leetcode.com/problems/find-the-celebrity/description/

// 首先找到关系链最末端的人ppl，然后再重新检查是不是每个人都认识ppl，如果某个人i不认识ppl并且ppl认识i，则返回-1

public class Solution extends Relation {
    public int findCelebrity(int n) {
        int ppl = 0;
        for (int i = 0; i <= n; i++) {
            if (knows(ppl, i)) {
                ppl = i;
            }
        }
        for (int i = 0; i < n; i++) {
//            if final person knows i but i didn't know that person, it means no celeberity, return -1
            if (i != ppl && (!knows(i, ppl) && knows(ppl, i))) {
                return -1;
            }
        }
        return ppl;
    }
}
