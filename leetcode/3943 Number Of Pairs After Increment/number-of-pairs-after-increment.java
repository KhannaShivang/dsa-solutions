/**
 * Problem: 3943. Number of Pairs After Increment
 * Difficulty: Hard
 * Language: Java
 * Runtime: 2319 ms
 * Memory: 231 MB
 * LeetCode: https://leetcode.com/problems/number-of-pairs-after-increment/
 */

class Solution {
    public int[] numberOfPairs(int[] n1, int[] n2, int[][] queries) {
        int n=n2.length;
        int sqrt=(int)Math.sqrt(n)+1;
        long[]nums1=new long[n1.length];
        for(int i=0;i<n1.length;i++)nums1[i]=n1[i];
        long nums2[]=new long[n];
        for(int i=0;i<n;i++){
            nums2[i]=n2[i];
        }
        int[]decomposition=new int[sqrt];
        List<Integer>res=new ArrayList<>();
        HashMap<Long,Integer>map[]=new HashMap[sqrt];
        for(int i=0;i<sqrt;i
