/**
 * Problem: 3946. Maximum Number of Items From Sale I
 * Difficulty: Medium
 * Language: Java
 * Runtime: N/A
 * Memory: N/A
 * LeetCode: https://leetcode.com/problems/maximum-number-of-items-from-sale-i/
 */

1class Solution {
2    public int maximumSaleItems(int[][] items, int budget) {
3        int n=items.length;
4        HashMap<Integer,List<Integer>>map=new HashMap<>();
5        for(int i=0;i<n;i++){
6            map.putIfAbsent(items[i][0],new ArrayList<>());
7            map.get(items[i][0]).add(i);
8        }
9        HashMap<Integer,Integer>copy=new HashMap<>();
10        for(int i=0;i<n;i++){
11            int factor=items[i][0];
12            for(int j=1;j*j<=factor;j++){
13                if(factor%j==0){
14                    if(map.containsKey(j))copy.put(j,copy.getOrDefault(j,0)+1);
15                    int k=factor/j;
16                    if(k!=j){
17                        if(map.containsKey(k))copy.put(k,copy.getOrDefault(k,0)+1);
18                    }
19                }
20            }
21        }
22        int[]count=new int[n];
23        for(int key:map.keySet()){
24            for(int i:map.get(key)){
25                count[i]+=copy.get(key);
26            }
27        }
28        PriorityQueue<int[]>pq=new PriorityQueue<>((a,b)->
29                        Double.compare((double)a[0]/a[1],(double)b[0]/b[1]));
30        for(int i=0;i<n;i++){
31            pq.offer(new int[]{items[i][1],count[i]});
32        }
33        int copies=0;
34        while(budget>0&&!pq.isEmpty()){
35            int[]curr=pq.poll();
36            if(curr[0]>budget)continue;
37            copies+=curr[1];
38            budget-=curr[0];
39            pq.offer(new int[]{curr[0],1});
40        }
41        return copies;
42    }
43}
