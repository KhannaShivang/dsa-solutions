/**
 * Problem: 3411. Maximum Subarray With Equal Products
 * Difficulty: Easy
 * Language: Java
 * Runtime: 2
ms
 * Memory: 43.65
MB
 * LeetCode: https://leetcode.com/problems/maximum-subarray-with-equal-products/
 */

1class Solution {
2    private int gcd(int a,int b){
3        if(b==0)return a;
4        return gcd(b,a%b);
5    }
6    private int lcm(int a,int b){
7        return a*b/gcd(a,b);
8    }
9    public int maxLength(int[] nums) {
10        int ans=0;
11        int n=nums.length;
12        for(int i=0;i<n;i++){
13            int pro=nums[i];
14            int gcd=nums[i];
15            int lcm=nums[i];
16            for(int j=i+1;j<n;j++){
17                pro*=nums[j];
18                gcd=gcd(gcd,nums[j]);
19                if(pro>gcd*2520)break;
20                lcm=lcm(lcm,nums[j]);
21                if(pro==gcd*lcm){
22                    ans=Math.max(ans,j-i+1);
23                }
24            }
25        }
26        return ans;
27    }
28}
