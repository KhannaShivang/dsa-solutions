/**
 * Problem: 3943. Number of Pairs After Increment
 * Difficulty: Hard
 * Language: Java
 * Runtime: 53 ms
 * Memory: N/A
 * LeetCode: https://leetcode.com/problems/number-of-pairs-after-increment/
 */

int tot=q[1];
                int pairs=0;
                for(long num:nums1){
                    for(int i=0;i<sqrt;i++){
                        long curr=tot-num-decomposition[i];
                        pairs+=map[i].getOrDefault(curr,0);
                    }
                }
                res.add(pairs);
            }
        }
        n=res.size();
        int[]ans=new int[n];
        for(int i=0;i<n;i++){
            ans[i]=res.get(i);
        }
        return ans;
    }
}
