/**
 * Problem: 3943. Number of Pairs After Increment
 * Difficulty: Hard
 * Language: Java
 * Runtime: N/A
 * Memory: N/A
 * LeetCode: https://leetcode.com/problems/number-of-pairs-after-increment/
 */

t);
                while(y>=limit){
                    map.put(nums2[y],map.get(nums2[y])-1);
                    nums2[y]+=val;
                    map.put(nums2[y],map.getOrDefault(nums2[y],0)+1);
                    y--;
                }
                for(int i=x/sqrt;i<=y/sqrt;i++){
                    decomposition[i]+=val;
                }
            }
            else{
                int tot=q[1];
                for(int i=0;i<sqrt;i++){
                    if(decomposition[i]>0){
                        for(int j=0;j<sqrt;j++){
                            int idx=i*sqrt+j;
                            map.put(nums2[idx],map.get(nums2[idx])-1);
                            nums2[idx]+=decomposition[i];
                            map.put(nums2[idx],map.getOrDefault(nums2[idx],0)+1);
                        }
                        decomposition[i]=0;
                    }
                }
                int pairs=0;
                for(int i:nums1){
