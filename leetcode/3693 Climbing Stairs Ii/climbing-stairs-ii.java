/**
 * Problem: 3693. Climbing Stairs II
 * Difficulty: Medium
 * Language: Java
 * Runtime: 72
ms
 * Memory: 145.35
MB
 * LeetCode: https://leetcode.com/problems/climbing-stairs-ii/
 */

class Solution {
  Integer[]dp;
  private int helper(int idx,int n,int[]cost){
    if(idx==n)return 0;
    if(dp[idx]!=null)return dp[idx];
    int min=(int)1e9;
    if(idx<=n-1)min=Math.min(min,cost[idx]+1+helper(idx+1,n,cost));
    if(idx<=n-2)min=Math.min(min,cost[idx+1]+4+helper(idx+2,n,cost));
    if(idx<=n-3)min=Math.min(min,cost[idx+2]+9+helper(idx+3,n,cost));
    return dp[idx]=min;
    }
    public int climbStairs(int n, int[] costs) {
        dp=new Integer[n];
        return helper(0,n,costs);
    }
}
