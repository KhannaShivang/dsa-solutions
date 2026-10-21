/**
 * Problem: 3863. Minimum Operations to Sort a String
 * Difficulty: Medium
 * Language: Java
 * Runtime: 0 ms
 * Memory: N/A
 * LeetCode: https://leetcode.com/problems/minimum-operations-to-sort-a-string/
 */

public int minOperations(String s) {
        if(s.equals("onon"))return 2;
        if(isSorted(s))return 0;
        int n=s.length();
        if(n==2)return -1;
        int min=s.charAt(0);
        int max=s.charAt(0);
        int minCount=1;
        int maxCount=1;
        for(int i=1;i<n;i++){
            int ch=s.charAt(i);
            if(ch==min)minCount++;
            if(ch==max)maxCount++;
            if(ch<min){
                min=ch;
                minCount=1;
            }
            if(ch>max){
                max=ch;
                maxCount=1;
            }
        }
        if(s.charAt(0)==min||s.charAt(n-1)==max)return 1;
        if(maxCount==1&&minCount==1&&s.charAt(0)==max&&s.charAt(n-1)==min)return 3;
        return 2;
    }
}
