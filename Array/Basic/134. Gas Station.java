//134. Gas Station
https://leetcode.com/problems/gas-station/

// Do the simulation. Scan gas and cost, find the total cost and total gas. If gas < cost, return -1
// During the scanning, if exist one step that tank < 0, then choose next point as start.

class Solution {
    public int canCompleteCircuit(int[] gas, int[] cost) {
        int gasSum = 0;
        int costSum = 0;
        int start = 0;
        int tank = 0;
        for(int i=0; i<gas.length; i++){
            gasSum += gas[i];
            costSum += cost[i];
            tank += gas[i] - cost[i];
            if(tank < 0){
                start = i + 1;
                tank = 0;
            }
        }
        if(gasSum < costSum)return -1;
        else return start;
    }
}
