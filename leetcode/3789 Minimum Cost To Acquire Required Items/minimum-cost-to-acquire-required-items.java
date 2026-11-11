/**
 * Problem: 3789. Minimum Cost to Acquire Required Items
 * Difficulty: Medium
 * Language: Java
 * Runtime: 1
ms
 * Memory: 42.14
MB
 * LeetCode: https://leetcode.com/problems/minimum-cost-to-acquire-required-items/
 */

class Solution {
    public long minimumCost(int cost1, int cost2, int costBoth, int need1, int need2) {
        if(cost1+cost2<costBoth)return cost1*1l*need1+cost2*1l*need2;
        long res=0;
        if(need1<need2){
          res=costBoth*1l*need1;
          res+=(need2-need1)*1l*Math.min(cost2,costBoth);
          }
        else{
          res=costBoth*1l*need2;
          res+=(need1-need2)*1l*Math.min(cost1,costBoth);
          }
        return res;
    }
}
