/**
 * Problem: 4066. Maximum Equal Adjacent Pairs After at Most One Replacement
 * Difficulty: Medium
 * Language: Java
 * Runtime: N/A
 * Memory: N/A
 * LeetCode: https://leetcode.com/problems/maximum-equal-adjacent-pairs-after-at-most-one-replacement/
 */

1class Solution {
2    public int maxEqualAdjacentPairs(int[] nums) {
3        int n=nums.length;
4        HashMap<Long,Integer>map=new HashMap<>();
5        int count=0;
6        for(int i=0;i<n-1;i++){
7            if(nums[i]==nums[i+1])count++;
8            else{
9                int a=nums[i];
10                int b=nums[i+1];
11                if(a>b){
12                    a=a^b;
13                    b=a^b;
14                    a=a^b;
15                }
16                long key = a*(long)1e9+b;
17                map.put(key,map.getOrDefault(key,0)+1);
18            }
19        }
20        int max=0;
21        for(int i:map.values()){
22            max=Math.max(max,i);
23        }
24        return count+max;
25    }
26}
