/**
 * Problem: 3360. Stone Removal Game
 * Difficulty: Easy
 * Language: Java
 * Runtime: N/A
 * Memory: N/A
 * LeetCode: https://leetcode.com/problems/stone-removal-game/
 */

class Solution {
    public boolean canAliceWin(int n) {
        boolean turn=false;
        int curr=10;
        while(n>=curr){
            n-=curr--;
            turn=!turn;
        }
        return turn;
    }
}
