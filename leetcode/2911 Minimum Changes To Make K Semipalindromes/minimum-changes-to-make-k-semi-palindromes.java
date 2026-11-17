/**
 * Problem: 2911. Minimum Changes to Make K Semi-palindromes
 * Difficulty: Hard
 * Language: Java
 * Runtime: N/A
 * Memory: N/A
 * LeetCode: https://leetcode.com/problems/minimum-changes-to-make-k-semi-palindromes/
 */

class Solution {
    private int helper(char[]str,int l,int r,List<Integer>factors){
        int min=Integer.MAX_VALUE;
        int n=r-l+1;
        for(int d:factors){
            int m=n/d;
            int op=0;
            for(int i=0;i<d;i++){
                int s=l+i;
                int e=l+i+(m-1)*d;
                while(s<e){
                    if(str[s]!=str[e])op++;
                    s+=d;
                    e-=d;
                }
            }
            min=Math.min(min,op);
        }
        return min;
    }
    Integer[][]dp;
    private int solve(char[]str,int idx,int k,int[][]changes){
        if(idx==str.length){
            if(k==0)return 0;
            return (int)1e5;
        }
        if(k==0)return (int)1e5;
        if(dp[idx][k]!=null)return dp[idx][k];
        int min=(int)1e5;
        for(int i=idx+1;i<str.length;i++){
            min=Math.min(min,changes[idx][i]+solve(str,i+1,k-1,changes));
        }
        return dp[idx][k]=min;
    }
    public int minimumChanges(String s, int k) {
        int n=s.length();
        List<Integer>factors[]=new ArrayList[n+1];
        for(int i=1;i<=n;i++){
            factors[i]=new ArrayList<>();
            factors[i].add(1);
            for(int j=2;j*j<=i;j++){
                if(i%j==0){
                    factors[i].add(j);
                    int a=i/j;
                    if(a!=j){
                        factors[i].add(a);
                    }
                }
            }
        }
        int[][]changes=new int[n][n];
        char[]str=s.toCharArray();
        for(int l=0;l<n;l++){
            for(int r=l+1;r<n;r++){
                changes[l][r]=helper(str,l,r,factors[r-l+1]);
            }
        }
        dp=new Integer[n][k+1];
        return solve(str,0,k,changes);
    }
}
