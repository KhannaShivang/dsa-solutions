/**
 * Problem: 2409. Count Days Spent Together
 * Difficulty: Easy
 * Language: Java
 * Runtime: N/A
 * Memory: N/A
 * LeetCode: https://leetcode.com/problems/count-days-spent-together/
 */

class Solution {
    public int countDaysTogether(String arriveAlice, String leaveAlice, String arriveBob, String leaveBob) {
        int[]month={0,31,59,90,120,151,181,212,243,273,304,334};
        int aliceArive=month[Integer.parseInt(arriveAlice.substring(0,2))-1]+
        Integer.parseInt(arriveAlice.substring(3));
        int aliceLeave=month[Integer.parseInt(leaveAlice.substring(0,2))-1]+
        Integer.parseInt(leaveAlice.substring(3));
        int bobArive=month[Integer.parseInt(arriveBob.substring(0,2))-1]+
        Integer.parseInt(arriveBob.substring(3));
        int bobLeave=month[Integer.parseInt(leaveBob.substring(0,2))-1]+
        Integer.parseInt(leaveBob.substring(3));
        return Math.max(0,(Math.min(aliceLeave,bobLeave)-Math.max(aliceArive,bobArive)+1));
    }
}
