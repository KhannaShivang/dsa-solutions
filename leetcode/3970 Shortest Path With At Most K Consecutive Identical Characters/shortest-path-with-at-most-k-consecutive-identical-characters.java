/**
 * Problem: 3970. Shortest Path With At Most K Consecutive Identical Characters
 * Difficulty: Medium
 * Language: Java
 * Runtime: N/A
 * Memory: N/A
 * LeetCode: https://leetcode.com/problems/shortest-path-with-at-most-k-consecutive-identical-characters/
 */

class Solution {
    int n;
    Integer[][]dp;
    private int helper(List<int[]>[]graph,int node,int cont,char last,int k,char[]labels){
        if(cont>=k)return (int)1e9;
        if(node==n-1)return 0;
        if(dp[node][cont]!=null)return dp[node][cont];
        int curr=(int)1e9;
        for(int[]i:graph[node]){
            int v=i[0];
            int w=i[1];
            curr=Math.min(curr,helper(graph,v,(labels[i[0]]==last?cont+1:0)
            ,labels[i[0]],k,labels)+w);
        }
        return dp[node][cont]=curr;
    }
    public int shortestPath(int n, int[][] edges, String labels, int k) {
        this.n=n;
        List<int[]>[]graph=new ArrayList[n];
        for(int i=0;i<n;i++)graph[i]=new ArrayList<>();
        for(int[]e:edges){
            graph[e[0]].add(new int[]{e[1],e[2]});
        }
        int[][]weights=new int[n][k+1];
        PriorityQueue<int[]>queue=new PriorityQueue<>((a,b)->
        weights[a[0]][a[1]]-weights[b[0]][b[1]]);
        for(int i=0;i<n;i++)Arrays.fill(weights[i],(int)1e9);
        weights[0][0]=0;
        char[]str=labels.toCharArray();
        queue.offer(new int[]{0,0,str[0]-'a'});
        int res=(int)1e9;
        while(!queue.isEmpty()){
            int curr[]=queue.poll();
            if(curr[1]==k)continue;
            if(curr[0]==n-1){
                res=Math.min(res,weights[n-1][curr[1]]);
                continue;
            }
            for(int[]i:graph[curr[0]]){
                int cont=str[i[0]]-'a'==curr[2]?curr[1]+1:0;
                if(weights[i[0]][cont]>weights[curr[0]][curr[1]]+i[1]){
                    weights[i[0]][cont]=weights[curr[0]][curr[1]]+i[1];
                    queue.offer(new int[]{i[0],cont,str[i[0]]-'a'});
                }
            }
        }
        if(res==(int)1e9)return -1;
        return res;
    }
}
