/**
 * Problem: 932. Beautiful Array
 * Difficulty: Medium
 * Language: Java
 * Runtime: N/A
 * Memory: N/A
 * LeetCode: https://leetcode.com/problems/beautiful-array/
 */

1class Solution {
2    public int[] beautifulArray(int n) {
3        if(n==1)return new int[]{1};
4        int ans[]=new int[n];
5        int idx=0;
6        for(int x:beautifulArray(n/2)){
7            ans[idx++]=2*x;
8        }
9        for(int x:beautifulArray((n+1)/2)){
10            ans[idx++]=2*x-1;
11        }
12        return ans;
13    }
14}
