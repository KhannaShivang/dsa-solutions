/**
 * Problem: 3946. Maximum Number of Items From Sale I
 * Difficulty: Medium
 * Language: Java
 * Runtime: N/A
 * Memory: N/A
 * LeetCode: https://leetcode.com/problems/maximum-number-of-items-from-sale-i/
 */

class Solution {
    Integer[][]dp;
    int chep=Integer.MAX_VALUE;
    private int helper(int idx,int budget,int[][]items,int[]count){
        if(budget<0)return -10000;
        if(idx==items.length)return budget/chep;
        if(dp[idx][budget]!=null)return dp[idx][budget];
        int take=helper(idx+1,budget-items[idx][1],items,count)+1+count[idx];
        int notTake=helper(idx+1,budget,items,count);
        return dp[idx][budget]=Math.max(take,notTake);
    }
    public int maximumSaleItems(int[][] items, int budget) {
        int n=items.length;
        int count[]=new int[n];
        for(int i=0;i<n;i++){
            chep=Math.min(chep,items[i][1]);
            for(int j=0;j<n;j++){
                if(i!=j){
                    if(items[j][0]%items[i][0]==0)count[i]++;
                }
            }
        }
        dp=new Integer[items.length][budget+1];
        return helper(0,budget,items,count);
    }
}
