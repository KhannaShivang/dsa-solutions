/**
 * Problem: 3943. Number of Pairs After Increment
 * Difficulty: Hard
 * Language: Java
 * Runtime: 0 ms
 * Memory: N/A
 * LeetCode: https://leetcode.com/problems/number-of-pairs-after-increment/
 */

s2){
            map.put(i,map.getOrDefault(i,0)+1);
        }
        for(int[]q:queries){
            if(q[0]==1){
                int x=q[1];
                int y=q[2];
                int val=q[3];
                if(x==y){
                    map.put(nums2[x],map.get(nums2[x])-1);
                    nums2[x]+=val;
                    map.put(nums2[x],map.getOrDefault(nums2[x],0)+1);
                    continue;
                }
                int limit=Math.min(n,(x+sqrt-1)/sqrt*sqrt);
                while(x<limit){
                    map.put(nums2[x],map.get(nums2[x])-1);
                    nums2[x]+=val;
                    map.put(nums2[x],map.getOrDefault(nums2[x],0)+1);
                    x++;
                }
                limit=Math.max(0,(y+1)/sqrt*sqrt);
                while(y>=limit){
                    map.put(nums2[y],map.get(nums2[y])-1);
                    nums2[y]+=val;
                    map.put(nums2[y],map.getOrDefault(nums2[y],0)+1);
