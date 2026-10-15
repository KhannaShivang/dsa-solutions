/**
 * Problem: 2913. Subarrays Distinct Element Sum of Squares I
 * Difficulty: Easy
 * Language: Java
 * Runtime: N/A
 * Memory: N/A
 * LeetCode: https://leetcode.com/problems/subarrays-distinct-element-sum-of-squares-i/
 */

class Solution {
    public int sumCounts(List<Integer> nums) {
        int n=nums.size();
        int sum=0;
        for(int i=0;i<n;i++){
            HashSet<Integer>set=new HashSet<>();
            for(int j=i;j<n;j++){
                set.add(nums.get(j));
                sum+=set.size()*set.size();
            }
        }
        return sum;
    }
}
