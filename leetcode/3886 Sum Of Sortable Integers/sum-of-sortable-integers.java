/**
 * Problem: 3886. Sum of Sortable Integers
 * Difficulty: Hard
 * Language: Java
 * Runtime: N/A
 * Memory: N/A
 * LeetCode: https://leetcode.com/problems/sum-of-sortable-integers/
 */

class Solution {
    public int sortableIntegers(int[] nums) {
        List<Integer>factors=new ArrayList<>();
        int n=nums.length;
        for(int i=1;i*i<=n;i++){
            if(n%i==0){
                factors.add(i);
                if(i*i!=n)factors.add(n/i);
            }
        }
        int sum=0;
        outer:for(int k:factors){
            int max=nums[0];
            for(int i=1;i<k;i++){
                max=Math.max(max,nums[i]);
            }
            int subArrays=n/k;
            for(int i=0;i<subArrays;i++){
                int dip=-1;
                int nextMin=nums[i*k];
                int nextMax=nums[i*k];
                if(i!=0&&nextMin<max)continue outer;
                for(int j=1;j<k;j++){
                    int idx=k*i+j;
                    nextMin=Math.min(nextMin,nums[idx]);
                    nextMax=Math.max(nextMax,nums[idx]);
                    if(i!=0&&max>nextMin)continue outer;
                    if(
