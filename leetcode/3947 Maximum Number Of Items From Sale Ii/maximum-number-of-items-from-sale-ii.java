/**
 * Problem: 3947. Maximum Number of Items From Sale II
 * Difficulty: Medium
 * Language: Java
 * Runtime: 1 ms
 * Memory: N/A
 * LeetCode: https://leetcode.com/problems/maximum-number-of-items-from-sale-ii/
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
        PriorityQueue<int[]>pq=new PriorityQueue<>((a,b)->a[0]-b[0]);
        for(int i=0;i<n;i++){
            if(count[i]==1){
                pq.offer(new int[]{items[i][1]*2,1});
            }
            else{
                pq.offer(new int[]{items[i][1],count[i]});
            }
        }
        int copies=0;
        while(budget>0&&!pq.isEmpty()){
            int[]curr=pq.poll();
            if(curr[1]==1){
                if(budget<curr[0]/2)continue;
                budget-=curr[0]/2;
                copies++;
            }
            else{
                if(curr[0]>budget)continue;
                copies+=2;
                budget-=curr[0];
                curr[1]--;
                if(curr[1]==1)curr[0]*=2;
            }
            pq.offer(curr);
        }
        return copies;
    }
}
