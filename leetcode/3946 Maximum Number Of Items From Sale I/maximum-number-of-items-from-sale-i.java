/**
 * Problem: 3946. Maximum Number of Items From Sale I
 * Difficulty: Medium
 * Language: Java
 * Runtime: 0 ms
 * Memory: N/A
 * LeetCode: https://leetcode.com/problems/maximum-number-of-items-from-sale-i/
 */

class Solution {
    Integer[][][]dp;
    private int helper(int idx,int budget,int taken,int[][]items,int[]count){
        if(budget<0)return -10000;
        if(idx==items.length)return 0;
        if(dp[idx][budget][taken]!=null)return dp[idx][budget][taken];
        int take=helper(idx,budget-items[idx][1],1,items,count)+1;
        int notTake=helper(idx+1,budget,0,items,count)+(taken==1?count[idx]:0);
        return dp[idx][budget][taken]=Math.max(take,notTake);
    }
    public int maximumSaleItems(int[][] items, int budget) {
        int n=items.length;
        int count[]=new int[n];
        for(int i=0;i<n;i++){
            for(int j=0;j<n;j++){
                if(i!=j){
                    if(items[j][0]%items[i][0]==0)count[i]++;
                }
            }
        }
        dp=new Integer[items.length][budget+1][2];
        return helper(0,budget,0,items,count);
    }
}
