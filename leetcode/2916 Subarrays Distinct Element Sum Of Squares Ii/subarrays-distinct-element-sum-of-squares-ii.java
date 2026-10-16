/**
 * Problem: 2916. Subarrays Distinct Element Sum of Squares II
 * Difficulty: Hard
 * Language: Java
 * Runtime: N/A
 * Memory: N/A
 * LeetCode: https://leetcode.com/problems/subarrays-distinct-element-sum-of-squares-ii/
 */

this.n=n;
        this.N=4*n;
        sum=new int[N];
        squareSum=new int[N];
        lazy=new int[N];
    }
    public void rangeUpdate(int s,int e){
        rangeUpdate(0,0,n-1,s,e);
    }
    private void rangeUpdate(int idx,int l,int r,int s,int e){
        if(lazy[idx]!=0){
            squareSum[idx]+=2*lazy[idx]*sum[idx]+(r-l+1)*lazy[idx]*lazy[idx];
            sum[idx]+=(r-l+1)*lazy[idx];
            if(l!=r){
                lazy[2*idx+1]+=lazy[idx];
                lazy[2*idx+2]+=lazy[idx];
            }
            lazy[idx]=0;
        }
        if(l>e||r<s)return;
        if(s<=l&&e>=r){
            squareSum[idx]+=2*sum[idx]+(r-l+1);
            sum[idx]+=r-l+1;
            if(l!=r){
                lazy[2*idx+1]+=1;
                lazy[2*idx+2]+=1;
            }
            return;
        }
        int mid=l+(r-l)/2;
        int c1=2*idx+1;
        int c2=2*idx+2;
        rangeUpdate(c1,l,mid,s,e);
        rangeUpdate(c2,mid+1,r,s,e);
        squareSum[idx]=square
