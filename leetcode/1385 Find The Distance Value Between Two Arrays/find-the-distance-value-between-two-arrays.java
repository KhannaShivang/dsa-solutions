/**
 * Problem: 1385. Find the Distance Value Between Two Arrays
 * Difficulty: Easy
 * Language: Java
 * Runtime: N/A
 * Memory: N/A
 * LeetCode: https://leetcode.com/problems/find-the-distance-value-between-two-arrays/
 */

class Solution {
    public int findTheDistanceValue(int[] arr1, int[] arr2, int d) {
        Arrays.sort(arr2);
        int count=0;
        for(int i:arr1){
            int idx=Arrays.binarySearch(arr2,i);
            if(idx<0)idx=-idx-1;
            else continue;
            if((idx==arr2.length||Math.abs(arr2[idx]-i)>d)&&(idx==0||i-arr2[idx-1]>d))count++;
        }
        return count;
    }
}
