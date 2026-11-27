/**
 * Problem: 3946. Maximum Number of Items From Sale I
 * Difficulty: Medium
 * Language: Java
 * Runtime: N/A
 * Memory: N/A
 * LeetCode: https://leetcode.com/problems/maximum-number-of-items-from-sale-i/
 */

1class Solution {
2    Integer[][][]dp;
3    private int helper(int idx,int budget,int taken,int[][]items,int[]count){
4        if(budget<0)return -10000;
5        if(idx==items.length)return 0;
6        if(dp[idx][budget][taken]!=null)return dp[idx][budget][taken];
7        int take=helper(idx,budget-items[idx][1],1,items,count)+1;
8        int notTake=helper(idx+1,budget,0,items,count)+(taken==1?count[idx]:0);
9        return dp[idx][budget][taken]=Math.max(take,notTake);
10    }
11    public int maximumSaleItems(int[][] items, int budget) {
12        int n=items.length;
13        int count[]=new int[n];
14        for(int i=0;i<n;i++){
15            for(int j=0;j<n;j++){
16                if(i!=j){
17                    if(items[j][0]%items[i][0]==0)count[i]++;
18                }
19            }
20        }
21        dp=new Integer[items.length][budget+1][2];
22        return helper(0,budget,0,items,count);
23    }
24}
