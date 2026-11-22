/**
 * Problem: 2124. Check if All A's Appears Before All B's
 * Difficulty: Easy
 * Language: Java
 * Runtime: N/A
 * Memory: N/A
 * LeetCode: https://leetcode.com/problems/check-if-all-as-appears-before-all-bs/
 */

class Solution {
    public boolean checkString(String s) {
        boolean bSeen=false;
        for(char ch:s.toCharArray()){
            if(ch=='a'){
                if(bSeen)return false;
            }
            else{
                bSeen=true;
            }
        }
        return true;
    }
}
