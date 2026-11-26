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
9                long key = nums[i]*(long)1e9+nums[i+1];
10                map.put(key,map.getOrDefault(key,0)+1);
11                key = nums[i+1]*(long)1e9+nums[i];
12                map.put(key,map.getOrDefault(key,0)+1);
13            }
14        }
15        int max=0;
16        for(int i:map.values()){
17            max=Math.max(max,i);
18        }
19        return count+max;
20    }
21}
