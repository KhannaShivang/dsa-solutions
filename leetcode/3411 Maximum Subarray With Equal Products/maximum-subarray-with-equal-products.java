/**
 * Problem: 3411. Maximum Subarray With Equal Products
 * Difficulty: Easy
 * Language: Java
 * Runtime: N/A
 * Memory: N/A
 * LeetCode: https://leetcode.com/problems/maximum-subarray-with-equal-products/
 */

class Solution {
    private int gcd(int a,int b){
        if(b==0)return a;
        return gcd(b,a%b);
    }
    private int lcm(int a,int b){
        return a*b/gcd(a,b);
    }
    public int maxLength(int[] nums) {
        int ans=0;
        int n=nums.length;
        for(int i=0;i<n;i++){
            int pro=nums[i];
            int gcd=nums[i];
            int lcm=nums[i];
            for(int j=i+1;j<n;j++){
                pro*=nums[j];
                gcd=gcd(gcd,nums[j]);
                // if(pro>gcd*2520)break;
                lcm=lcm(lcm,nums[j]);
                if(pro==gcd*lcm){
                    ans=Math.max(ans,j-i+1);
                }
            }
        }
        return ans;
    }
}
