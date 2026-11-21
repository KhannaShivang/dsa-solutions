/**
 * Problem: 3331. Find Subtree Sizes After Changes
 * Difficulty: Medium
 * Language: Java
 * Runtime: 0 ms
 * Memory: N/A
 * LeetCode: https://leetcode.com/problems/find-subtree-sizes-after-changes/
 */

class Solution {
    private void makeChanges(int node,List<Integer>[]tree,
    int[]parent,Stack<Integer>[]identicalCharacters,String s){
        int ch=s.charAt(node)-'a';
        if(!identicalCharacters[ch].isEmpty()){
            parent[node]=identicalCharacters[ch].peek();
        }
        identicalCharacters[ch].push(node);
        for(int i:tree[node]){
            makeChanges(i,tree,parent,identicalCharacters,s);
        }
        identicalCharacters[ch].pop();
    }
    private void getSubtreeSizes(int node,List<Integer>[]tree,int[]subtreeSizes){
        subtreeSizes[node]=1;
        for(int i:tree[node]){
            getSubtreeSizes(i,tree,subtreeSizes);
            subtreeSizes[node]+=subtreeSizes[i];
        }
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
        makeChanges(0,tree,parent,identicalCharacters,s);
        for(int i=0;i<n;i++){
            tree[i].clear();
        }
        for(int i=1;i<n;i++){
            tree[parent[i]].add(i);
        }
        int[]subtreeSizes=new int[n];
        getSubtreeSizes(0,tree,subtreeSizes);
        return subtreeSizes;
    }
}
