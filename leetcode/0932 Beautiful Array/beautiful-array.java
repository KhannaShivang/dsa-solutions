/**
 * Problem: 932. Beautiful Array
 * Difficulty: Medium
 * Language: Java
 * Runtime: 0 ms
 * Memory: N/A
 * LeetCode: https://leetcode.com/problems/beautiful-array/
 */

class Solution {
    public int[] beautifulArray(int n) {
        if(n==1)return new int[]{1};
        int ans[]=new int[n];
        int idx=0;
        for(int x:beautifulArray(n/2)){
            ans[idx++]=2*x;
        }
        for(int x:beautifulArray((n+1)/2)){
            ans[idx++]=2*x-1;
        }
        return ans;
    }
}
