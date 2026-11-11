/**
 * Problem: 3789. Minimum Cost to Acquire Required Items
 * Difficulty: Medium
 * Language: Java
 * Runtime: N/A
 * Memory: N/A
 * LeetCode: https://leetcode.com/problems/minimum-cost-to-acquire-required-items/
 */

class Solution {
    public long minimumCost(int cost1, int cost2, int costBoth, long need1, long need2) {
        if(cost1+cost2<costBoth)return cost1*need1+cost2*need2;
        long res=0;
        if(need1<need2){
          res=costBoth*need1;
          res+=(need2-need1)*Math.min(cost2,costBoth);
          }
        else{
          res=costBoth*need2;
          res+=(need1-need2)*Math.min(cost1,costBoth);
          }
          return res;
    }
}
