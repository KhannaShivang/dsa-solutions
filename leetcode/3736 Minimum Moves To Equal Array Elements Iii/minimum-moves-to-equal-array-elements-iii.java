/**
 * Problem: 3736. Minimum Moves to Equal Array Elements III
 * Difficulty: Easy
 * Language: Java
 * Runtime: 2
ms
 * Memory: 45.95
MB
 * LeetCode: https://leetcode.com/problems/minimum-moves-to-equal-array-elements-iii/
 */

class Solution {
    public int minMoves(int[] nums) {
        int max=nums[0];
        int n=nums.length;
        int moves=0;
        for(int i=1;i<n;i++){
            if(nums[i]>max){
                moves+=i*(nums[i]-max);
                max=nums[i];
            }
            else{
                moves+=max-nums[i];
            }
        }
        return moves;
    }
}
