/**
 * Problem: 1535. Find the Winner of an Array Game
 * Difficulty: Medium
 * Language: Java
 * Runtime: N/A
 * Memory: N/A
 * LeetCode: https://leetcode.com/problems/find-the-winner-of-an-array-game/
 */

class Solution {
    public int getWinner(int[] nums, int k) {
        int n=nums.length;
        int score=0;
        if(k>=n)return Arrays.stream(nums).max().getAsInt();
        for(int i=0;i<n;){
            int idx=i;
            while(nums[++i%n]<nums[idx]){
                score++;
                if(score==k)return nums[idx];
            }
            if(idx>i)break;
            score=1;
        }
        return -1;
    }
}
