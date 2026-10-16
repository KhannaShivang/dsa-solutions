/**
 * Problem: 2916. Subarrays Distinct Element Sum of Squares II
 * Difficulty: Hard
 * Language: Java
 * Runtime: 0 ms
 * Memory: N/A
 * LeetCode: https://leetcode.com/problems/subarrays-distinct-element-sum-of-squares-ii/
 */

pdate(c1,l,mid,s,e);
        rangeUpdate(c2,mid+1,r,s,e);
        squareSum[idx]=squareSum[c1]+squareSum[c2];
        sum[idx]=sum[c1]+sum[c2];
    }
}
class Solution {
    public int sumCounts(int[] nums) {
        long res=0;
        int mod=(int)1e9+7;
        HashMap<Integer,Integer>lastIdx=new HashMap<>();
        int n=nums.length;
        SegmentTree tree=new SegmentTree(n);
        for(int i=0;i<n;i++){
            if(!lastIdx.containsKey(nums[i])){
                tree.rangeUpdate(0,i);
                res=(res+tree.squareSum[0])%mod;
            }
            else{
                tree.rangeUpdate(lastIdx.get(nums[i])+1,i);
                res=(res+tree.squareSum[0])%mod;
            }
            lastIdx.put(nums[i],i);
        }
        return (int)res;
    }
}
