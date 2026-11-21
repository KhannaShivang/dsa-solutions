/**
 * Problem: 3331. Find Subtree Sizes After Changes
 * Difficulty: Medium
 * Language: Java
 * Runtime: 173
ms
 * Memory: 238.31
MB
 * LeetCode: https://leetcode.com/problems/find-subtree-sizes-after-changes/
 */

class Solution {
    private int makeChanges(int node,List<Integer>[]tree,
    Stack<Integer>[]identicalCharacters,String s,int[]subtreeSizes){
        int ch=s.charAt(node)-'a';
        int last=-1;
        if(!identicalCharacters[ch].isEmpty()){
            last=identicalCharacters[ch].peek();
        }
        identicalCharacters[ch].push(node);
        subtreeSizes[node]=1;
        for(int i:tree[node]){
            int curr=makeChanges(i,tree,identicalCharacters,s,subtreeSizes);
            subtreeSizes[node]+=curr;
        }
        identicalCharacters[ch].pop();
        if(last!=-1){
            subtreeSizes[last]+=subtreeSizes[node];
            return 0;
        }
        return subtreeSizes[node];
    }
    public int[] findSubtreeSizes(int[] parent, String s) {
        Stack<Integer>[]identicalCharacters=new Stack[26];
        for(int i=0;i<26;i++){
            identicalCharacters[i]=new Stack<>();
        }
        int n=parent.length;
        List<Integer>tree[]=new ArrayList[n]; 
        for(int i=0;i<n;i++){
            tree[i]=new ArrayList<>();
        }
        for(int i=1;i<n;i++){
            tree[parent[i]].add(i);
        }
        int[]subtreeSizes=new int[n];
        makeChanges(0,tree,identicalCharacters,s,subtreeSizes);
        return subtreeSizes;
    }
}
