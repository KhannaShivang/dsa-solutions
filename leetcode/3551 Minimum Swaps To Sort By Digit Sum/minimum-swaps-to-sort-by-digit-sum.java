/**
 * Problem: 3551. Minimum Swaps to Sort by Digit Sum
 * Difficulty: Medium
 * Language: Java
 * Runtime: N/A
 * Memory: N/A
 * LeetCode: https://leetcode.com/problems/minimum-swaps-to-sort-by-digit-sum/
 */

1class Solution {
2    private int digitSum(int num){
3        int sum=0;
4        while(num!=0){
5            sum+=num%10;
6            num/=10;
7        }
8        return sum;
9    }
10    public int minSwaps(int[] nums) {
11        int n=nums.length;
12        Integer[]idx=new Integer[n];
13        int digitSum[]=new int[n];
14        for(int i=0;i<n;i++){
15            digitSum[i]=digitSum(nums[i]);
16        }
17        for(int i=0;i<n;i++){
18            idx[i]=i;
19        }
20        Arrays.sort(idx,(a,b)->{
21            int sum1=digitSum[a];
22            int sum2=digitSum[b];
23            if(sum1==sum2){
24                return nums[a]-nums[b];
25            }
26            return sum1-sum2;
27        });
28        int[]target=new int[n];
29        for(int i=0;i<n;i++){
30            target[i]=idx[i];
31        }
32        int swaps=0;
33        int i=0;
34        while(i<n){
35            int curr=target[i];
36            if(curr==i){
37                i++;
38                continue;
39            }
40            swaps++;
41            int next=target[curr];
42            target[i]=next;
43            target[curr]=curr;
44        }
45        return swaps;
46    }
47}
