/**
 * Problem: 3946. Maximum Number of Items From Sale I
 * Difficulty: Medium
 * Language: Java
 * Runtime: 1 ms
 * Memory: N/A
 * LeetCode: https://leetcode.com/problems/maximum-number-of-items-from-sale-i/
 */

class Solution {
    public int maximumSaleItems(int[][] items, int budget) {
        int n=items.length;
        HashMap<Integer,List<Integer>>map=new HashMap<>();
        for(int i=0;i<n;i++){
            map.putIfAbsent(items[i][0],new ArrayList<>());
            map.get(items[i][0]).add(i);
        }
        HashMap<Integer,Integer>copy=new HashMap<>();
        for(int i=0;i<n;i++){
            int factor=items[i][0];
            for(int j=1;j*j<=factor;j++){
                if(factor%j==0){
                    if(map.containsKey(j))copy.put(j,copy.getOrDefault(j,0)+1);
                    int k=factor/j;
                    if(k!=j){
                        if(map.containsKey(k))copy.put(k,copy.getOrDefault(k,0)+1);
                    }
                }
            }
        }
        int[]count=new int[n];
        for(int key:map.keySet()){
            for(int i:map.get(key)){
                count[i]+=copy.get(key);
            }
        }
        PriorityQueue<int[]>pq=new PriorityQueue<>((a,b)->
                        Double.compare((double)a[0]/a[1],(double)b[0]/b[1]));
        for(int i=0;i<n;i++){
            pq.offer(new int[]{items[i][1],count[i]});
        }
        int copies=0;
        while(budget>0&&!pq.isEmpty()){
            int[]curr=pq.poll();
            if(curr[0]>budget)continue;
            copies+=curr[1];
            budget-=curr[0];
            pq.offer(new int[]{curr[0],1});
        }
        return copies;
    }
}
