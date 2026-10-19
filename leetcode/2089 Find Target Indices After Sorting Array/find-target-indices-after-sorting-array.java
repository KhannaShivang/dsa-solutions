/**
 * Problem: 2089. Find Target Indices After Sorting Array
 * Difficulty: Easy
 * Language: Java
 * Runtime: N/A
 * Memory: N/A
 * LeetCode: https://leetcode.com/problems/find-target-indices-after-sorting-array/
 */

class Solution {
    public List<Integer> targetIndices(int[] nums, int target) {
        int less=0;
        int equal=0;
        for(int i:nums){
            if(i<target)less++;
            if(i==target)equal++;
        }
        List<Integer>res=new ArrayList<>();
        while(equal-->0){
            res.add(less++);
        }
        return res;
    }
}
