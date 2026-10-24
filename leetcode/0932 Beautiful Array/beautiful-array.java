/**
 * Problem: 932. Beautiful Array
 * Difficulty: Medium
 * Language: Java
 * Runtime: N/A
 * Memory: N/A
 * LeetCode: https://leetcode.com/problems/beautiful-array/
 */

1class Solution {
2    HashMap<Integer,int[]>map;
3    private int[] helper(int n){
4        if(n==1)return new int[]{1};
5        if(map.containsKey(n))return map.get(n);
6        int[]ans=new int[n];
7        int idx=0;
8        for(int i:helper(n/2)){
9            ans[idx++]=2*i;
10        }
11        for(int i:helper((n+1)/2)){
12            ans[idx++]=2*i-1;
13        }
14        map.put(n,ans);
15        return ans;
16    }
17    public int[] beautifulArray(int n) {
18        map=new HashMap<>();
19        return helper(n);
20    }
21}
