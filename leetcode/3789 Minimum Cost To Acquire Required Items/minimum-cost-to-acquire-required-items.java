/**
 * Problem: 3789. Minimum Cost to Acquire Required Items
 * Difficulty: Medium
 * Language: Java
 * Runtime: N/A
 * Memory: N/A
 * LeetCode: https://leetcode.com/problems/minimum-cost-to-acquire-required-items/
 */

1class Solution {
2    public long minimumCost(int cost1, int cost2, int costBoth, int need1, int need2) {
3        if(cost1+cost2<costBoth)return cost1*1l*need1+cost2*1l*need2;
4        long res=0;
5        if(need1<need2){
6          res=costBoth*need1*1l;
7          res+=(need2-need1)*1l*Math.min(cost2,costBoth);
8          }
9        else{
10          res=costBoth*need2;
11          res+=(need1-need2)*1l*Math.min(cost1,costBoth);
12          }
13        return res;
14    }
15}
