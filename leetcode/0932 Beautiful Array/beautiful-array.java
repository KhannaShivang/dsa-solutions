/**
 * Problem: 932. Beautiful Array
 * Difficulty: Medium
 * Language: Java
 * Runtime: N/A
 * Memory: N/A
 * LeetCode: https://leetcode.com/problems/beautiful-array/
 */

class Solution {
    public int[] beautifulArray(int n) {
        if(n==1)return new int[]{1};
        int ans[]=new int[n];
        int idx=0;
        int[]next=beautifulArray(n/2);
        for(int x:next){
            ans[idx++]=2*x;
        }
        if(n%2==1){
            next=beautifulArray((n+1)/2);
        }
        for(int x:next){
            ans[idx++]=2*x-1;
        }
        return ans;
    }
}
