/**
 * Problem: 2747. Count Zero Request Servers
 * Difficulty: Medium
 * Language: Java
 * Runtime: N/A
 * Memory: N/A
 * LeetCode: https://leetcode.com/problems/count-zero-request-servers/
 */

1class Solution {
2    public int[] countServers(int n, int[][] logs, int x, int[] queries) {
3        int l=queries.length;
4        Integer[]idx=new Integer[l];
5        for(int i=0;i<l;i++){
6            idx[i]=i;
7        }
8        Arrays.sort(logs,(a,b)->a[1]-b[1]);
9        Arrays.sort(idx,(a,b)->queries[a]-queries[b]);
10        int[]res=new int[l];
11        HashMap<Integer,Integer>map=new HashMap<>();
12        int left=0;
13        int right=0;
14        int upper=0;
15        for(int i=0;i<l;i++){
16            while(right<logs.length&&logs[right][1]<=queries[idx[i]]){
17                map.put(logs[right][0],map.getOrDefault(logs[right][0],0)+1);
18                right++;
19            }
20            while(queries[idx[i]]-logs[left][1]>x){
21                map.put(logs[left][0],map.get(logs[left][0])-1);
22                if(map.get(logs[left][0])==0)map.remove(logs[left][0]);
23                left++;
24            }
25            res[idx[i]]=n-map.size();
26        }
27        return res;
28    }
29}
